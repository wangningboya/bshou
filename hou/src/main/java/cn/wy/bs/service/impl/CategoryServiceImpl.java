package cn.wy.bs.service.impl;


import cn.wy.bs.constant.Constant;
import cn.wy.bs.dto.CascaderDto;
import cn.wy.bs.entity.Arch;
import cn.wy.bs.entity.Category;
import cn.wy.bs.mapper.ArchMapper;
import cn.wy.bs.mapper.CategoryMapper;
import cn.wy.bs.service.ArchService;
import cn.wy.bs.service.CategoryService;
import cn.wy.bs.utils.BaseUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author wy
 * @date 2019-01-11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public void addOrEditCategory(HttpSession session, Category category) {
        if(category.getID()!=null){

            Category newcategory = categoryMapper.selectByPrimaryKey(category.getID());
            newcategory.setModifiTime(new Date());
            newcategory.setModifiName(session.getAttribute("userName").toString());
            newcategory.setLevel(category.getLevel());
            newcategory.setCategoryName(category.getCategoryName());
            newcategory.setCategoryCode(category.getCategoryCode());

            categoryMapper.updateByPrimaryKeySelective(newcategory);
        }else {
            category.setID(BaseUtil.getUUID());
            category.setIsDelete(Constant.ISDELETED_FALSE_0);
            category.setCreateTime(new Date());
            category.setCreateName(session.getAttribute("userName").toString());
            categoryMapper.insert(category);
        }
    }
}
