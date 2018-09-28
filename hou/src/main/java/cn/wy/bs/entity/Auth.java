package cn.wy.bs.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-28
 */
public class Auth {


    /**
     * 权限名称
     */
    private String authName;

    /**
     * 父ID
     */
    private String parentID;

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


    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
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
}