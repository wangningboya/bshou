package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name="t_userprofile")
public class UserProfile extends BaseModal {

    /**
     * 资源名称
     */
    @Column(name="RESNAME")
    private String resName;

    /**
     * 资源等级
     */
    @Column(name="RESLEVEL")
    private String resLevel;

    /**
     * 资源职位
     */
    @Column(name="RESPOSITION")
    private String resPosition;

    /**
     * 资源所属部门
     */
    @Column(name="RESDEPART")
    private String resDepart;

    /**
     * 邮箱
     */
    @Column(name="EMAIL")
    private String email;

    /**
     * 手机
     */
    @Column(name="TELEPHONE")
    private String telephone;

    /**
     * 资源团队ID
     */
    @Column(name="RESTEAMID")
    private String resTeamId;

    /**
     * 是否领导
     */
    @Column(name="ISLEADER")
    private String isLeader;

    /**
     * 资源类型
     */
    @Column(name="RESTYPE")
    private String resType;

    /**
     * 资源描述
     */
    @Column(name="RESDESCRIPTION")
    private String resDescription;

    /**
     * 资源部门名称
     */
    @Column(name="RESDEPARTNAME")
    private String resDepartName;

    /**
     * 入职时间
     */
    @Column(name = "SETUPDATE")
    private Date setupDate;

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResLevel() {
        return resLevel;
    }

    public void setResLevel(String resLevel) {
        this.resLevel = resLevel;
    }

    public String getResPosition() {
        return resPosition;
    }

    public void setResPosition(String resPosition) {
        this.resPosition = resPosition;
    }

    public String getResDepart() {
        return resDepart;
    }

    public void setResDepart(String resDepart) {
        this.resDepart = resDepart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getResTeamId() {
        return resTeamId;
    }

    public void setResTeamId(String resTeamId) {
        this.resTeamId = resTeamId;
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getResDescription() {
        return resDescription;
    }

    public void setResDescription(String resDescription) {
        this.resDescription = resDescription;
    }

    public String getResDepartName() {
        return resDepartName;
    }

    public void setResDepartName(String resDepartName) {
        this.resDepartName = resDepartName;
    }

    public Date getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }
}
