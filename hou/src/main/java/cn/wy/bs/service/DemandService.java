package cn.wy.bs.service;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;
import cn.wy.bs.utils.Page;

import java.util.HashMap;
import java.util.List;

public interface DemandService {

    // 获取需求信息
    List<DemandDto> getDemand(HashMap<String, Object> map);

    // 获取需求信息数量
    int getDemandNum(HashMap<String, Object> map);

    // 获取需求信息列表
    List<DemandDto> getDemandList(Page<DemandDto> demandDtoPage);

    // 添加需求
    void saveDemand(Demand demand);

    //修改需求
    void updateDemand(Demand demand);
}
