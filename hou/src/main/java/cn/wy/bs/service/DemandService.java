package cn.wy.bs.service;

import cn.wy.bs.entity.Demand;

import java.util.HashMap;
import java.util.List;

public interface DemandService {

    //获取需求信息
    public List<Demand> findDemand(HashMap<String,Object> map);
}
