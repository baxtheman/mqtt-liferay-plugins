package it.sysdata.mqtt.messaging;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import it.sysdata.mqtt.service.MqttLocalServiceUtil;

import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * @author @baxtheman
 */
public class MqttPublishMessageListener implements MessageListener {

	@Override
	public void receive(Message message) {

		String topic = message.getString("topic");
		int qos = message.getInteger("qos");
		byte[] payload = (byte[])message.getPayload();

		try {
			if (!MqttLocalServiceUtil.isConnected()) {
				MqttLocalServiceUtil.connect();
			}

			MqttLocalServiceUtil.publish(topic, payload, qos);
		}
		catch (SystemException | MqttException e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MqttPublishMessageListener.class);
}