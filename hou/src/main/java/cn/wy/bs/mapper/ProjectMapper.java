package cn.wy.bs.mapper;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Project;

import java.util.HashMap;
import java.util.List;

public interface ProjectMapper {

    List<ProjectDto> getProject(HashMap<String, Object> map);
}
