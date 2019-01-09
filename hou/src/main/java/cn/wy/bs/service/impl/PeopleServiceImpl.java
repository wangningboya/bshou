package cn.wy.bs.service.impl;


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

        UserProfile userProfile = userProfileMapper.selectById(map);
        userProfile.setModifiName(session.getAttribute("userName").toString());
        userProfile.setModifiTime(new Date());
        userProfile.setIsLeader("999999");
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
}
