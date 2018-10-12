package cn.wy.bs.service;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Project;

import java.util.HashMap;
import java.util.List;

public interface ProjectService {

    //查询项目信息
    public List<ProjectDto> findProject(HashMap<String, Object> map);

}
