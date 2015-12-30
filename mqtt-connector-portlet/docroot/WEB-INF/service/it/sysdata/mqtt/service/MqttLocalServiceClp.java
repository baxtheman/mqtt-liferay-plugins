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

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author @baxtheman
 * @generated
 */
public class MqttLocalServiceClp implements MqttLocalService {
	public MqttLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "applySubscriptionsList";

		_methodParameterTypes3 = new String[] {  };

		_methodName4 = "connect";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "connectionLost";

		_methodParameterTypes5 = new String[] { "java.lang.Throwable" };

		_methodName6 = "deliveryComplete";

		_methodParameterTypes6 = new String[] {
				"org.eclipse.paho.client.mqttv3.IMqttDeliveryToken"
			};

		_methodName7 = "disconnect";

		_methodParameterTypes7 = new String[] {  };

		_methodName8 = "getServerConnected";

		_methodParameterTypes8 = new String[] {  };

		_methodName9 = "isConnected";

		_methodParameterTypes9 = new String[] {  };

		_methodName10 = "messageArrived";

		_methodParameterTypes10 = new String[] {
				"java.lang.String", "org.eclipse.paho.client.mqttv3.MqttMessage"
			};

		_methodName11 = "publish";

		_methodParameterTypes11 = new String[] {
				"java.lang.String", "byte[][]", "int"
			};

		_methodName12 = "publish";

		_methodParameterTypes12 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName13 = "resetSubscriptionsList";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "subscribe";

		_methodParameterTypes14 = new String[] { "java.lang.String", "int" };
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public void applySubscriptionsList()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		try {
			_invokableLocalService.invokeMethod(_methodName3,
				_methodParameterTypes3, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.eclipse.paho.client.mqttv3.MqttException) {
				throw (org.eclipse.paho.client.mqttv3.MqttException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public boolean connect()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.eclipse.paho.client.mqttv3.MqttException) {
				throw (org.eclipse.paho.client.mqttv3.MqttException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public void connectionLost(java.lang.Throwable e) {
		try {
			_invokableLocalService.invokeMethod(_methodName5,
				_methodParameterTypes5,
				new Object[] { ClpSerializer.translateInput(e) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void deliveryComplete(
		org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token) {
		try {
			_invokableLocalService.invokeMethod(_methodName6,
				_methodParameterTypes6,
				new Object[] { ClpSerializer.translateInput(token) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public boolean disconnect()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.eclipse.paho.client.mqttv3.MqttException) {
				throw (org.eclipse.paho.client.mqttv3.MqttException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public java.lang.String getServerConnected()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.eclipse.paho.client.mqttv3.MqttException) {
				throw (org.eclipse.paho.client.mqttv3.MqttException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isConnected() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public void messageArrived(java.lang.String topic,
		org.eclipse.paho.client.mqttv3.MqttMessage message)
		throws java.lang.Exception {
		try {
			_invokableLocalService.invokeMethod(_methodName10,
				_methodParameterTypes10,
				new Object[] {
					ClpSerializer.translateInput(topic),
					
				ClpSerializer.translateInput(message)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void publish(java.lang.String topic, byte[] payload, int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		try {
			_invokableLocalService.invokeMethod(_methodName11,
				_methodParameterTypes11,
				new Object[] {
					ClpSerializer.translateInput(topic),
					
				ClpSerializer.translateInput(payload),
					
				qos
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.eclipse.paho.client.mqttv3.MqttException) {
				throw (org.eclipse.paho.client.mqttv3.MqttException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void publish(java.lang.String topic, java.lang.String payload,
		int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		try {
			_invokableLocalService.invokeMethod(_methodName12,
				_methodParameterTypes12,
				new Object[] {
					ClpSerializer.translateInput(topic),
					
				ClpSerializer.translateInput(payload),
					
				qos
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.eclipse.paho.client.mqttv3.MqttException) {
				throw (org.eclipse.paho.client.mqttv3.MqttException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void resetSubscriptionsList()
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		try {
			_invokableLocalService.invokeMethod(_methodName13,
				_methodParameterTypes13, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.eclipse.paho.client.mqttv3.MqttException) {
				throw (org.eclipse.paho.client.mqttv3.MqttException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void subscribe(java.lang.String topic, int qos)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.eclipse.paho.client.mqttv3.MqttException {
		try {
			_invokableLocalService.invokeMethod(_methodName14,
				_methodParameterTypes14,
				new Object[] { ClpSerializer.translateInput(topic), qos });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.eclipse.paho.client.mqttv3.MqttException) {
				throw (org.eclipse.paho.client.mqttv3.MqttException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
}