package cn.wy.bs.controller;

import cn.wy.bs.utils.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(){
        System.out.println("succeess");
        return "aaa";
    }
}
