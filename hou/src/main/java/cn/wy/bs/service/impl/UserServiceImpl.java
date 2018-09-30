package cn.wy.bs.service.impl;

import cn.wy.bs.mapper.UserMapper;
import cn.wy.bs.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int findByUserNameAndPassword(HashMap<String,Object> map) {
        return userMapper.findByUserNameAndPassword(map);
    }
}
