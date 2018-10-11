package cn.wy.bs.mapper;

import cn.wy.bs.entity.Demand;

import java.util.HashMap;
import java.util.List;

public interface DemandMapper {

    public List<Demand> findDemand(HashMap<String,Object> map);
}
