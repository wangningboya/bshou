package cn.wy.bs.dto;

import cn.wy.bs.utils.Base;

public class ProjectDto extends Base {
    /**
     * 项目编号
     */
    private String projectNO;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目经理ID
     */
    private String PMID;

    /**
     * 项目经理
     */
    private String PMName;

    public String getProjectNO() {
        return projectNO;
    }

    public void setProjectNO(String projectNO) {
        this.projectNO = projectNO;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPMID() {
        return PMID;
    }

    public void setPMID(String PMID) {
        this.PMID = PMID;
    }

    public String getPMName() {
        return PMName;
    }

    public void setPMName(String PMName) {
        this.PMName = PMName;
    }
}
