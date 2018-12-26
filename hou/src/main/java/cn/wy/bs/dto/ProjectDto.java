package cn.wy.bs.dto;

import cn.wy.bs.entity.Project;
import cn.wy.bs.utils.BaseModal;

public class ProjectDto extends Project {

    /**
     * 项目经理
     */
    private String PMName;

    public String getPMName() {
        return PMName;
    }

    public void setPMName(String PMName) {
        this.PMName = PMName;
    }

}
