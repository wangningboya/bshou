package cn.wy.bs.service;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    // 根据账号密码验证用户
    int getByUserNameAndPassword(HashMap<String, Object> map);

    // 根据账号查询用户信息
    User getByUserName(HashMap<String, Object> map);

    // 根据角色ID获取菜单权限
    List<Auth> getAuthByRoleId(String roleId);

    // 获取审核人员
    List<User> getUserByRoleId(HashMap<String, Object> map);
}
