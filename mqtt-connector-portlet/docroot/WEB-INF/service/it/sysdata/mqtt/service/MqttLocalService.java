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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for Mqtt. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author @baxtheman
 * @see MqttLocalServiceUtil
 * @see it.sysdata.mqtt.service.base.MqttLocalServiceBaseImpl
 * @see it.sysdata.mqtt.service.impl.MqttLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MqttLocalService extends BaseLocalService, InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MqttLocalServiceUtil} to access the mqtt local service. Add custom service methods to {@link it.sysdata.mqtt.service.impl.MqttLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public void applySubscriptionsList()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException;

	public boolean connect()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException;

	public void connectionLost(java.lang.Throwable e);

	public void deliveryComplete(
		org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token);

	public boolean disconnect()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getServerConnected()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isConnected();

	public void messageArrived(java.lang.String topic,
		org.eclipse.paho.client.mqttv3.MqttMessage message)
		throws java.lang.Exception;

	public void publish(java.lang.String topic, byte[] payload, int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException;

	public void publish(java.lang.String topic, java.lang.String payload,
		int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException;

	public void resetSubscriptionsList()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException;

	public void subscribe(java.lang.String topic, int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException;
}