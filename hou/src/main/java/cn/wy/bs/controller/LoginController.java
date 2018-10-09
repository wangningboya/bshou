package cn.wy.bs.controller;

import cn.wy.bs.service.UserService;
import cn.wy.bs.utils.ResponseData;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/login")
    public ResponseData login(
            HttpServletRequest request
//            @RequestBody HashMap<String,Object> map
    ){
        ResponseData responseData=new ResponseData();
        JSONObject jsonObject = new JSONObject();
        System.out.println("login");
//        int count=userService.findByUserNameAndPassword(map);
//        switch (count){
//            case 0:
//                responseData.setRspCode("100001");
//                responseData.setRspMsg("账号或者密码错误！");
//                break;
//            case 1:
//                HttpSession session =request.getSession();
//                session.setAttribute("userName",map.get("username"));
//                jsonObject.put("userName",session.getAttribute("userName"));
//                responseData.setData(jsonObject);
//                responseData.setRspCode("000000");
//                responseData.setRspMsg("登录成功");
//                break;
//        }
        return responseData;
    }
}
