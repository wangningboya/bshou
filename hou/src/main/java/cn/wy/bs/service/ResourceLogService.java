package cn.wy.bs.service;

import cn.wy.bs.entity.ResourceLog;

import javax.servlet.http.HttpSession;

/**
 * @author wy
 * @date 2019-01-10
 */
public interface ResourceLogService {

    void create(HttpSession session, ResourceLog resourceLog);
}
