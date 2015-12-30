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

package it.sysdata.mqtt.service.base;

import it.sysdata.mqtt.service.MqttLocalServiceUtil;

import java.util.Arrays;

/**
 * @author @baxtheman
 * @generated
 */
public class MqttLocalServiceClpInvoker {
	public MqttLocalServiceClpInvoker() {
		_methodName14 = "getBeanIdentifier";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "setBeanIdentifier";

		_methodParameterTypes15 = new String[] { "java.lang.String" };

		_methodName18 = "applySubscriptionsList";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "connect";

		_methodParameterTypes19 = new String[] {  };

		_methodName20 = "connectionLost";

		_methodParameterTypes20 = new String[] { "java.lang.Throwable" };

		_methodName21 = "deliveryComplete";

		_methodParameterTypes21 = new String[] {
				"org.eclipse.paho.client.mqttv3.IMqttDeliveryToken"
			};

		_methodName22 = "disconnect";

		_methodParameterTypes22 = new String[] {  };

		_methodName23 = "getServerConnected";

		_methodParameterTypes23 = new String[] {  };

		_methodName24 = "isConnected";

		_methodParameterTypes24 = new String[] {  };

		_methodName25 = "messageArrived";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "org.eclipse.paho.client.mqttv3.MqttMessage"
			};

		_methodName26 = "publish";

		_methodParameterTypes26 = new String[] {
				"java.lang.String", "byte[][]", "int"
			};

		_methodName27 = "publish";

		_methodParameterTypes27 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName28 = "resetSubscriptionsList";

		_methodParameterTypes28 = new String[] {  };

		_methodName29 = "subscribe";

		_methodParameterTypes29 = new String[] { "java.lang.String", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return MqttLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			MqttLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			MqttLocalServiceUtil.applySubscriptionsList();

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return MqttLocalServiceUtil.connect();
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			MqttLocalServiceUtil.connectionLost((java.lang.Throwable)arguments[0]);

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			MqttLocalServiceUtil.deliveryComplete((org.eclipse.paho.client.mqttv3.IMqttDeliveryToken)arguments[0]);

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return MqttLocalServiceUtil.disconnect();
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return MqttLocalServiceUtil.getServerConnected();
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return MqttLocalServiceUtil.isConnected();
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			MqttLocalServiceUtil.messageArrived((java.lang.String)arguments[0],
				(org.eclipse.paho.client.mqttv3.MqttMessage)arguments[1]);

			return null;
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			MqttLocalServiceUtil.publish((java.lang.String)arguments[0],
				(byte[])arguments[1], ((Integer)arguments[2]).intValue());

			return null;
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			MqttLocalServiceUtil.publish((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());

			return null;
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			MqttLocalServiceUtil.resetSubscriptionsList();

			return null;
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			MqttLocalServiceUtil.subscribe((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
}