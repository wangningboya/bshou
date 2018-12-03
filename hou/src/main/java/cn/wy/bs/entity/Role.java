package cn.wy.bs.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name="t_role")
public class Role {

    /**
     * 角色名
     */
    @Column(name="ROLENAME")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        super.toString();
        return "Role{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}