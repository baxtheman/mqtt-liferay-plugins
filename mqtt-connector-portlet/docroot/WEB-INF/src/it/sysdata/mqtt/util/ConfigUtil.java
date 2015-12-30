package it.sysdata.mqtt.util;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author @baxtheman
 */
public class ConfigUtil {

	public static String[] properties2topic(String[] list) {

		String[] ret = new String[list.length];

		for (int i = 0; i<list.length; i++) {
			String[] pair = StringUtil.split(list[i], StringPool.COLON);

			ret[i] = pair[1];
		}

		return ret;
	}

	public static int[] properties2qos(String[] list) {

		int[] ret = new int[list.length];

		for (int i = 0; i<list.length; i++) {
			String[] pair = StringUtil.split(list[i], StringPool.COLON);

			ret[i] = Integer.parseInt(pair[0]);
		}

		return ret;
	}
}