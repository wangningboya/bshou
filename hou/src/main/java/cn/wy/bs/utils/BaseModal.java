package cn.wy.bs.utils;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class BaseModal implements Serializable{
    /**
     * ID
     */
    @Column(name="ID")
    @javax.persistence.Id
    private String ID;

    /**
     * 创建时间
     */
    @Column(name="CREATETIME")
    private Date createTime;

    /**
     * 创建者
     */
    @Column(name="CREATENAME")
    private String createName;

    /**
     * 修改时间
     */
    @Column(name="MODIFITIME")
    private Date modifiTime;

    /**
     * 修改者
     */
    @Column(name="MODIFINAME")
    private String modifiName;

    /**
     * 是否删除（0未删除/1删除）
     */
    @Excel(name = "是否删除",height = 11, width = 15)
    @Column(name="ISDELETE")
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
