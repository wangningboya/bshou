package cn.wy.bs.service;

import java.util.HashMap;

public interface UserService {

    //根据账号密码验证用户
    public int findByUserNameAndPassword(HashMap<String,Object> map);
}
