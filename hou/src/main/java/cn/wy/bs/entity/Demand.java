package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author wy
 * @date 2018-10-11
 */
@Table(name="t_demand")
public class Demand extends BaseModal {

    /**
     * 需求编号
     */
    @Column(name="DEMANDNO")
    private String demandNo;

    /**
     * 需求名称
     */
    @Column(name="DEMANDNAME")
    private String demandName;

    /**
     * 需求描述
     */
    @Column(name="DEMANDDES")
    private String demandDes;

    /**
     * 需求类型（0需求/1BUG）
     */
    @Column(name="DEMANDTYPE")
    private Integer demandType;

    /**
     * 问题ID
     */
    @Column(name="ISSUEID")
    private String issueId;

    /**
     * 项目ID
     */
    @Column(name="PROJECTID")
    private String projectId;

    /**
     * 验收人员ID
     */
    @Column(name="ACCID")
    private String accId;

    /**
     * 开发人员
     */
    @Column(name="DEVID")
    private String devId;

    /**
     * 审核理由
     */
    @Column(name="REVIEWDES")
    private String reviewDes;

    /**
     * 预期时间
     */
    @Column(name="EXPTIME")
    private Integer expTime;

    /**
     * 实际时间
     */
    @Column(name="ACTTIME")
    private Integer actTime;

    /**
     *  交付时间
     */
    @Column(name="DELIVERYTIME")
    private Date deliveryTime;

    /**
     * 状态状态（0提出需求/1审核通过/2审核未通过/3预估时间/4开发开始/5开发暂停/6开发结束/7开发关闭/8验收通过/9验收未通过）
     */
    @Column(name="STATE")
    private Integer state;

    /**
     * 开发结束时间
     */
    @Column(name="DEVELOPTIME")
    private Date developTime;

    /**
     * 关闭时间
     */
    @Column(name="CLOSETIME")
    private Date closeTime;

    /**
     * 关闭原因
     */
    @Column(name="CLOSEREASON")
    private String closeReason;

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    public String getDemandNo() {
        return demandNo;
    }

    public void setDemandNo(String demandNo) {
        this.demandNo = demandNo;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getDemandDes() {
        return demandDes;
    }

    public void setDemandDes(String demandDes) {
        this.demandDes = demandDes;
    }

    public Integer getDemandType() {
        return demandType;
    }

    public void setDemandType(Integer demandType) {
        this.demandType = demandType;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getReviewDes() {
        return reviewDes;
    }

    public void setReviewDes(String reviewDes) {
        this.reviewDes = reviewDes;
    }

    public Integer getExpTime() {
        return expTime;
    }

    public void setExpTime(Integer expTime) {
        this.expTime = expTime;
    }

    public Integer getActTime() {
        return actTime;
    }

    public void setActTime(Integer actTime) {
        this.actTime = actTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDevelopTime() {
        return developTime;
    }

    public void setDevelopTime(Date developTime) {
        this.developTime = developTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "demandNo='" + demandNo + '\'' +
                ", demandName='" + demandName + '\'' +
                ", demandDes='" + demandDes + '\'' +
                ", demandType=" + demandType +
                ", projectId='" + projectId + '\'' +
                ", accId='" + accId + '\'' +
                ", devId='" + devId + '\'' +
                ", reviewDes='" + reviewDes + '\'' +
                ", expTime=" + expTime +
                ", actTime=" + actTime +
                ", deliveryTime=" + deliveryTime +
                ", state=" + state +
                ", deliverTime=" + developTime +
                ", closeTime=" + closeTime +
                ", closeReason='" + closeReason + '\'' +
                '}';
    }
}