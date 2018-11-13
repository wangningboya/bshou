package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

public class Project extends BaseModal {

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

    @Override
    public String toString() {
        super.toString();
        return "Project{" +
                "projectNo='" + projectNo + '\'' +
                ", projectName='" + projectName + '\'' +
                ", PMId='" + PMId + '\'' +
                '}';
    }
}
