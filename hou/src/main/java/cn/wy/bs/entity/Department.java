package cn.wy.bs.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name="t_department")
public class Department {

    /**
     * 部门名称
     */
    @Column(name="DEPNAME")
    private String depName;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        super.toString();
        return "Department{" +
                "depName='" + depName + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}