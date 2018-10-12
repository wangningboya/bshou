package cn.wy.bs.dto;

import cn.wy.bs.entity.Demand;
import cn.wy.bs.utils.Base;

import java.util.Date;

public class DemandDto extends Demand{

    /**
     * 项目编号
     */
    private String projectNO;

    /**
     * 项目名称
     */
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNO() {
        return projectNO;
    }

    public void setProjectNO(String projectNO) {
        this.projectNO = projectNO;
    }

}
