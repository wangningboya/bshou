package cn.wy.bs.service;

import cn.wy.bs.dto.ProjectDto;
import cn.wy.bs.entity.Project;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
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

	/**
	 * 新增项目
	 */
	void saveProject(HttpSession session, HashMap<String, Object> map) throws ParseException;
}
