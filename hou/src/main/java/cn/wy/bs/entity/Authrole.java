package cn.wy.bs.entity;

/**
 * 
 * 
 * @author wy
 * 
 * @date 2018-09-28
 */
public class Authrole {

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 权限ID
     */
    private String authId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        super.toString();
        return "Authrole{" +
                "roleId='" + roleId + '\'' +
                ", authId='" + authId + '\'' +
                '}';
    }
}


