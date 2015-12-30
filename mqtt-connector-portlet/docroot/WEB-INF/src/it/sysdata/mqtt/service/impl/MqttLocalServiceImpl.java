/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.sysdata.mqtt.service.impl;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

import it.sysdata.mqtt.service.base.MqttLocalServiceBaseImpl;
import it.sysdata.mqtt.util.ConfigUtil;
import it.sysdata.mqtt.util.PortletPropsKeys;
import it.sysdata.mqtt.util.PortletPropsValues;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.mail.internet.InternetAddress;

import javax.portlet.PortletPreferences;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * The implementation of the mqtt local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.sysdata.mqtt.service.MqttLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author @baxtheman
 * @see it.sysdata.mqtt.service.base.MqttLocalServiceBaseImpl
 * @see it.sysdata.mqtt.service.MqttLocalServiceUtil
 */
public class MqttLocalServiceImpl extends MqttLocalServiceBaseImpl
	implements MqttCallback {

	@Override
	public void applySubscriptionsList() throws MqttException, SystemException {

		String[] subscriptions =
			PrefsPropsUtil.getStringArray(
				PortletPropsKeys.MQTT_SUBSCRIPTIONS_LIST, StringPool.NEW_LINE,
				PortletPropsValues.MQTT_SUBSCRIPTIONS_ARRAY);

		if (_getInstance().isConnected()) {
			String[] topics = ConfigUtil.properties2topic(subscriptions);

			int[] qos = ConfigUtil.properties2qos(subscriptions);

			for (int i = 0; i<topics.length; i++) {
				subscribe(topics[i], qos[i]);
			}
		}
	}

	@Override
	public boolean connect() throws MqttException, SystemException {

		try {
			disconnect();

			String username =
				PrefsPropsUtil.getString(
					PortletPropsKeys.MQTT_BROKER_USERNAME,
					PortletPropsValues.MQTT_BROKER_USERNAME);

			String password =
				PrefsPropsUtil.getString(
					PortletPropsKeys.MQTT_BROKER_PASSWORD,
					PortletPropsValues.MQTT_BROKER_PASSWORD);

			int keepalive =
				PrefsPropsUtil.getInteger(
					PortletPropsKeys.MQTT_BROKER_KEEPALIVE,
					PortletPropsValues.MQTT_BROKER_KEEPALIVE);

			MqttClient client = _getInstance();

			MqttConnectOptions options = new MqttConnectOptions();

			options.setCleanSession(true);
			options.setKeepAliveInterval(keepalive);

			if (Validator.isNotNull(username)) {
				options.setUserName(username);
				options.setPassword(password.toCharArray());
			}

			IMqttToken token = client.connectWithResult(options);

			_log.info("connected: " + client.getServerURI());

			applySubscriptionsList();

			_noRetry();

			// send event to message bus

			_notifyEvent(client,"connect");
		}
		catch (MqttException e) {
			_log.error(e);

			throw e;
		}

		return isConnected();
	}

	@Override
	public void connectionLost(Throwable e) {

		_log.error(e);

		// send message bus event

		_notifyEvent(null, "connectionLost", e);

		// send email alert

		_notityMail("connectionLost", e);

		// clear instance

		_clearInstance();

		// setup retry connection

		_setupRetry(e);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

		// not yet useful
	}

	@Override
	public boolean disconnect() throws MqttException, SystemException {

		MqttClient client = _getInstance();

		if (client.isConnected()) {
			client.disconnectForcibly();

			_log.info("close " + client.getServerURI());
		}

		// send event to message bus

		_notifyEvent(client,"disconnect");

		// clear client object

		_clearInstance();

		return true;
	}

	@Override
	public String getServerConnected() throws MqttException, SystemException {

		return _getInstance().getServerURI();
	}

	@Override
	public boolean isConnected() {

		try {
			return _getInstance().isConnected();
		}
		catch (SystemException | MqttException e) {
			_log.warn(e);
		}

		return false;
	}

	@Override
	public void messageArrived(String topic, MqttMessage message)
		throws Exception {

		Message mb = new Message();

		mb.put("topic", topic);
		mb.put("qos", message.getQos());
		mb.put("retained", message.isRetained());

		String payload = new String(message.getPayload());

		mb.setPayload(payload);

		MessageBusUtil.sendMessage(
			PortletPropsValues.MQTT_MESSAGES_DESTINATION, mb);

		boolean logInfo = PrefsPropsUtil.getBoolean(
			PortletPropsKeys.MQTT_EVENTS_LOGINFO,
			PortletPropsValues.MQTT_EVENTS_LOGINFO);

		if (logInfo) {
			_log.info(String.format("arrived [%s,%s,%s] %s",
				topic, message.getQos(), message.isRetained()?"R":"",
					payload));
		}
	}

	@Override
	public void publish(String topic, byte[] payload, int qos)
					throws MqttException, SystemException {

		_getInstance().publish(topic, payload, qos, false);

		boolean logInfo = PrefsPropsUtil.getBoolean(
			PortletPropsKeys.MQTT_EVENTS_LOGINFO,
			PortletPropsValues.MQTT_EVENTS_LOGINFO);

		if (logInfo) {
			_log.info(String.format("send [%s,%s] %s",
				topic, qos, payload));
		}
	}

	@Override
	public void publish(String topic, String payload, int qos)
					throws MqttException, SystemException {

		publish(topic, payload.getBytes(), qos);
	}

	@Override
	public void resetSubscriptionsList() throws MqttException, SystemException {

		String[] subscriptions =
			PrefsPropsUtil.getStringArray(
				PortletPropsKeys.MQTT_SUBSCRIPTIONS_LIST, StringPool.NEW_LINE,
				PortletPropsValues.MQTT_SUBSCRIPTIONS_ARRAY);

		if (_getInstance().isConnected()) {
			String[] topics = ConfigUtil.properties2topic(subscriptions);

			_getInstance().unsubscribe(topics);
		}
	}

	@Override
	public void subscribe(String topic, int qos)
		throws MqttException, SystemException {

		_getInstance().subscribe(topic, qos);

		boolean logInfo = PrefsPropsUtil.getBoolean(
			PortletPropsKeys.MQTT_EVENTS_LOGINFO,
			PortletPropsValues.MQTT_EVENTS_LOGINFO);

		if (logInfo) {
			_log.info("subscribe " + topic);
		}
	}

	private void _clearInstance() {

		_mqttClient = null;
	}

	private synchronized MqttClient _getInstance()
		throws MqttException, SystemException {

		if (_mqttClient == null) {
			String serverURI =
				PrefsPropsUtil.getString(
					PortletPropsKeys.MQTT_BROKER_URL,
					PortletPropsValues.MQTT_BROKER_URL);

			String clientID =
				PrefsPropsUtil.getString(
					PortletPropsKeys.MQTT_BROKER_CLIENTID,
					PortletPropsValues.MQTT_BROKER_CLIENTID);

			MemoryPersistence persistence = new MemoryPersistence();

			_mqttClient = new MqttClient(serverURI, clientID, persistence);

			_mqttClient.setCallback(this);
		}

		return _mqttClient;
	}

	private void _noRetry() {

		try {
			PortletPreferences portletPreferences =
							PrefsPropsUtil.getPreferences();

			portletPreferences.setValue(
				PortletPropsKeys.MQTT_ERRORS_RETRY_CONNECT,
				String.valueOf(false));

			portletPreferences.store();
		}
		catch (Exception e1) {
			_log.error(e1);
		}
	}

	private void _notifyEvent(MqttClient client, String event, Throwable e) {

		Message mb = new Message();

		mb.put("event", event);

		if (client != null) {
			mb.put("brokerUrl", client.getServerURI());
		}

		if (e != null) {
			mb.put("error", e.getMessage());
		}

		MessageBusUtil.sendMessage(
			PortletPropsValues.MQTT_EVENTS_DESTINATION, mb);
	}

	private void _notifyEvent(MqttClient client, String event) {

		_notifyEvent(client,event,null);
	}

	private void _notityMail(String context, Throwable e) {

		try {
			String errorMailTo =
				PrefsPropsUtil.getString(
					PortletPropsKeys.MQTT_ERRORS_SEND_MAIL_TO,
					PortletPropsValues.MQTT_ERRORS_SEND_MAIL_TO);

			if (Validator.isNotNull(errorMailTo)) {
				MailMessage mailMessage = new MailMessage();

				long companyId = PortalUtil.getDefaultCompanyId();

				String fromAddress = PrefsPropsUtil.getString(
					companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

				mailMessage.setHTMLFormat(false);
				mailMessage.setTo(new InternetAddress(errorMailTo));
				mailMessage.setSubject(String.format(
					"%s Mqtt connector error", PortalUtil.getComputerName()));
				mailMessage.setFrom(new InternetAddress(fromAddress));

				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);

				mailMessage.setBody(String.format(
					"context: %s\nerror: %s\n stacktrace:%s\n", context,
					e.getMessage(), sw.toString()));

				MailServiceUtil.sendEmail(mailMessage);
			}
		}
		catch (Exception e1) {
			_log.error(e1);
		}
	}

	private void _setupRetry(Throwable e) {

		try {
			PortletPreferences portletPreferences =
				PrefsPropsUtil.getPreferences();

			portletPreferences.setValue(
				PortletPropsKeys.MQTT_ERRORS_RETRY_CONNECT,
				String.valueOf(true));

			portletPreferences.store();
		}
		catch (Exception e1) {
			_log.error(e);
		}
	}

	private static MqttClient _mqttClient;

	private static Log _log = LogFactoryUtil.getLog(MqttLocalServiceImpl.class);
}