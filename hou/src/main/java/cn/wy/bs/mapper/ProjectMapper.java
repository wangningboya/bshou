package cn.wy.bs.mapper;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Project;
import cn.wy.bs.utils.BaseMapper;

import java.util.HashMap;
import java.util.List;

public interface ProjectMapper extends BaseMapper<Project> {

    List<ProjectDto> getProject(HashMap<String, Object> map);
}
