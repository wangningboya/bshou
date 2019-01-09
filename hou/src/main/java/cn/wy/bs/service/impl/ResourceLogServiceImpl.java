package cn.wy.bs.service.impl;


import cn.wy.bs.constant.enums.ResLogTypeEnum;
import cn.wy.bs.entity.ResourceLog;
import cn.wy.bs.mapper.ResourceLogMapper;
import cn.wy.bs.service.ResourceLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author wy
 * @date 2019-01-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceLogServiceImpl implements ResourceLogService {

    @Resource
    private ResourceLogMapper resourceLogMapper;

    @Override
    public void create(HttpSession session, ResourceLog resourceLog) {
        resourceLog.setLogTypeName(ResLogTypeEnum.getName(resourceLog.getLogType()));
        resourceLog.setCreateTime(new Date());
        resourceLog.setCreateName(session.getAttribute("userName").toString());
        resourceLogMapper.insert(resourceLog);
    }
}
