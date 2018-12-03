package cn.wy.bs.service.impl;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.entity.Project;
import cn.wy.bs.mapper.ProjectMapper;
import cn.wy.bs.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService{

    @Resource
    ProjectMapper projectMapper;

    @Override
    public List<ProjectDto> getProject(HashMap<String, Object> map) {
        return projectMapper.getProject(map);
    }
}
