package cn.wy.bs.mapper;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    int getByUserNameAndPassword(HashMap<String, Object> map);

    User getByUserName(HashMap<String, Object> map);

    List<Auth> getAuthByRoleId(String roleId);

    List<User> getUserByRoleId(HashMap<String, Object> map);
}
