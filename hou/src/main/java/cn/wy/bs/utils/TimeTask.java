package cn.wy.bs.utils;

import cn.wy.bs.service.DemandService;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;


public class TimeTask {

    @Resource
    private DemandService demandService;



    //每个月底将所有的正在开发的需求改为暂停
    @Scheduled(cron = "59 23 L * *")
    public void updateDemandState(){
        try{
            demandService.updateDemandState(4,5);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
