package it.sysdata.mqtt.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.portlet.PortletProps;

/**
 *  @author @baxtheman
 */
public class PortletPropsValues {

	public static final boolean MQTT_AUTO_CONNECT = GetterUtil.getBoolean(
		PortletProps.get(PortletPropsKeys.MQTT_AUTO_CONNECT));

	public static final String MQTT_BROKER_CLIENTID = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.MQTT_BROKER_CLIENTID));

	public static final int MQTT_BROKER_KEEPALIVE = GetterUtil.getInteger(
		PortletProps.get(PortletPropsKeys.MQTT_BROKER_KEEPALIVE));

	public static final String MQTT_BROKER_PASSWORD = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.MQTT_BROKER_PASSWORD));

	public static final boolean MQTT_BROKER_SSL = GetterUtil.getBoolean(
		PortletProps.get(PortletPropsKeys.MQTT_BROKER_SSL));

	public static final String MQTT_BROKER_URL = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.MQTT_BROKER_URL));

	public static final String MQTT_BROKER_USERNAME = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.MQTT_BROKER_USERNAME));

	public static final String MQTT_EVENTS_DESTINATION = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.MQTT_EVENTS_DESTINATION));

	public static final String MQTT_ERRORS_SEND_MAIL_TO = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.MQTT_ERRORS_SEND_MAIL_TO));

	public static final String MQTT_MESSAGES_DESTINATION = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.MQTT_MESSAGES_DESTINATION));

	public static final boolean MQTT_EVENTS_LOGINFO = GetterUtil.getBoolean(
		PortletProps.get(PortletPropsKeys.MQTT_EVENTS_LOGINFO));

	public static final String MQTT_SUBSCRIPTIONS_LIST = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.MQTT_SUBSCRIPTIONS_LIST));

	public static final String[] MQTT_SUBSCRIPTIONS_ARRAY = StringUtil.split(
		PortletProps.get(PortletPropsKeys.MQTT_SUBSCRIPTIONS_LIST),
		StringPool.NEW_LINE);
}