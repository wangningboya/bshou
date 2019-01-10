package cn.wy.bs.service.impl;


import cn.wy.bs.constant.Constant;
import cn.wy.bs.dto.CascaderDto;
import cn.wy.bs.entity.Arch;
import cn.wy.bs.mapper.ArchMapper;
import cn.wy.bs.service.ArchService;
import cn.wy.bs.utils.BaseUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2019-01-09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArchServiceImpl implements ArchService {

    @Resource
    private ArchMapper archMapper;

    @Override
    public List<Arch> getArchs() {
        return archMapper.getArchs();
    }

    @Override
    public void add(HttpSession session, Arch arch) {
        arch.setCreateTime(new Date());
        arch.setCreateName(session.getAttribute("userName").toString());
        arch.setID(BaseUtil.getUUID());
        arch.setIsDelete(0);
        archMapper.insert(arch);
    }

    @Override
    public void update(HttpSession session, HashMap<String, Object> map) {
        Arch arch = new Arch();
        arch.setID(map.get("parentId").toString());
        arch.setDepName(map.get("depName").toString());
        arch.setDepCode(map.get("depCode").toString());
        arch.setModifiName(session.getAttribute("userName").toString());
        arch.setModifiTime(new Date());
        archMapper.updateByPrimaryKeySelective(arch);
    }

    @Override
    public void delete(HttpSession session, HashMap<String, Object> map) {
        Arch arch = new Arch();
        arch.setID(map.get("id").toString());
        arch.setModifiName(session.getAttribute("userName").toString());
        arch.setModifiTime(new Date());
        arch.setIsDelete(1);
        archMapper.updateByPrimaryKeySelective(arch);
    }

    @Override
    public List<CascaderDto> queryCascader() {
        List<CascaderDto> cascaderDtos = new ArrayList<>();

        List<Arch> archProfiles = archMapper.getArchs();

        for (Arch a : archProfiles) {

            CascaderDto c = new CascaderDto();
            c.setId(a.getID());
            c.setKey(a.getID());
            c.setLabel(a.getDepName());
            c.setValue(a.getID());
            c.setParentId(a.getParentId());

            cascaderDtos.add(c);
        }

        return cascaderDtos;
    }

    @Override
    public String queryDepName(String resDepart) {
        String[] departs = resDepart.split(",");

        StringBuilder ret = new StringBuilder();

        int count = 0;
        for (String d : departs) {

            ret.append(archMapper.selectByPrimaryKey(d).getDepName());

            if (count < departs.length - 1) {
                ret.append('-');
            }
            count++;
        }

        return ret.toString();
    }

}
