package cn.wy.bs.mapper;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.Role;
import cn.wy.bs.entity.User;
import cn.wy.bs.utils.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

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

    /**
     * 根据手机号查询
     */
    List<User> selectByTel(String tel);

    /**
     * 查询除ID外的手机ID
     */
    List<User> selectByTel2(@Param("id")String id, @Param("tel")String tel);

    /**
     * 根据账号查找
     */
    User selectByUserName(String userName);
}
