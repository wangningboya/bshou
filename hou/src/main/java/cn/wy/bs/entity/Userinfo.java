package cn.wy.bs.entity;

/**
 * 
 * 
 * @author wy
 * 
 * @date 2018-09-28
 */
public class Userinfo {

    /**
     * 用户ID
     */
    private String userID;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 等级
     */
    private String resLevel;

    /**
     * 名称
     */
    private String resName;

    /**
     * 部门ID
     */
    private String depID;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系方式
     */
    private String phone;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
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
}