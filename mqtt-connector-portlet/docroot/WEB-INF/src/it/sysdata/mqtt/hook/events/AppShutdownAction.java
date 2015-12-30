package it.sysdata.mqtt.hook.events;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.sysdata.mqtt.service.MqttLocalServiceUtil;

import org.eclipse.paho.client.mqttv3.MqttException;
public class AppShutdownAction extends SimpleAction {

	@Override
	public void run(String[] arg0) throws ActionException {
		try {
			MqttLocalServiceUtil.disconnect();
		}
		catch (MqttException | SystemException e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AppShutdownAction.class);
}