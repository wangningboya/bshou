package cn.wy.bs.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name="t_authrole")
public class Authrole {

    /**
     * 角色ID
     */
    @Column(name="ROLEID")
    private String roleId;

    /**
     * 权限ID
     */
    @Column(name="AUTHID")
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


