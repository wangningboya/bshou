package cn.wy.bs.service;

import cn.wy.bs.entity.Category;

import javax.servlet.http.HttpSession;

/**
 * @author wy
 * @date 2019-01-11
 */
public interface CategoryService {

    void addOrEditCategory(HttpSession session, Category category);
}
