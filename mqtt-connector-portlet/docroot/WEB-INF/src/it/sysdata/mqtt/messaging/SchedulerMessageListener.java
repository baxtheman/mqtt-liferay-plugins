package it.sysdata.mqtt.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.PrefsPropsUtil;

import it.sysdata.mqtt.service.MqttLocalServiceUtil;
import it.sysdata.mqtt.util.PortletPropsKeys;
import it.sysdata.mqtt.util.PortletPropsValues;

import javax.portlet.PortletPreferences;

/**
 * @author @baxtheman
 */
public class SchedulerMessageListener implements MessageListener {

	@Override
	public void receive(Message message) {

		try {
			boolean brokerActive =
				PrefsPropsUtil.getBoolean(
					PortletPropsKeys.MQTT_AUTO_CONNECT,
					PortletPropsValues.MQTT_AUTO_CONNECT);

			boolean retryConnect = PrefsPropsUtil.getBoolean(
				PortletPropsKeys.MQTT_ERRORS_RETRY_CONNECT);

			if (brokerActive && retryConnect) {

				// reset retry

				PortletPreferences portletPreferences =
					PrefsPropsUtil.getPreferences();

				portletPreferences.setValue(
					PortletPropsKeys.MQTT_ERRORS_RETRY_CONNECT,
					String.valueOf(false));

				portletPreferences.store();

				// try connect

				MqttLocalServiceUtil.connect();
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SchedulerMessageListener.class);
}