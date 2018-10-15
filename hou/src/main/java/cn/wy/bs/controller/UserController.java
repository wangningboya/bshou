package cn.wy.bs.controller;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.User;
import cn.wy.bs.service.UserService;
import cn.wy.bs.utils.ResponseData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/userQuery")
    public int findByUserName(
            @RequestParam HashMap<String, Object> map
    ){
        System.out.println("query");
        return 1;
    }

    @RequestMapping(value = "/getUserAndMenu")
    public ResponseData getUserAndMenu(
            @RequestParam HashMap<String, Object> map
    ){
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
    ){
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        List<User> userList = userService.getUserByRoleId(map);
        jsonObject.put("userList", userList);
        responseData.setData(jsonObject);
        responseData.setRspCode("000000");
        return responseData;
    }
}
