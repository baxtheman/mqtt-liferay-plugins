package it.sysdata.mqtt.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

/**
 * @author baxtheman
 */
public class ConsumerEventMessageListener implements MessageListener {

	@Override
	public void receive(Message message) {

		_log.info(message.toString());
	}

	private static Log _log = LogFactoryUtil.getLog(
		ConsumerEventMessageListener.class);
}