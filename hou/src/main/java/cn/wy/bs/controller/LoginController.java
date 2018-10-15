package cn.wy.bs.controller;

import cn.wy.bs.service.UserService;
import cn.wy.bs.utils.ResponseData;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/test")
    public String test(){
        System.out.println("testttttt");
        return "aaa";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public ResponseData login(
            HttpServletRequest request,
            @RequestParam HashMap<String, Object> map
    ){
        ResponseData responseData = new ResponseData();
        JSONObject jsonObject = new JSONObject();
        int count = userService.getByUserNameAndPassword(map);
        switch (count){
            case 0:
                responseData.setRspCode("100001");
                responseData.setRspMsg("账号或者密码错误！");
                break;
            case 1:
                HttpSession session = request.getSession();
                session.setAttribute("userName",map.get("userName"));
                jsonObject.put("userName",session.getAttribute("userName"));
                responseData.setData(jsonObject);
                responseData.setRspCode("000000");
                responseData.setRspMsg("登录成功");
                break;
        }
        return responseData;
    }

    @RequestMapping(value = "/logout" , method = RequestMethod.GET)
    public ResponseData logout(
            HttpServletRequest request
    ){
        ResponseData responseData = new ResponseData();
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        responseData.setRspCode("000000");
        responseData.setRspMsg("登出成功");
        return responseData;
    }
}
