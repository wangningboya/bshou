package cn.wy.bs.controller;

import cn.wy.bs.constant.Constant;
import cn.wy.bs.dto.DemandDto;
import cn.wy.bs.entity.Project;
import cn.wy.bs.entity.User;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.mapper.DemandMapper;
import cn.wy.bs.mapper.ProjectMapper;
import cn.wy.bs.mapper.UserMapper;
import cn.wy.bs.mapper.UserProfileMapper;
import cn.wy.bs.service.DemandService;
import cn.wy.bs.service.UserService;
import cn.wy.bs.utils.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author wy
 * @date 2019-01-11
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private DemandService demandService;

    @Resource
    private DemandMapper demandMapper;

    @Resource
    private UserProfileMapper userProfileMapper;

    @Resource
    private ProjectMapper projectMapper;

    /**
     * 初始化主页数据
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseData getArchs(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        HashMap<String, Object> ret = new HashMap<>();


        //个人信息
        User user = userService.getByUserName(map);

        //我的任务
        PageInfo<DemandDto> myTaskDemandList = demandService.getDemandListByDevId(pageNum, pageSize, map);

        //我创建的任务
        PageInfo<DemandDto> myCreateDemandList = demandService.getDemandListByCreactName(pageNum, pageSize, map);

        //团队成员
        User user2 = new User();
        user2 = userMapper.selectByUserName(map.get("userName").toString());

        UserProfile userProfile = userProfileMapper.selectByUserId(user2.getID());

        List<UserProfile> userProfiles = new ArrayList<>();

        //组长
        if (Constant.RESOURCE_IS_LEADER.equals(userProfile.getIsLeader())) {
            ret.put("teamLeader", userProfile);

            //团队成员
            userProfiles = userProfileMapper.selectByTeamId(userProfile.getID());

        } else {
            UserProfile teamLeader = userProfileMapper.selectByPrimaryKey(userProfile.getResTeamId());
            ret.put("teamLeader", teamLeader);

            if (teamLeader != null) {

                //团队成员
                userProfiles = userProfileMapper.selectByTeamId(userProfile.getResTeamId());

            }

        }

        //我参与的项目
        List<Project> projects = new ArrayList<>();
        Set projectId = new HashSet();
        for (DemandDto d : myTaskDemandList.getList()) {
            projectId.add(d.getProjectId());
        }
        for (DemandDto d : myCreateDemandList.getList()) {
            projectId.add(d.getProjectId());
        }
        for (Object str : projectId) {
            projects.add(projectMapper.selectByPrimaryKey(str.toString()));
        }

        //计算我本月的工时
        Set myDemandSet = new HashSet();
        Double myWorkingHours = 0d;
        List<DemandDto> myDemandList = demandMapper.getDemandListByDevId(user.getID());
        for (DemandDto d : myDemandList) {
            myDemandSet.add(d);
        }
        for (Object d : myDemandSet) {
            DemandDto demandDto = (DemandDto) d;
            String id = demandDto.getID();
            myWorkingHours += demandService.getTimeByIdDuringTheMonth(id);
        }
        BigDecimal bg1 = new BigDecimal(myWorkingHours / 60);
        myWorkingHours = bg1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        //计算团队本月工时
        Set teamDemandSet = new HashSet();
        Double teamWorkingHours = 0d;

        UserProfile leaderUserProfile = (UserProfile) ret.get("teamLeader");
        List<DemandDto> leaderDemandList = demandMapper.getDemandListByDevId(leaderUserProfile.getUserId());
        for (DemandDto d : leaderDemandList) {
            teamDemandSet.add(d);
        }
        for (int i = 0; i < userProfiles.size(); i++) {
            List<DemandDto> memberDemandList = demandMapper.getDemandListByDevId(userProfiles.get(i).getUserId());
            for (DemandDto d : memberDemandList) {
                teamDemandSet.add(d);
            }
        }
        for (Object d : teamDemandSet) {
            DemandDto demandDto = (DemandDto) d;
            String id = demandDto.getID();
            teamWorkingHours += demandService.getTimeByIdDuringTheMonth(id);
        }

        BigDecimal bg2 = new BigDecimal(teamWorkingHours / 60);
        teamWorkingHours = bg2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();


        ret.put("user", user);
        ret.put("myTaskDemandList", myTaskDemandList);
        ret.put("myCreateDemandList", myCreateDemandList);
        ret.put("teams", userProfiles);
        ret.put("projects", projects);
        ret.put("myWorkingHours", myWorkingHours);
        ret.put("teamWorkingHours", teamWorkingHours);
        responseData.setData(ret);
        responseData.setRspCode("000000");
        return responseData;
    }

}
