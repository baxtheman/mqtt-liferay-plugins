package it.sysdata.mqtt.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

/**
 * @author baxtheman
 */
public class MQTTArrivedMessageListener implements MessageListener {

	@Override
	public void receive(Message message) {
	}

	private static Log _log = LogFactoryUtil.getLog(
		MQTTArrivedMessageListener.class);
}