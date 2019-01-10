package cn.wy.bs.service;

import cn.wy.bs.dto.ResourceOrgDto;
import cn.wy.bs.utils.ResponseData;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author wy
 * @date 2019-01-10
 */
public interface UserProfileService {

    /**
     * 新增
     */
    ResponseData create(HttpSession session, ResourceOrgDto resourceOrgDto);

    /**
     * 更新
     */
    ResponseData updateOrg(HttpSession session, String id, ResourceOrgDto resourceOrgDto);

    /**
     * 删除
     */
    void removeOrg(HttpSession session, String id);

    /**
     * 创建资源类别
     */
    void createOrgResType(HttpSession session, HashMap<String, Object> map);
}
