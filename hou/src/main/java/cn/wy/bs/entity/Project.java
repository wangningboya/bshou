package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name="t_project")
public class Project extends BaseModal {

    /**
     * 项目编号
     */
    @Column(name="PROJECTNO")
    private String projectNo;

    /**
     * 项目名称
     */
    @Column(name="PROJECTNAME")
    private String projectName;

    /**
     * 项目经理ID
     */
    @Column(name="PMID")
    private String PMId;

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

}
