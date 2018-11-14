package cn.wy.bs.dto;

import cn.wy.bs.entity.DemandLog;

public class DemandLogDto extends DemandLog {

	/**
	 * 操作人员名字
	 */
	String opeName;

	public String getOpeName() {
		return opeName;
	}

	public void setOpeName(String opeName) {
		this.opeName = opeName;
	}
}
