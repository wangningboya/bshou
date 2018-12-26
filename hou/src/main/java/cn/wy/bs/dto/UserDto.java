package cn.wy.bs.dto;

import cn.wy.bs.entity.User;

import java.util.List;

/**
 * @author wy
 * @CreateDate 2018/12/21
 */
public class UserDto extends User {

    /**
     * 角色权限
     */
    private List<String> permissions;

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
