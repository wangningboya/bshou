package cn.wy.bs.entity;

import cn.wy.bs.utils.Base;

/**
 * 
 * 
 * @author wy
 * 
 * @date 2018-09-28
 */
public class User extends Base{

    /**
     * 账号
     */
    private String userName;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 角色ID
     */
    private String roleID;

    /**
     * 邮箱
     */
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

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}