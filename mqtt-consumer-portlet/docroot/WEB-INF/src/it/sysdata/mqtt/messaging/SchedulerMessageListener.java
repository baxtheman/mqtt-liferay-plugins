package it.sysdata.mqtt.messaging;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.util.PwdGenerator;

/**
 * @author @baxtheman
 */
public class SchedulerMessageListener implements MessageListener {

	@Override
	public void receive(Message message) {

		try {
			Message mb = new Message();

			mb.put("topic", "Sysdata-AG/aaaa/" + PwdGenerator.getPassword(4));

			mb.setPayload(PwdGenerator.getPassword(64).getBytes());

			MessageBusUtil.sendMessage("mqtt/publish", mb);

			_log.info(mb.toString());
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SchedulerMessageListener.class);
}