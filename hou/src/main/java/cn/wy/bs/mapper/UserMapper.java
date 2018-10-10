package cn.wy.bs.mapper;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    public int findByUserNameAndPassword(HashMap<String,Object> map);

    public User findByUserName(HashMap<String,Object> map);

    public List<Auth> findAuthByRoleId(String roleId);
}
