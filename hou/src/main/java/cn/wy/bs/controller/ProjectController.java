package cn.wy.bs.controller;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Project;
import cn.wy.bs.service.ProjectService;
import cn.wy.bs.utils.ResponseData;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Resource
    ProjectService projectService;

    @RequestMapping(value = "/findProject")
    public ResponseData findProject(
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        List<ProjectDto> projectList = projectService.getProject(map);
        jsonObject.put("projectList", projectList);
        responseData.setData(jsonObject);
        responseData.setRspCode("000000");
        return responseData;
    }

    @RequestMapping(value = "/getProjectList", method = RequestMethod.GET)
    public ResponseData getProjectList(
            HttpSession session,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        HashMap<String, Object> ret = new HashMap<String, Object>();
        PageInfo<ProjectDto> projectDtoPageInfo = projectService.getProjectList(pageNum, pageSize, map);
        ret.put("projectList", projectDtoPageInfo);
        ret.put("user", session.getAttribute("user"));
        responseData.setData(ret);
        responseData.setRspCode("000000");
        return responseData;
    }

    @RequestMapping(value = "/saveProject", method = RequestMethod.GET)
    public ResponseData saveProject(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) throws ParseException {
        projectService.saveProject(session, map);
        ResponseData responseData = null;
        return responseData;
    }


}
