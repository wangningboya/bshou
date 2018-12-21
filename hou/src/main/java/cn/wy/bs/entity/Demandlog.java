package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name = "t_demandlog")
public class DemandLog extends BaseModal {

    /**
     * 需求ID
     */
    @Column(name = "DEMANDID")
    private String demandId;

    /**
     * 操作人员ID
     */
    @Column(name = "OPEID")
    private String opeId;

    /**
     * 操作时间
     */
    @Column(name = "OPETIME")
    private Date opeTime;

    /**
     * 需求状态
     */
    @Column(name = "DEMANDSTATE")
    private Integer demandState;

    /**
     * 需求状态名称
     */
    @Column(name = "DEMANDSTATENAME")
    private String demandStateName;

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

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

    public String getDemandStateName() {
        return demandStateName;
    }

    public void setDemandStateName(String demandStateName) {
        this.demandStateName = demandStateName;
    }
}


