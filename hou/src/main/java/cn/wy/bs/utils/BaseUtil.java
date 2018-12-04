package cn.wy.bs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BaseUtil {

	/**
	 * 获取UUID
	 *
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}


	/**
	 * 过滤map null 值
	 *
	 * @param params
	 * @return
	 */
	public static Map<String, Object> filterParams(Map<String, Object> params) {

		if (params == null || params.size() < 1) {
			return null;
		}

		Map<String, Object> targetMap = new HashMap<>();

		for (String key : params.keySet()) {

			if (params.get(key) != null) {
				targetMap.put(key, params.get(key));
			}

		}

		return targetMap;
	}

	public static String getCurrentDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

	public static String getCurrentTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date());
	}

	public static String getCurrentDateTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}
