package cn.wy.bs.controller;

import cn.wy.bs.dto.IssueDto;
import cn.wy.bs.dto.UserDto;
import cn.wy.bs.entity.Issue;
import cn.wy.bs.service.IssueService;
import cn.wy.bs.service.UserService;
import cn.wy.bs.utils.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2018-12-14
 */
@RestController
@RequestMapping(value = "/issue")
public class IssueController {

    @Resource
    private IssueService issueService;

    /**
     * 获取问题
     */
    @RequestMapping("/getIssueList")
    public ResponseData getIssueList(
            HttpSession session,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        HashMap<String, Object> ret = new HashMap<String, Object>();
        try {
            PageInfo<Issue> issuePageInfo = issueService.getIssueList(pageNum, pageSize, map);
            ret.put("issuePageInfo", issuePageInfo);
            ret.put("user", session.getAttribute("user"));
            responseData.setData(ret);
            responseData.setRspMsg("查询成功");
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("查询失败");
            System.out.println(e);
            return responseData;
        }
        return responseData;
    }

    /**
     * 获取单个问题信息
     */
    @RequestMapping("/getIssue")
    public ResponseData getIssue(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        HashMap<String, Object> ret = new HashMap<String, Object>();
        try {
            IssueDto issueDto = issueService.getIssue(map);
            ret.put("issue", issueDto);
            ret.put("user", session.getAttribute("user"));
            responseData.setData(ret);
            responseData.setRspMsg("查询成功");
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("查询失败");
            System.out.println(e);
            return responseData;
        }
        return responseData;
    }

    /**
     * 新增问题
     */
    @RequestMapping("/addIssue")
    public ResponseData addIssue(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            issueService.saveIssue(session, map);
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspCode("999999");
            return responseData;
        }
        return responseData;
    }


    /**
     * 根据ID删除问题
     */
    @RequestMapping("/deleteIssueById")
    public ResponseData deleteIssueById(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            issueService.deleteIssueById(session, map);
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspCode("999999");
            return responseData;
        }
        return responseData;
    }


    /**
     * 根据ID关闭问题
     */
    @RequestMapping("/closeIssueById")
    public ResponseData closeIssueById(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            issueService.closeIssueById(session, map);
            responseData.setRspCode("000000");
        } catch (Exception e) {
            responseData.setRspCode("999999");
            return responseData;
        }
        return responseData;
    }

}
