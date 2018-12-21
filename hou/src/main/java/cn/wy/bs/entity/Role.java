package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name="t_role")
public class Role extends BaseModal {

    /**
     * 角色名
     */
    @Column(name="ROLENAME")
    private String roleName;

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

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