package cn.wy.bs.mapper;

import cn.wy.bs.dto.UserDto;
import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.Role;
import cn.wy.bs.entity.User;
import cn.wy.bs.utils.BaseMapper;

import java.util.HashMap;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    int getByUserNameAndPassword(HashMap<String, Object> map);

    User getByUserName(HashMap<String, Object> map);

    List<Auth> getAuthByRoleId(String roleId);

    List<User> getUserByRoleId(HashMap<String, Object> map);

    Role getRoleByUserName(String userName);

    List<String> getPermissionsByRoleId(String roleId);

    int getUserByUserName(HashMap<String, Object> map);
}
