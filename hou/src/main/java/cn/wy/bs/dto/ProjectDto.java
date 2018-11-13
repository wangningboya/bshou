package cn.wy.bs.dto;

import cn.wy.bs.utils.BaseModal;

public class ProjectDto extends BaseModal {

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目经理ID
     */
    private String PMId;

    /**
     * 项目经理
     */
    private String PMName;

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

    public String getPMName() {
        return PMName;
    }

    public void setPMName(String PMName) {
        this.PMName = PMName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
