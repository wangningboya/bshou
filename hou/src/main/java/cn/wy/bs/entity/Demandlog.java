package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Date;

public class Demandlog  extends BaseModal{

	/**
	 *需求ID
	 */
	String demandId;

	/**
	 * 操作人员ID
	 */
	String devId;

	/**
	 * 操作时间
	 */
	Date opeTime;

	/**
	 *需求状态
	 */
	Integer demandState;

	public String getDemandId() {
		return demandId;
	}

	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public Date getOpeTime() {
		return opeTime;
	}

	public void setOpeTime(Date opeTime) {
		this.opeTime = opeTime;
	}

	public Integer getDemandState() {
		return demandState;
	}

	public void setDemandState(Integer demandState) {
		this.demandState = demandState;
	}
}
