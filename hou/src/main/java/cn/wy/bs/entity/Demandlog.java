package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name="t_demandlog")
public class DemandLog extends BaseModal{

	/**
	 *需求ID
	 */
	@Column(name="DEMANDID")
	String demandId;

	/**
	 * 操作人员ID
	 */
	@Column(name="OPEID")
	String opeId;

	/**
	 * 操作时间
	 */
	@Column(name="OPETIME")
	Date opeTime;

	/**
	 *需求状态
	 */
	@Column(name="DEMANDSTATE")
	Integer demandState;

	public String getDemandId() {
		return demandId;
	}

	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}

	public String getOpeId() {
		return opeId;
	}

	public void setOpeId(String opeId) {
		this.opeId = opeId;
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
