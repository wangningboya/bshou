package cn.wy.bs.dto;

import cn.wy.bs.entity.User;

import java.util.List;

/**
 * @author kaiqian
 * @CreateDate 2017/12/4
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
