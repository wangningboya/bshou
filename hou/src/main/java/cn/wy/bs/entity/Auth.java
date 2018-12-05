package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name="t_auth")
public class Auth extends BaseModal {


    /**
     * 权限名称
     */
    @Column(name="AUTHNAME")
    private String authName;

    /**
     * 父ID
     */
    @Column(name="PARENTID")
    private String parentId;

    /**
     * 是否禁止（0未禁止/1禁止）
     */
    @Column(name="VISIABLE")
    private Integer visiable;

    /**
     * URL
     */
    @Column(name="URL")
    private String url;

    /**
     * 图片
     */
    @Column(name="IMAGE")
    private String image;

    /**
     * 排序
     */
    @Column(name="RANK")
    private Integer rank;

    /**
     * 描述
     */
    @Column(name="DESCRIBE")
    private String describe;

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;


    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getVisiable() {
        return visiable;
    }

    public void setVisiable(Integer visiable) {
        this.visiable = visiable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        super.toString();
        return "Auth{" +
                "authName='" + authName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", visiable=" + visiable +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", rank=" + rank +
                ", describe='" + describe + '\'' +
                '}';
    }
}