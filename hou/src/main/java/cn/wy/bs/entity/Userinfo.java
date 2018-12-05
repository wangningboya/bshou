package cn.wy.bs.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name="t_userinfo")
public class Userinfo {

    /**
     * 用户ID
     */
    @Column(name="USERID")
    private String userId;

    /**
     * 姓名
     */
    @Column(name="USERNAME")
    private String userName;

    /**
     * 等级
     */
    @Column(name="RESLEVEL")
    private String resLevel;

    /**
     * 名称
     */
    @Column(name="RESNAME")
    private String resName;

    /**
     * 部门ID
     */
    @Column(name="DEPID")
    private String depId;

    /**
     * 邮箱
     */
    @Column(name="EMAIL")
    private String email;

    /**
     * 联系方式
     */
    @Column(name="PHONE")
    private String phone;

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getResLevel() {
        return resLevel;
    }

    public void setResLevel(String resLevel) {
        this.resLevel = resLevel;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        super.toString();
        return "Userinfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", resLevel='" + resLevel + '\'' +
                ", resName='" + resName + '\'' +
                ", depId='" + depId + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}