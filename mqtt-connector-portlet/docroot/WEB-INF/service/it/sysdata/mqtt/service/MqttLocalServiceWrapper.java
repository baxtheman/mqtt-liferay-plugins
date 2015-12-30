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

package it.sysdata.mqtt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MqttLocalService}.
 *
 * @author @baxtheman
 * @see MqttLocalService
 * @generated
 */
public class MqttLocalServiceWrapper implements MqttLocalService,
	ServiceWrapper<MqttLocalService> {
	public MqttLocalServiceWrapper(MqttLocalService mqttLocalService) {
		_mqttLocalService = mqttLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _mqttLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_mqttLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _mqttLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void applySubscriptionsList()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		_mqttLocalService.applySubscriptionsList();
	}

	@Override
	public boolean connect()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		return _mqttLocalService.connect();
	}

	@Override
	public void connectionLost(java.lang.Throwable e) {
		_mqttLocalService.connectionLost(e);
	}

	@Override
	public void deliveryComplete(
		org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token) {
		_mqttLocalService.deliveryComplete(token);
	}

	@Override
	public boolean disconnect()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		return _mqttLocalService.disconnect();
	}

	@Override
	public java.lang.String getServerConnected()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		return _mqttLocalService.getServerConnected();
	}

	@Override
	public boolean isConnected() {
		return _mqttLocalService.isConnected();
	}

	@Override
	public void messageArrived(java.lang.String topic,
		org.eclipse.paho.client.mqttv3.MqttMessage message)
		throws java.lang.Exception {
		_mqttLocalService.messageArrived(topic, message);
	}

	@Override
	public void publish(java.lang.String topic, byte[] payload, int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		_mqttLocalService.publish(topic, payload, qos);
	}

	@Override
	public void publish(java.lang.String topic, java.lang.String payload,
		int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		_mqttLocalService.publish(topic, payload, qos);
	}

	@Override
	public void resetSubscriptionsList()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		_mqttLocalService.resetSubscriptionsList();
	}

	@Override
	public void subscribe(java.lang.String topic, int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		_mqttLocalService.subscribe(topic, qos);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MqttLocalService getWrappedMqttLocalService() {
		return _mqttLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMqttLocalService(MqttLocalService mqttLocalService) {
		_mqttLocalService = mqttLocalService;
	}

	@Override
	public MqttLocalService getWrappedService() {
		return _mqttLocalService;
	}

	@Override
	public void setWrappedService(MqttLocalService mqttLocalService) {
		_mqttLocalService = mqttLocalService;
	}

	private MqttLocalService _mqttLocalService;
}