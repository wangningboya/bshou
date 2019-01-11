package cn.wy.bs.service;

import cn.wy.bs.entity.Auth;
import cn.wy.bs.entity.Role;
import cn.wy.bs.entity.User;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.utils.ResponseData;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface UserService {

    /**
     * 根据账号密码验证用户
     */
    int getByUserNameAndPassword(HashMap<String, Object> map);

    /**
     * 根据账号查询用户信息
     */
    User getByUserName(HashMap<String, Object> map);

    /**
     * 根据角色ID获取菜单权限
     */
    List<Auth> getAuthByRoleId(String roleId);

    /**
     * 获取审核人员
     */
    List<User> getUserByRoleId(HashMap<String, Object> map);

    /**
     * 获取所有人员
     */
    List<UserProfile> getUsers();

    /**
     * 根据用户名获取按钮权限
     */
    List<String> getPermissionsByUserName(String userName);

    /**
     * 根据用户名获取角色
     */
    Role getRoleByUserName(String userName);

    /**
     * 根据用户名获取用户数量
     */
    int getUserByUserName(HashMap<String, Object> map);

    /**
     * 根据手机获取用户数量
     */
    int getUserByPhone(HashMap<String, Object> map);

    /**
     * 注册
     */
    void register(HashMap<String, Object> map);

    /**
     * 修改个人信息
     */
    ResponseData editUser(HttpSession session, HashMap<String, Object> map);

}
