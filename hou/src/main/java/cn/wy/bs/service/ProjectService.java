package cn.wy.bs.service;

import cn.wy.bs.dto.ProjectDto;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public interface ProjectService {

	/**
	 * 查询项目信息
	 */
	List<ProjectDto> getProject(HashMap<String, Object> map);

	/**
	 * 获取项目
	 */
	PageInfo<ProjectDto> getProjectList(Integer pageNum, Integer pageSize, HashMap<String, Object> map);

}
