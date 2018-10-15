package cn.wy.bs.service;

import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Demand;

import java.util.HashMap;
import java.util.List;

public interface DemandService {

    // 获取需求信息
    List<DemandDto> getDemand(HashMap<String, Object> map);

    // 添加需求
    void saveDemand(Demand demand);
}
