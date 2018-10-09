package cn.wy.bs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/userQuery")
    public int findByUserName(
            @RequestParam HashMap<String,Object> map
    ){

        return 1;
    }
}
