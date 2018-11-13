package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 
 * 
 * @author wy
 * 
 * @date 2018-09-28
 */
@Table(name="t_user")
public class User extends BaseModal {

    /**
     * 账号
     */
    @Column(name="USERNAME")
    private String userName;

    /**
     * 姓名
     */
    @Column(name="REALNAME")
    private String realName;

    /**
     * 密码
     */
    @Column(name="PASSWORD")
    private String password;

    /**
     * 联系方式
     */
    @Column(name="PHONE")
    private String phone;

    /**
     * 角色ID
     */
    @Column(name="ROLEID")
    private String roleId;

    /**
     * 邮箱
     */
    @Column(name="EMAIL")
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        super.toString();
        return "User{" +
                "userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", roleId='" + roleId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}