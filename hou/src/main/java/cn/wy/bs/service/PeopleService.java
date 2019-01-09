package cn.wy.bs.service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author wy
 * @date 2019-01-10
 */
public interface PeopleService {

    /**
     * 创建团队
     */
    void createTeam(HttpSession session, HashMap<String, Object> map);
}
