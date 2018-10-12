package cn.wy.bs.service.impl;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.User;
import cn.wy.bs.mapper.UserMapper;
import cn.wy.bs.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int findByUserNameAndPassword(HashMap<String,Object> map) {
        return userMapper.findByUserNameAndPassword(map);
    }

    @Override
    public User findByUserName(HashMap<String, Object> map) {
        return userMapper.findByUserName(map);
    }

    @Override
    public List<Auth> findAuthByRoleId(String roleId) {
        return userMapper.findAuthByRoleId(roleId);
    }

    @Override
    public List<User> getUserByRoleId(HashMap<String,Object> map) {
        return userMapper.getUserByRoleId(map);
    }
}
