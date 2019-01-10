package cn.wy.bs.service.impl;


import cn.wy.bs.constant.Constant;
import cn.wy.bs.constant.enums.ResLogTypeEnum;
import cn.wy.bs.entity.ResourceLog;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.mapper.UserProfileMapper;
import cn.wy.bs.service.PeopleService;
import cn.wy.bs.service.ResourceLogService;
import cn.wy.bs.utils.BaseUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2019-01-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PeopleServiceImpl implements PeopleService {

    @Resource
    private UserProfileMapper userProfileMapper;

    @Resource
    private ResourceLogService resourceLogService;

    @Override
    public void createTeam(HttpSession session, HashMap<String, Object> map) {

        String id = map.get("teamId").toString();
        UserProfile userProfile = userProfileMapper.selectById(id);
        userProfile.setModifiName(session.getAttribute("userName").toString());
        userProfile.setModifiTime(new Date());
        userProfile.setIsLeader(Constant.RESOURCE_IS_LEADER);
        userProfileMapper.updateByPrimaryKeySelective(userProfile);

        ResourceLog resourceLog = new ResourceLog();
        resourceLog.setID(BaseUtil.getUUID());
        resourceLog.setIsDelete(0);
        resourceLog.setLogType(ResLogTypeEnum.T05.getIndex());
        resourceLog.setLogTypeName(ResLogTypeEnum.T05.getName());
        resourceLog.setUserProfileId(userProfile.getID());
        resourceLog.setOccurTime(new Date());
        resourceLog.setLogContent(String.format("成为了%s_团队的Leader", userProfile.getResName()));
        resourceLogService.create(session, resourceLog);
    }

    @Override
    public void pickup(HttpSession session, HashMap<String, Object> map) {

        String id = map.get("memberId").toString();
        String id2 = map.get("teamId").toString();
        UserProfile userProfile = userProfileMapper.selectById(id);
        UserProfile userProfile2 = userProfileMapper.selectById(id2);

        userProfile.setModifiName(session.getAttribute("userName").toString());
        userProfile.setModifiTime(new Date());
        userProfile.setResTeamId(map.get("teamId").toString());
        userProfileMapper.updateByPrimaryKeySelective(userProfile);

        ResourceLog resourceLog = new ResourceLog();
        resourceLog.setID(BaseUtil.getUUID());
        resourceLog.setIsDelete(0);
        resourceLog.setLogType(ResLogTypeEnum.T02.getIndex());
        resourceLog.setLogTypeName(ResLogTypeEnum.T02.getName());
        resourceLog.setUserProfileId(userProfile.getID());
        resourceLog.setOccurTime(new Date());
        resourceLog.setLogContent(String.format("成为了%s_团队的一员",userProfile2.getResName()));
        resourceLogService.create(session, resourceLog);
    }

    @Override
    public void getout(HttpSession session, HashMap<String, Object> map) {

        String id = map.get("memberId").toString();
        UserProfile userProfile = userProfileMapper.selectById(id);
        UserProfile userProfile2 = userProfileMapper.selectById(userProfile.getResTeamId());
        userProfile.setModifiName(session.getAttribute("userName").toString());
        userProfile.setModifiTime(new Date());
        userProfile.setResTeamId(Constant.RESOURCE_UNDESIGNED);
        userProfileMapper.updateByPrimaryKeySelective(userProfile);

        ResourceLog resourceLog = new ResourceLog();
        resourceLog.setID(BaseUtil.getUUID());
        resourceLog.setIsDelete(0);
        resourceLog.setLogType(ResLogTypeEnum.T03.getIndex());
        resourceLog.setLogTypeName(ResLogTypeEnum.T03.getName());
        resourceLog.setUserProfileId(userProfile.getID());
        resourceLog.setOccurTime(new Date());
        resourceLog.setLogContent(String.format("离开了%s_团队",userProfile2.getResName()));
        resourceLogService.create(session, resourceLog);
    }

    @Override
    public void dismiss(HttpSession session, HashMap<String, Object> map) {

        String id = map.get("teamId").toString();
        UserProfile userProfile = userProfileMapper.selectById(id);
        userProfile.setModifiName(session.getAttribute("userName").toString());
        userProfile.setModifiTime(new Date());
        userProfile.setIsLeader(Constant.RESOURCE_NOT_LEADER);
        userProfileMapper.updateByPrimaryKeySelective(userProfile);

        List<UserProfile> members = userProfileMapper.selectByTeamId(id);
        for(UserProfile u: members){
            u.setResTeamId(Constant.RESOURCE_UNDESIGNED);
            userProfileMapper.updateByPrimaryKey(u);
        }

        ResourceLog resourceLog = new ResourceLog();
        resourceLog.setID(BaseUtil.getUUID());
        resourceLog.setIsDelete(0);
        resourceLog.setLogType(ResLogTypeEnum.T03.getIndex());
        resourceLog.setLogTypeName(ResLogTypeEnum.T03.getName());
        resourceLog.setUserProfileId(userProfile.getID());
        resourceLog.setOccurTime(new Date());
        resourceLog.setLogContent(String.format("由于各种原因，%s_团队被解散了",userProfile.getResName()));
        resourceLogService.create(session, resourceLog);
    }
}
