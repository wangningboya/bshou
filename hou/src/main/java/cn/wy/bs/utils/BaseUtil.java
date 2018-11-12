package cn.wy.bs.utils;

import java.util.UUID;

public class BaseUtil {

	//获取UUID
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
}
