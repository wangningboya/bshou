package cn.wy.bs.service.impl;

import cn.wy.bs.dto.UserDto;
import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.Role;
import cn.wy.bs.entity.User;
import cn.wy.bs.mapper.UserMapper;
import cn.wy.bs.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int getByUserNameAndPassword(HashMap<String, Object> map) {
        return userMapper.getByUserNameAndPassword(map);
    }

    @Override
    public User getByUserName(HashMap<String, Object> map) {
        return userMapper.getByUserName(map);
    }

    @Override
    public List<Auth> getAuthByRoleId(String roleId) {
        return userMapper.getAuthByRoleId(roleId);
    }

    @Override
    public List<User> getUserByRoleId(HashMap<String, Object> map) {
        return userMapper.getUserByRoleId(map);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectAll();
    }

    @Override
    public List<String> getPermissionsByUserName(String userName) {
        Role role = getRoleByUserName(userName);
        return userMapper.getPermissionsByRoleId(role.getID());
    }

    @Override
    public Role getRoleByUserName(String userName) {
        return userMapper.getRoleByUserName(userName);
    }
}
