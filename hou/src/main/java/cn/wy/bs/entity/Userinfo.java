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
    private String userId;

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
    private String depId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系方式
     */
    private String phone;

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