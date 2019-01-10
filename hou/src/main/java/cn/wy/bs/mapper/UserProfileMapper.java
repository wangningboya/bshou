package cn.wy.bs.mapper;


import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.utils.BaseMapper;

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
}
