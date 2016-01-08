
package it.sysdata.mqtt.portlet;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.sysdata.mqtt.service.MqttLocalServiceUtil;
import it.sysdata.mqtt.util.PortletPropsKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * @author @baxtheman
 */
public class MQTTConfigPortlet extends MVCPortlet {

	public void connect(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		MqttLocalServiceUtil.connect();
	}

	public void disconnect(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		MqttLocalServiceUtil.disconnect();
	}

	public void publishTest(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String topic = ParamUtil.getString(actionRequest, "topic");
		int qos= ParamUtil.getInteger(actionRequest, "qos");
		String payload = ParamUtil.getString(actionRequest, "payload");

		if (MqttLocalServiceUtil.isConnected()) {
			MqttLocalServiceUtil.publish(topic, payload, qos);
		}

		SessionMessages.add(
			actionRequest, "success-testing");
	}

	public void saveSubscriptions(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		MqttLocalServiceUtil.resetSubscriptionsList();

		PortletPreferences portletPreferences = PrefsPropsUtil.getPreferences();

		String subscriptions = ParamUtil.getString(actionRequest, "subscriptions");

		boolean logInfo = ParamUtil.getBoolean(actionRequest, "logInfo");

		portletPreferences.setValue(
			PortletPropsKeys.MQTT_SUBSCRIPTIONS_LIST, subscriptions);
		portletPreferences.setValue(
			PortletPropsKeys.MQTT_EVENTS_LOGINFO, String.valueOf(logInfo));

		portletPreferences.store();

		MqttLocalServiceUtil.applySubscriptionsList();

		SessionMessages.add(
			actionRequest, "success-save-subscriptions");
	}

	public void updatePreferences(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		PortletPreferences portletPreferences = PrefsPropsUtil.getPreferences();

		boolean autoConnect = ParamUtil.getBoolean(
			actionRequest, "autoConnect");

		String brokerUrl = ParamUtil.getString(actionRequest, "brokerUrl");

		String clientID = ParamUtil.getString(actionRequest, "clientID");

		String username = ParamUtil.getString(actionRequest, "username");

		String password = ParamUtil.getString(actionRequest, "password");

		boolean ssl = ParamUtil.getBoolean(actionRequest, "ssl");

		portletPreferences.setValue(
			PortletPropsKeys.MQTT_AUTO_CONNECT, String.valueOf(autoConnect));
		portletPreferences.setValue(PortletPropsKeys.MQTT_BROKER_URL, brokerUrl);
		portletPreferences.setValue(PortletPropsKeys.MQTT_BROKER_CLIENTID, clientID);
		portletPreferences.setValue(
			PortletPropsKeys.MQTT_BROKER_USERNAME, username);
		portletPreferences.setValue(
			PortletPropsKeys.MQTT_BROKER_PASSWORD, password);
		portletPreferences.setValue(
			PortletPropsKeys.MQTT_BROKER_SSL, String.valueOf(ssl));

		portletPreferences.store();

		MqttLocalServiceUtil.disconnect();

		if (autoConnect) {
			MqttLocalServiceUtil.connect();
		}

		SessionMessages.add(
			actionRequest, "success-save-preferences");

		sendRedirect(actionRequest, actionResponse);
	}

	@Override
	protected boolean isSessionErrorException(Throwable cause) {

		if (cause instanceof MqttException) {
			return true;
		}

		return super.isSessionErrorException(cause);
	}
}