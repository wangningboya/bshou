package cn.wy.bs.entitys;

import java.io.Serializable;
import java.util.Date;

public class auths implements Serializable {
    /**
     * ID
     */
    @javax.persistence.Id
    private String id;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 创建者
     */
    private String createname;

    /**
     * 修改时间
     */
    private Date modifitime;

    /**
     * 修改者
     */
    private String modifiname;

    /**
     * 是否删除（0未删除/1删除）
     */
    private Integer isdelete;

    /**
     * 权限名称
     */
    private String authname;

    /**
     * 父ID
     */
    private String parentid;

    /**
     * 是否禁止（0未禁止/1禁止）
     */
    private Integer visiable;

    /**
     * URL
     */
    private String url;

    /**
     * 图片
     */
    private String image;

    /**
     * 排序
     */
    private Integer rank;

    /**
     * 描述
     */
    private String describe;

    /**
     * t_auth
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     * @return ID ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 创建时间
     * @return CREATETIME 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 创建者
     * @return CREATENAME 创建者
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 创建者
     * @param createname 创建者
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 修改时间
     * @return MODIFITIME 修改时间
     */
    public Date getModifitime() {
        return modifitime;
    }

    /**
     * 修改时间
     * @param modifitime 修改时间
     */
    public void setModifitime(Date modifitime) {
        this.modifitime = modifitime;
    }

    /**
     * 修改者
     * @return MODIFINAME 修改者
     */
    public String getModifiname() {
        return modifiname;
    }

    /**
     * 修改者
     * @param modifiname 修改者
     */
    public void setModifiname(String modifiname) {
        this.modifiname = modifiname == null ? null : modifiname.trim();
    }

    /**
     * 是否删除（0未删除/1删除）
     * @return ISDELETE 是否删除（0未删除/1删除）
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * 是否删除（0未删除/1删除）
     * @param isdelete 是否删除（0未删除/1删除）
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 权限名称
     * @return AUTHNAME 权限名称
     */
    public String getAuthname() {
        return authname;
    }

    /**
     * 权限名称
     * @param authname 权限名称
     */
    public void setAuthname(String authname) {
        this.authname = authname == null ? null : authname.trim();
    }

    /**
     * 父ID
     * @return PARENTID 父ID
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 父ID
     * @param parentid 父ID
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    /**
     * 是否禁止（0未禁止/1禁止）
     * @return VISIABLE 是否禁止（0未禁止/1禁止）
     */
    public Integer getVisiable() {
        return visiable;
    }

    /**
     * 是否禁止（0未禁止/1禁止）
     * @param visiable 是否禁止（0未禁止/1禁止）
     */
    public void setVisiable(Integer visiable) {
        this.visiable = visiable;
    }

    /**
     * URL
     * @return URL URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * URL
     * @param url URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 图片
     * @return IMAGE 图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 图片
     * @param image 图片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 排序
     * @return RANK 排序
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 排序
     * @param rank 排序
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 描述
     * @return DESCRIBE 描述
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 描述
     * @param describe 描述
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}