package cn.wy.bs.mapper;


import cn.wy.bs.entity.User;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.utils.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2019-01-09
 */
public interface UserProfileMapper extends BaseMapper<UserProfile>{

    /**
     * 获取候选人
     */
    List<UserProfile> selectCandidate();

    /**
     * 获取队伍领导者
     */
    List<UserProfile> selectLeader();

    /**
     * 根据队伍ID获取队员
     */
    List<UserProfile> selectTeamMember(Map<String, Object> map);

    /**
     * 根据ID查询
     */
    UserProfile selectById(String id);

    /**
     * 根据队伍ID查找
     */
    List<UserProfile> selectByTeamId(String id);

    /**
     * 根据资源类型超找
     */
    List<UserProfile> selectMembersByResType(String categoryCode);

    /**
     * 根据手机号查找
     */
    List<UserProfile> selectByTel(String tel);

    /**
     * 获取所有资源的人员
     */
    List<UserProfile> getUsers();

    /**
     * 根据用户ID查找
     */
    UserProfile selectByUserId(String id);

    /**
     * 查询除ID外的手机ID
     */
    List<UserProfile> selectByTel2(@Param("id")String id, @Param("tel")String tel);
}
