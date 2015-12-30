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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Mqtt. This utility wraps
 * {@link it.sysdata.mqtt.service.impl.MqttLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author @baxtheman
 * @see MqttLocalService
 * @see it.sysdata.mqtt.service.base.MqttLocalServiceBaseImpl
 * @see it.sysdata.mqtt.service.impl.MqttLocalServiceImpl
 * @generated
 */
public class MqttLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.sysdata.mqtt.service.impl.MqttLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void applySubscriptionsList()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		getService().applySubscriptionsList();
	}

	public static boolean connect()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		return getService().connect();
	}

	public static void connectionLost(java.lang.Throwable e) {
		getService().connectionLost(e);
	}

	public static void deliveryComplete(
		org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token) {
		getService().deliveryComplete(token);
	}

	public static boolean disconnect()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		return getService().disconnect();
	}

	public static java.lang.String getServerConnected()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		return getService().getServerConnected();
	}

	public static boolean isConnected() {
		return getService().isConnected();
	}

	public static void messageArrived(java.lang.String topic,
		org.eclipse.paho.client.mqttv3.MqttMessage message)
		throws java.lang.Exception {
		getService().messageArrived(topic, message);
	}

	public static void publish(java.lang.String topic, byte[] payload, int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		getService().publish(topic, payload, qos);
	}

	public static void publish(java.lang.String topic,
		java.lang.String payload, int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		getService().publish(topic, payload, qos);
	}

	public static void resetSubscriptionsList()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		getService().resetSubscriptionsList();
	}

	public static void subscribe(java.lang.String topic, int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		getService().subscribe(topic, qos);
	}

	public static void clearService() {
		_service = null;
	}

	public static MqttLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MqttLocalService.class.getName());

			if (invokableLocalService instanceof MqttLocalService) {
				_service = (MqttLocalService)invokableLocalService;
			}
			else {
				_service = new MqttLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MqttLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MqttLocalService service) {
	}

	private static MqttLocalService _service;
}