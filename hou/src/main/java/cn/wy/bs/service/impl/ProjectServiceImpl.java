package cn.wy.bs.service.impl;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Project;
import cn.wy.bs.mapper.ProjectMapper;
import cn.wy.bs.service.ProjectService;
import cn.wy.bs.utils.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    @Resource
    ProjectMapper projectMapper;

    @Override
    public List<ProjectDto> getProject(HashMap<String, Object> map) {
        return projectMapper.getProject(map);
    }

    @Override
    public PageInfo<ProjectDto> getProjectList(Integer pageNum, Integer pageSize, HashMap<String, Object> map) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ProjectDto> projectDtoPageInfo = new PageInfo<ProjectDto>(projectMapper.getProjectList(map));
        return projectDtoPageInfo;
    }

    @Override
    public void saveProject(HttpSession session, HashMap<String, Object> map) throws ParseException {
        Project project = new Project();

        project.setProjectName(map.get("projectName").toString());
        project.setState(Integer.parseInt(map.get("state").toString()));
        project.setSetUpDate(BaseUtil.stringToDate(map.get("setUpDate").toString()));
        project.setProjectAmount(map.get("projectAmount").toString());
        project.setProjectSales(map.get("projectSales").toString());
        project.setProjectNo(map.get("projectNo").toString());
        project.setProjectDes(map.get("projectDes").toString());
        project.setPMId(map.get("PMId").toString());

        if (map.get("projectId") != null) {
            project.setID(map.get("projectId").toString());
            project.setModifiName(session.getAttribute("userName").toString());
            project.setModifiTime(new Date());
        } else {
            project.setID(BaseUtil.getUUID());
            project.setCreateName(session.getAttribute("userName").toString());
            project.setCreateTime(new Date());
            project.setIsDelete(0);
            projectMapper.insert(project);
        }


    }
}
