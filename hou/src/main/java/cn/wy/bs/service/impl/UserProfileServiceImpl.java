package cn.wy.bs.service.impl;

import cn.wy.bs.constant.Constant;
import cn.wy.bs.constant.enums.ResLogTypeEnum;
import cn.wy.bs.dto.ResourceOrgDto;
import cn.wy.bs.entity.Category;
import cn.wy.bs.entity.ResourceLog;
import cn.wy.bs.entity.User;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.mapper.UserMapper;
import cn.wy.bs.mapper.UserProfileMapper;
import cn.wy.bs.service.ArchService;
import cn.wy.bs.service.CategoryService;
import cn.wy.bs.service.ResourceLogService;
import cn.wy.bs.service.UserProfileService;
import cn.wy.bs.utils.BaseUtil;
import cn.wy.bs.utils.ResponseData;
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
public class UserProfileServiceImpl implements UserProfileService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ArchService archService;

    @Resource
    private UserProfileMapper userProfileMapper;

    @Resource
    private ResourceLogService resourceLogService;

    @Resource
    private CategoryService categoryService;

    @Override
    public ResponseData create(HttpSession session, ResourceOrgDto resourceOrgDto) {
        ResponseData responseData = new ResponseData();

        String tel = resourceOrgDto.getResourceTel();
        List<User> userList = userMapper.selectByTel(tel);
        if (userList.size() != 1) {
            responseData.setRspCode("888888");
            responseData.setRspMsg("无此手机号的账号");
            return responseData;
        }

        List<UserProfile> userProfileList = userProfileMapper.selectByTel(tel);
        if (userProfileList.size() > 0) {
            responseData.setRspCode("888888");
            responseData.setRspMsg("已存在此手机号的资源");
            return responseData;
        }

        User user = userList.get(0);
        user.setModifiTime(new Date());
        user.setModifiName(session.getAttribute("userName").toString());
        user.setRealName(resourceOrgDto.getResourceName());
//        user.setEmail(resourceOrgDto.getResourceEmail());
        user.setRoleId(resourceOrgDto.getResRoleId());
        userMapper.updateByPrimaryKeySelective(user);

        UserProfile userProfile = new UserProfile();
        userProfile.setID(BaseUtil.getUUID());
        userProfile.setIsDelete(Constant.ISDELETED_FALSE_0);
        userProfile.setCreateName(session.getAttribute("userName").toString());
        userProfile.setCreateTime(new Date());
        userProfile.setResDescription(resourceOrgDto.getResourceDescription());
        userProfile.setSetupDate(resourceOrgDto.getResourceSetupDate());
        userProfile.setTelephone(resourceOrgDto.getResourceTel());
        userProfile.setResPosition(resourceOrgDto.getResourceTitle());
        userProfile.setResLevel(resourceOrgDto.getResourcePhase());
        userProfile.setResName(userList.get(0).getRealName());
        userProfile.setResType(resourceOrgDto.getResType());
        userProfile.setEmail(resourceOrgDto.getResourceEmail());
        userProfile.setEmail(resourceOrgDto.getResourceEmail());
        userProfile.setUserId(userList.get(0).getID());
        if (resourceOrgDto.getResourceDepart() != null && resourceOrgDto.getResourceDepart() != "") {
            userProfile.setResDepart(resourceOrgDto.getResourceDepart());
            userProfile.setResDepartName(archService.queryDepName(userProfile.getResDepart()));
        }

        userProfile.setIsLeader(Constant.RESOURCE_NOT_LEADER);
        userProfile.setResTeamId(Constant.RESOURCE_UNDESIGNED);

        userProfileMapper.insert(userProfile);

        ResourceLog resourceLog = new ResourceLog();
        resourceLog.setID(BaseUtil.getUUID());
        resourceLog.setIsDelete(Constant.ISDELETED_FALSE_0);
        resourceLog.setLogType(ResLogTypeEnum.T01.getIndex());
        resourceLog.setLogTypeName(ResLogTypeEnum.T01.getName());
        resourceLog.setUserProfileId(userProfile.getID());
        resourceLog.setOccurTime(userProfile.getSetupDate());
        resourceLog.setLogContent("加入 " + userProfile.getResDepartName());

        resourceLogService.create(session, resourceLog);

        responseData.setRspCode("000000");
        responseData.setRspMsg("创建成功");
        return responseData;
    }

    @Override
    public ResponseData updateOrg(HttpSession session, String id, ResourceOrgDto resourceOrgDto) {
        ResponseData responseData = new ResponseData();

        UserProfile userProfile = new UserProfile();
        userProfile = userProfileMapper.selectByPrimaryKey(id);

        String tel = resourceOrgDto.getResourceTel();
        String id2 = userProfile.getUserId();
        List<User> userList = userMapper.selectByTel2(id2, tel);
        if (userList.size() > 0) {
            responseData.setRspCode("777777");
            responseData.setRspMsg("此手机号已存在");
            return responseData;
        }


        User user = new User();
        user = userMapper.selectByPrimaryKey(userProfile.getUserId());
        user.setModifiName(session.getAttribute("userName").toString());
        user.setModifiTime(new Date());
        user.setRealName(resourceOrgDto.getResourceName());
//        user.setEmail(resourceOrgDto.getResourceEmail());
        user.setPhone(resourceOrgDto.getResourceTel());
        user.setRoleId(resourceOrgDto.getResRoleId());
        userMapper.updateByPrimaryKeySelective(user);

        userProfile.setModifiTime(new Date());
        userProfile.setModifiName(session.getAttribute("userName").toString());
        userProfile.setResDescription(resourceOrgDto.getResourceDescription());
        userProfile.setSetupDate(resourceOrgDto.getResourceSetupDate());
        userProfile.setTelephone(resourceOrgDto.getResourceTel());
        userProfile.setResPosition(resourceOrgDto.getResourceTitle());
        userProfile.setResLevel(resourceOrgDto.getResourcePhase());
        userProfile.setResName(resourceOrgDto.getResourceName());
        userProfile.setResType(resourceOrgDto.getResType());
        userProfile.setEmail(resourceOrgDto.getResourceEmail());
        if (resourceOrgDto.getResourceDepart() != null && resourceOrgDto.getResourceDepart() != "") {
            userProfile.setResDepart(resourceOrgDto.getResourceDepart());
            userProfile.setResDepartName(archService.queryDepName(userProfile.getResDepart()));
        }

        userProfileMapper.updateByPrimaryKeySelective(userProfile);

        responseData.setRspMsg("修改成功");
        responseData.setRspCode("000000");
        return responseData;
    }

    @Override
    public void removeOrg(HttpSession session, String id) {
        UserProfile userProfile = new UserProfile();
        userProfile.setID(id);
        userProfile.setIsDelete(Constant.ISDELETED_TRUE_1);
        userProfile.setModifiName(session.getAttribute("userName").toString());
        userProfile.setModifiTime(new Date());
        userProfileMapper.updateByPrimaryKeySelective(userProfile);
    }

    @Override
    public void createOrgResType(HttpSession session, HashMap<String, Object> map) {
        Category category = new Category();
        category.setCategoryName(map.get("resourceTypeName").toString());
        category.setCategoryCode(map.get("resourceTypeCode").toString());
        category.setLevel(map.get("level").toString());

        categoryService.addOrEditCategory(session, category);

    }
}
