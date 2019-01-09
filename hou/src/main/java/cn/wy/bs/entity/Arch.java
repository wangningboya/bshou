package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2019-01-09
 */
@Table(name="t_arch")
public class Arch extends BaseModal {

    /**
     * 部门名称
     */
    @Column(name="DEPNAME")
    private String depName;

    /**
     * 部门代码
     */
    @Column(name="DEPCODE")
    private String depCode;

    /**
     * 父ID
     */
    @Column(name="PARENTID")
    private String parentId;

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
