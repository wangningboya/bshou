package cn.wy.bs.mapper;

import java.util.HashMap;

public interface UserMapper {

    public int findByUserNameAndPassword(HashMap<String,Object> map);

}