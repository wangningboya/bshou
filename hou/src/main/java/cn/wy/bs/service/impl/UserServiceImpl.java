package cn.wy.bs.service.impl;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.Role;
import cn.wy.bs.entity.User;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.mapper.UserMapper;
import cn.wy.bs.mapper.UserProfileMapper;
import cn.wy.bs.service.UserProfileService;
import cn.wy.bs.service.UserService;
import cn.wy.bs.utils.BaseUtil;
import cn.wy.bs.utils.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserProfileMapper userProfileMapper;

    @Override
    public int getByUserNameAndPassword(HashMap<String, Object> map) {
        return userMapper.getByUserNameAndPassword(map);
    }

    @Override
    public User getByUserName(HashMap<String, Object> map) {
        return userMapper.getByUserName(map);
    }

    @Override
    public List<Auth> getAuthByRoleId(String roleId) {
        return userMapper.getAuthByRoleId(roleId);
    }

    @Override
    public List<User> getUserByRoleId(HashMap<String, Object> map) {
        return userMapper.getUserByRoleId(map);
    }

    @Override
    public List<UserProfile> getUsers() {
        return userProfileMapper.getUsers();
    }

    @Override
    public List<String> getPermissionsByUserName(String userName) {
        Role role = getRoleByUserName(userName);
        return userMapper.getPermissionsByRoleId(role.getID());
    }

    @Override
    public Role getRoleByUserName(String userName) {
        return userMapper.getRoleByUserName(userName);
    }

    @Override
    public int getUserByUserName(HashMap<String, Object> map) {
        return userMapper.getUserByUserName(map);
    }

    @Override
    public int getUserByPhone(HashMap<String, Object> map) {
        return userMapper.getUserByPhone(map);
    }

    @Override
    public void register(HashMap<String, Object> map) {
        User user = new User();
        user.setID(BaseUtil.getUUID());
        user.setIsDelete(0);
        user.setCreateTime(new Date());
        user.setUserName(map.get("userName").toString());
        user.setPassword(map.get("password").toString());
        user.setRealName(map.get("realName").toString());
        user.setRoleId("f72f83c71ead442db5ab102b7d9cf9bc");
        if (map.containsKey("phone")) {
            if (map.get("phone").toString() != "") {
                user.setPhone(map.get("phone").toString());
            }
        }
        if (map.containsKey("email")) {
            if (map.get("email").toString() != "") {
                user.setEmail(map.get("email").toString());
            }
        }
        userMapper.insert(user);
    }

    @Override
    public ResponseData editUser(HttpSession session, HashMap<String, Object> map) {
        ResponseData responseData = new ResponseData();
        String tel = map.get("phone").toString();
        String id = map.get("id").toString();
        UserProfile userProfile = userProfileMapper.selectByUserId(id);
        String id2 = userProfile.getID();

        List<User> userList = userMapper.selectByTel2(id, tel);
        if (userList.size() > 0) {
            responseData.setRspCode("888888");
            responseData.setRspMsg("已存在此手机号的账号");
            return responseData;
        }

        List<UserProfile> userProfileList = userProfileMapper.selectByTel2(id2, tel);
        if (userProfileList.size() > 0) {
            responseData.setRspCode("888888");
            responseData.setRspMsg("已存在此手机号的资源");
            return responseData;
        }




        User user = new User();
        user.setModifiName(session.getAttribute("userName").toString());
        user.setModifiTime(new Date());
        if (map.containsKey("password")) {
            if (map.get("password").toString() != "") {
                user.setPassword(map.get("password").toString());
            }
        }
        user.setID(map.get("id").toString());
        user.setRealName(map.get("realName").toString());
        userProfile.setResName(map.get("realName").toString());
        user.setPhone(map.get("phone").toString());
        userProfile.setTelephone(map.get("phone").toString());
        user.setEmail(map.get("email").toString());
        userMapper.updateByPrimaryKeySelective(user);
        userProfileMapper.updateByPrimaryKeySelective(userProfile);
        responseData.setRspCode("000000");
        responseData.setRspMsg("修改成功");
        return responseData;
    }
}
