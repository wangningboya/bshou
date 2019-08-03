package cn.wy.bs.workflow.controller;


import cn.wy.bs.workflow.ActivitiUtil;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author WY
 * @Date 2019/5/23
 **/
@RestController
public class ActivitiController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private RuntimeService runtimeService;

	//发起项目报备审批流程
	@RequestMapping(value = "/createReport", method = RequestMethod.POST)
	@ResponseBody
	public void createReport(
			@RequestParam HashMap<String, Object> map
	) {
		System.out.println("=======================");
		ActivitiUtil.creatActivitiTask("processes/report.bpmn","processes/report.png");
//		taskService.
//		taskService.addCandidateUser();
	}
}
