package cn.wy.bs.mapper;


import cn.wy.bs.entity.Role;
import cn.wy.bs.utils.BaseMapper;

import java.util.List;

/**
 * @author wy
 * @date 2019-01-12
 */
public interface RoleMapper extends BaseMapper<Role>{

    /**
     * 获取所有角色
     */
    List<Role> getAll();
}
