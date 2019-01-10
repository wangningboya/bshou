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

    /**
     * 加入团队
     */
    void pickup(HttpSession session, HashMap<String, Object> map);

    /**
     * 撤出团队
     */
    void getout(HttpSession session, HashMap<String, Object> map);

    /**
     * 解散团队
     */
    void dismiss(HttpSession session, HashMap<String, Object> map);
}
