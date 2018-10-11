package cn.wy.bs.entity;

import cn.wy.bs.utils.Base;

import java.util.Date;

/**
 * 
 * 
 * @author wy
 * 
 * @date 2018-10-11
 */
public class Demand extends Base{

    /**
     * 需求编号
     */
    private String demandNO;

    /**
     * 需求名称
     */
    private String demandName;

    /**
     * 需求描述
     */
    private String demandDes;

    /**
     * 需求类型（0需求/1BUG）
     */
    private Integer demandType;

    /**
     * 项目ID
     */
    private String projectID;

    /**
     * 验收人员ID
     */
    private String accID;

    /**
     * 开发人员
     */
    private String devID;

    /**
     * 审核理由
     */
    private String reviewDes;

    /**
     * 预期时间
     */
    private Integer expTime;

    /**
     * 实际时间
     */
    private Integer actTime;

    /**
     * 状态（0提出需求/1需求审核/2审核通过/3审核未通过/4预估时间/5开发开始/6开发暂停/7开发结束/8开发关闭/9需求验收/10验收通过/11验收未通过）
     */
    private Integer state;

    /**
     * 开发结束时间
     */
    private Date deliverTime;

    /**
     * 关闭时间
     */
    private Date closeTime;

    /**
     * 关闭原因
     */
    private String closeReason;

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

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
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

    public String getDemandNO() {
        return demandNO;
    }

    public void setDemandNO(String demandNO) {
        this.demandNO = demandNO;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }
}