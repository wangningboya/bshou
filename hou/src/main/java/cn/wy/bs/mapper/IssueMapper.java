package cn.wy.bs.mapper;

import cn.wy.bs.dto.IssueDto;
import cn.wy.bs.entity.Issue;
import cn.wy.bs.utils.BaseMapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2018-12-14
 */
public interface IssueMapper extends BaseMapper<Issue> {

    List<Issue> getIssueList(HashMap<String, Object> map);

    IssueDto getByIssueId(String id);
}
