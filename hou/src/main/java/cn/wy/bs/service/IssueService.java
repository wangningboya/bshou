package cn.wy.bs.service;


import cn.wy.bs.dto.IssueDto;
import cn.wy.bs.entity.Issue;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author wy
 * @date 2018-12-14
 */
public interface IssueService {

    /**
     * 获取问题
     */
    PageInfo<Issue> getIssueList(Integer pageNum, Integer pageSize, HashMap<String, Object> map);

    /**
     * 保存问题
     *
     * @param session
     * @param map
     */
    void saveIssue(HttpSession session, HashMap<String, Object> map);

    /**
     * 获取问题信息
     *
     * @param map
     * @return
     */
    IssueDto getIssue(HashMap<String, Object> map);

    /**
     * 根据ID删除问题
     *
     * @param session
     * @param map
     */
    void deleteIssueById(HttpSession session, HashMap<String, Object> map);

    /**
     * 根据ID关闭问题
     *
     * @param session
     * @param map
     */
    void closeIssueById(HttpSession session, HashMap<String, Object> map);
}
