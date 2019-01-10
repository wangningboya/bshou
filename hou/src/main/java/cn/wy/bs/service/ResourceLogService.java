package cn.wy.bs.service;

import cn.wy.bs.entity.ResourceLog;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2019-01-10
 */
public interface ResourceLogService {

    /**
     * 创建日志
     */
    void create(HttpSession session, ResourceLog resourceLog);

    /**
     * 获取日志
     */
    List<ResourceLog> selectByUserProfileId(HashMap<String, Object> map);
}
