package cn.wy.bs.utils;

import java.util.Date;

public class BaseModal {
    /**
     * ID
     */
    @javax.persistence.Id
    private String ID;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者
     */
    private String createName;

    /**
     * 修改时间
     */
    private Date modifiTime;

    /**
     * 修改者
     */
    private String modifiName;

    /**
     * 是否删除（0未删除/1删除）
     */
    private Integer isDelete;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getModifiTime() {
        return modifiTime;
    }

    public void setModifiTime(Date modifiTime) {
        this.modifiTime = modifiTime;
    }

    public String getModifiName() {
        return modifiName;
    }

    public void setModifiName(String modifiName) {
        this.modifiName = modifiName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

}
