package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2019-01-10
 */
@Table(name = "t_category")
public class Category extends BaseModal {

    /**
     * 类别名称
     */
    @Column(name = "CATEGORYNAME")
    private String categoryName;

    /**
     * 类别等级
     */
    @Column(name = "LEVEL")
    private String level;

    /**
     * 类别代码
     */
    @Column(name = "CATEGORYCODE")
    private String categoryCode;

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
