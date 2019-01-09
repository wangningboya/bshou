package cn.wy.bs.service;

import cn.wy.bs.entity.Arch;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2019-01-09
 */
public interface ArchService {

    /**
     * 获取所有架构
     */
    List<Arch> getArchs();

    /**
     * 新增架构
     */
    void add(HttpSession session, Arch arch);

    /**
     * 修改架构
     */
    void update(HttpSession session, HashMap<String, Object> map);

    /**
     * 删除架构
     */
    void delete(HttpSession session, HashMap<String, Object> map);
}
