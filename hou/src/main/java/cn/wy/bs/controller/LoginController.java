package cn.wy.bs.controller;

import cn.wy.bs.dto.UserDto;
import cn.wy.bs.entity.User;
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
}
