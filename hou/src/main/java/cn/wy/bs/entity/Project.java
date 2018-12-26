package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name = "t_project")
public class Project extends BaseModal {

    /**
     * 项目编号
     */
    @Column(name = "PROJECTNO")
    private String projectNo;

    /**
     * 项目名称
     */
    @Column(name = "PROJECTNAME")
    private String projectName;

    /**
     * 项目经理ID
     */
    @Column(name = "PMID")
    private String PMId;

    /**
     * 投入资金
     */
    @Column(name = "PROJECTAMOUNT")
    private String projectAmount;

    /**
     * 销售人员
     */
    @Column(name = "PROJECTSALES")
    private String projectSales;

    /**
     * 状态
     */
    @Column(name = "STATE")
    private Integer state;

    /**
     * 立项时间
     */
    @Column(name = "SETUPDATE")
    private Date setUpDate;

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPMId() {
        return PMId;
    }

    public void setPMId(String PMId) {
        this.PMId = PMId;
    }

    public String getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(String projectAmount) {
        this.projectAmount = projectAmount;
    }

    public String getProjectSales() {
        return projectSales;
    }

    public void setProjectSales(String projectSales) {
        this.projectSales = projectSales;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getSetUpDate() {
        return setUpDate;
    }

    public void setSetUpDate(Date setUpDate) {
        this.setUpDate = setUpDate;
    }
}
