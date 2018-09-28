package cn.wy.bs.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-28
 */
public class Authrole {

    /**
     * 角色ID
     */
    private String roleID;

    /**
     * 权限ID
     */
    private String authID;

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getAuthID() {
        return authID;
    }

    public void setAuthID(String authID) {
        this.authID = authID;
    }
}