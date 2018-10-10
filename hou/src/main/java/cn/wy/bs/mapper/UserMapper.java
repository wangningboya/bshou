package cn.wy.bs.mapper;

import cn.wy.bs.entity.User;

import java.util.HashMap;

public interface UserMapper {

    public int findByUserNameAndPassword(HashMap<String,Object> map);

    public User findByUserName(HashMap<String,Object> map);

}
