package cn.wy.bs.controller;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.User;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.mapper.UserMapper;
import cn.wy.bs.service.UserService;
import cn.wy.bs.utils.ResponseData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/userQuery")
    public ResponseData findByUserName(
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        User user = userService.getByUserName(map);
        jsonObject.put("user", user);
        responseData.setData(jsonObject);
        responseData.setRspCode("000000");
        return responseData;
    }

    @RequestMapping(value = "/getUserAndMenu")
    public ResponseData getUserAndMenu(
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        User user = userService.getByUserName(map);
        List<Auth> authList = userService.getAuthByRoleId(user.getRoleId());
        jsonObject.put("user", user);
        jsonObject.put("authList", authList);
        responseData.setData(jsonObject);
        responseData.setRspCode("000000");
        return responseData;
    }

    @RequestMapping(value = "/getUserByRoleId")
    public ResponseData getUserByRoleId(
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        List<User> userList = userService.getUserByRoleId(map);
        jsonObject.put("userList", userList);
        responseData.setData(jsonObject);
        responseData.setRspCode("000000");
        return responseData;
    }

    @RequestMapping(value = "/getUsers")
    public ResponseData getUsers(
    ) {
        ResponseData responseData = new ResponseData();
        List<UserProfile> userList = userService.getUsers();
        responseData.setData(userList);
        return responseData;
    }

    @RequestMapping(value = "/checkUserName")
    public ResponseData checkUserName(
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        int a = userService.getUserByUserName(map);
        if (a == 0) {
            responseData.setRspCode("1");
        } else {
            responseData.setRspCode("0");
        }
        return responseData;
    }


    @RequestMapping(value = "/editUser")
    public ResponseData editUser(
            HttpSession session,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try{
            userService.editUser(session, map);
            responseData.setRspCode("000000");
            responseData.setRspMsg("修改成功");
            return responseData;
        }catch (Exception e){
            responseData.setRspCode("999999");
            responseData.setRspMsg("修改失败");
            return responseData;
        }
    }

    @RequestMapping(value = "/currentUser")
    public ResponseData currentUser(
            HttpSession session
    ) {
        ResponseData responseData = new ResponseData();
        try{
            User user = userMapper.selectByUserName(session.getAttribute("userName").toString());
            responseData.setData(user);
            responseData.setRspCode("000000");
            return responseData;
        }catch (Exception e){
            responseData.setRspCode("999999");
            return responseData;
        }
    }
}
