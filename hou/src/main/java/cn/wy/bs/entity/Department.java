package cn.wy.bs.entity;

/**
 * 
 * 
 * @author wy
 * 
 * @date 2018-09-28
 */
public class Department {

    /**
     * 部门名称
     */
    private String depName;

    /**
     * 父ID
     */
    private String parentID;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }
}