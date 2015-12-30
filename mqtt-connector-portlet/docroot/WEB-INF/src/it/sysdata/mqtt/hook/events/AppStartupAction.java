package it.sysdata.mqtt.hook.events;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;

import it.sysdata.mqtt.service.MqttLocalServiceUtil;
import it.sysdata.mqtt.util.PortletPropsKeys;
import it.sysdata.mqtt.util.PortletPropsValues;

import org.eclipse.paho.client.mqttv3.MqttException;
public class AppStartupAction extends SimpleAction {

	public AppStartupAction() {
		super();
	}

	public void run(String[] arg0) throws ActionException {

		try {
			boolean brokerActive =
				PrefsPropsUtil.getBoolean(
					PortletPropsKeys.MQTT_AUTO_CONNECT,
					PortletPropsValues.MQTT_AUTO_CONNECT);

			if (brokerActive) {
				MqttLocalServiceUtil.connect();
			}
		}
		catch (SystemException | MqttException e) {
			_log.error(e);

			throw new ActionException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AppStartupAction.class);
}