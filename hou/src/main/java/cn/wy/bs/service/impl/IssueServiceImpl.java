package cn.wy.bs.service.impl;

import cn.wy.bs.dto.IssueDto;
import cn.wy.bs.entity.Issue;
import cn.wy.bs.mapper.DemandMapper;
import cn.wy.bs.mapper.IssueMapper;
import cn.wy.bs.service.DemandService;
import cn.wy.bs.service.IssueService;
import cn.wy.bs.utils.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * @author wy
 * @date 2018-12-14
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IssueServiceImpl implements IssueService {

    @Resource
    private IssueMapper issueMapper;

    @Resource
    private DemandMapper demandMapper;

    /**
     * 获取问题信息
     * @param pageNum
     * @param pageSize
     * @param map
     * @return
     */
    @Override
    public PageInfo<Issue> getIssueList(Integer pageNum, Integer pageSize, HashMap<String, Object> map) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Issue> issuePageInfo = new PageInfo<Issue>(issueMapper.getIssueList(map));
        return  issuePageInfo;
    }

    /**
     * 新增问题
     * @param session
     * @param map
     */
    @Override
    public void saveIssue(HttpSession session, HashMap<String, Object> map) {
        Issue issue = new Issue();
        issue.setID(BaseUtil.getUUID());
        issue.setCreateName(session.getAttribute("userName").toString());
        issue.setCreateTime(new Date());
        issue.setIsDelete(0);
        issue.setState(0);
        issue.setIssueName(map.get("issueName").toString());
        issue.setIssueNo(map.get("issueNo").toString());
        issue.setIssueContent(map.get("issueContent").toString());
        issueMapper.insert(issue);
    }

    /**
     * 获取问题信息
     * @param map
     * @return
     */
    @Override
    public IssueDto getIssue(HashMap<String, Object> map) {
        IssueDto issueDto = new IssueDto();
        issueDto = issueMapper.getByIssueId(map.get("id").toString());
        issueDto.setDemands(demandMapper.getDemandListByIssueId(map.get("id").toString()));
        return issueDto;
    }

    @Override
    public void deleteIssueById(HttpSession session, HashMap<String, Object> map) {
        Issue issue = new Issue();
        issue.setID(map.get("id").toString());
        issue.setModifiName(session.getAttribute("userName").toString());
        issue.setModifiTime(new Date());
        issue.setIsDelete(1);
        issueMapper.updateByPrimaryKeySelective(issue);
    }

    @Override
    public void closeIssueById(HttpSession session, HashMap<String, Object> map) {
        Issue issue = new Issue();
        issue.setID(map.get("id").toString());
        issue.setModifiName(session.getAttribute("userName").toString());
        issue.setModifiTime(new Date());
        issue.setState(2);
        issueMapper.updateByPrimaryKeySelective(issue);
    }
}
