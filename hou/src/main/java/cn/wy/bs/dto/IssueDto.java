package cn.wy.bs.dto;


import cn.wy.bs.entity.Demand;
import cn.wy.bs.entity.Issue;

import java.io.Serializable;
import java.util.List;

/**
 * @author wy
 * @CreateDate 2018/12/21
 */
public class IssueDto extends Issue implements Serializable{


    private List<Demand> demands;

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }
}
