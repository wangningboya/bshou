package cn.wy.bs.service;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Project;

import java.util.HashMap;
import java.util.List;

public interface ProjectService {

    // 查询项目信息
    List<ProjectDto> getProject(HashMap<String, Object> map);

}
