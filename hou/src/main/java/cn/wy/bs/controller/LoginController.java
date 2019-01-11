package cn.wy.bs.controller;

import cn.wy.bs.dto.UserDto;
import cn.wy.bs.entity.User;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.mapper.UserMapper;
import cn.wy.bs.mapper.UserProfileMapper;
import cn.wy.bs.service.UserService;
import cn.wy.bs.utils.ResponseData;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserProfileMapper userProfileMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseData login(
            HttpServletRequest request,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        int count = userService.getByUserNameAndPassword(map);
        UserDto userDto = new UserDto();
        switch (count) {
            case 0:
                responseData.setRspCode("100001");
                responseData.setRspMsg("账号或者密码错误！");
                break;
            case 1:
                String userName = map.get("userName").toString();
                User u = userMapper.selectByUserName(userName);
                String id = u.getID();
                UserProfile userProfile = userProfileMapper.selectByUserId(id);
                if(userProfile==null){
                    responseData.setRspCode("666666");
                    responseData.setRspMsg("此账号无资源，请联系管理员");
                    return responseData;
                }

                HttpSession session = request.getSession();
                session.setAttribute("userName", map.get("userName"));
                List<String> permissionsList = userService.getPermissionsByUserName(map.get("userName").toString());
                User user = userService.getByUserName(map);
                userDto.setID(user.getID());
                userDto.setUserName(user.getUserName());
                userDto.setRealName(user.getRealName());
                userDto.setPermissions(permissionsList);
                session.setAttribute("user", userDto);
                jsonObject.put("userName", session.getAttribute("userName"));
                responseData.setData(jsonObject);
                responseData.setRspCode("000000");
                responseData.setRspMsg("登录成功");
                break;
            default:
        }
        return responseData;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseData logout(
            HttpServletRequest request
    ) {
        ResponseData responseData = new ResponseData();
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        responseData.setRspCode("000000");
        responseData.setRspMsg("登出成功");
        return responseData;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ResponseData register(
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            userService.register(map);
            responseData.setData(map.get("userName").toString());
            responseData.setRspCode("000000");
            responseData.setRspMsg("注册成功");
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("注册失败");
            return responseData;
        }

    }
}
