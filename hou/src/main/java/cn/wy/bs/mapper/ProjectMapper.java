package cn.wy.bs.mapper;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Project;

import java.util.HashMap;
import java.util.List;

public interface ProjectMapper {

    public List<ProjectDto> findProject(HashMap<String, Object> map);
}
