package cn.wy.bs.controller;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Project;
import cn.wy.bs.service.ProjectService;
import cn.wy.bs.utils.ResponseData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Resource
    ProjectService projectService;

    @RequestMapping(value = "/findProject")
    public ResponseData findProject(
            @RequestParam HashMap<String,Object> map
            ){
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        List<ProjectDto> projectList = projectService.findProject(map);
        jsonObject.put("projectList",projectList);
        responseData.setData(jsonObject);
        responseData.setRspCode("000000");
        return responseData;
    }


}
