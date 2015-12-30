<%@ page import="it.sysdata.mqtt.service.MqttLocalServiceUtil" %>
<%@ page import="it.sysdata.mqtt.util.PortletPropsKeys" %>
<%@ page import="it.sysdata.mqtt.util.PortletPropsValues" %>

<%@ page import="org.eclipse.paho.client.mqttv3.MqttException" %>

<%@ include file="/html/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "broker");

boolean connected = MqttLocalServiceUtil.isConnected();

boolean autoConnect = PrefsPropsUtil.getBoolean(PortletPropsKeys.MQTT_AUTO_CONNECT, PortletPropsValues.MQTT_AUTO_CONNECT);

String brokerUrl = PrefsPropsUtil.getString(PortletPropsKeys.MQTT_BROKER_URL, PortletPropsValues.MQTT_BROKER_URL);
String clientID = PrefsPropsUtil.getString(PortletPropsKeys.MQTT_BROKER_CLIENTID, PortletPropsValues.MQTT_BROKER_CLIENTID);
String username = PrefsPropsUtil.getString(PortletPropsKeys.MQTT_BROKER_USERNAME, PortletPropsValues.MQTT_BROKER_USERNAME);
String password = PrefsPropsUtil.getString(PortletPropsKeys.MQTT_BROKER_PASSWORD, PortletPropsValues.MQTT_BROKER_PASSWORD);
boolean ssl = PrefsPropsUtil.getBoolean(PortletPropsKeys.MQTT_BROKER_SSL, PortletPropsValues.MQTT_BROKER_SSL);

int keepalive = PrefsPropsUtil.getInteger(PortletPropsKeys.MQTT_BROKER_KEEPALIVE, PortletPropsValues.MQTT_BROKER_KEEPALIVE);
String subscriptions = PrefsPropsUtil.getString(PortletPropsKeys.MQTT_SUBSCRIPTIONS_LIST, PortletPropsValues.MQTT_SUBSCRIPTIONS_LIST);

boolean logInfo = PrefsPropsUtil.getBoolean(PortletPropsKeys.MQTT_EVENTS_LOGINFO, PortletPropsValues.MQTT_EVENTS_LOGINFO);
%>

<aui:row>
	<aui:col span="6">
		<c:if test="<%= connected %>">
			<div class="alert alert-success">
				<i class="icon-thumbs-up icon-2x"></i>
				<liferay-ui:message key="socket-on" />
				<br />
				<small><%= MqttLocalServiceUtil.getServerConnected() %></small>
			</div>
		</c:if>
		<c:if test="<%= !connected %>">
			<div class="alert alert-block">
				<i class="icon-thumbs-down icon-large"></i>
				<liferay-ui:message key="socket-off" />
			</div>
		</c:if>

		<c:if test="<%= !connected %>">

		<liferay-portlet:actionURL name="connect" var="connectURL">
			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		</liferay-portlet:actionURL>

		<aui:form action="<%= connectURL %>" method="post">
			<aui:button type="submit" value="connect" />
		</aui:form>

		</c:if>

		<c:if test="<%= connected %>">

		<liferay-portlet:actionURL name="disconnect" var="disconnectURL">
			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
		</liferay-portlet:actionURL>

		<aui:form action="<%= disconnectURL %>" method="post">
			<aui:button primary="false" type="submit" value="disconnect" />
		</aui:form>

		</c:if>
	</aui:col>

	<aui:col span="6">
<pre>See <a href="https://github.com/baxtheman/mqtt-liferay-plugins/wiki">usage documentation</a>
Source code at <a href="https://github.com/baxtheman/mqtt-liferay-plugins/">GitHub</a>
Based on <a href="https://www.eclipse.org/paho/clients/java/">PAHO Java client</a> for Mqtt messaging protocol
Build for the liferay community by <a href="https://twitter.com/baxtheman">@baxtheman</a></pre>
	</aui:col>
</aui:row>

<liferay-ui:error exception="<%= MqttException.class %>" />

<aui:row>
	<aui:col span="6">

		<liferay-ui:panel collapsible="false" title="account">

			<liferay-portlet:actionURL name="updatePreferences" var="updatePreferencesURL">
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			</liferay-portlet:actionURL>

			<liferay-ui:success key="success-save-preferences" message="success-save-preferences" />

			<aui:form action="<%= updatePreferencesURL %>" inlineLabels="true" method="post" name="fm">

				<aui:input label="auto-startup" name="autoConnect" type="checkbox" value="<%= autoConnect %>"   />

				<aui:input label="broker-url" name="brokerUrl" type="text" value="<%= brokerUrl %>"  />

				<aui:input label="client-id" name="clientID" type="text" value="<%= clientID %>"  />

				<aui:input label="user-name" name="username" type="text" value="<%= username %>"  />

				<aui:input label="password" name="password" type="text" value="<%= password %>"  />

				<aui:input label="broker-keepalive" name="brokerKeepalive" type="text" value="<%= keepalive %>"  >
					<aui:validator name="digits" />
					<aui:validator name="min">0</aui:validator>
				</aui:input>

				<aui:button-row>
					<aui:button type="submit" />
				</aui:button-row>
			</aui:form>

		</liferay-ui:panel>

	</aui:col>

	<aui:col span="6">

		<liferay-ui:panel collapsible="false" title="subscriptions">

			<liferay-portlet:actionURL name="saveSubscriptions" var="saveSubscriptionsURL">
				<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			</liferay-portlet:actionURL>

			<liferay-ui:success key="success-save-subscriptions" message="success-save-subscriptions" />

			<aui:form action="<%= saveSubscriptionsURL %>" method="post" name="fm2">

				<aui:input label="subscriptions" name="subscriptions"
					type="textarea" value="<%= subscriptions %>"
					rows="5" />

				<aui:input label="log-info-active" name="logInfo" type="checkbox" value="<%= logInfo %>"  />

				<aui:button-row>
					<aui:button type="submit" value="assign-subscriptions" />
				</aui:button-row>
			</aui:form>

		</liferay-ui:panel>

		<c:if test="<%= connected %>">

			<liferay-ui:panel collapsible="false" title="testing">

				<liferay-portlet:actionURL name="publishTest" var="publishTestURL">
					<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
				</liferay-portlet:actionURL>

				<liferay-ui:success key="success-testing" message="success-testing" />

				<aui:form action="<%= publishTestURL %>" method="post" name="fm2">

					<aui:input label="topic" name="topic" type="text"  />

					<aui:input label="payload" name="payload" type="textarea" />

					<aui:button-row>
						<aui:button type="submit" value="send" />
					</aui:button-row>
				</aui:form>

			</liferay-ui:panel>

		</c:if>

	</aui:col>
</aui:row>

<hr/>