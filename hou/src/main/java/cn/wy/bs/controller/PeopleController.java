package cn.wy.bs.controller;

import cn.wy.bs.constant.Constant;
import cn.wy.bs.dto.PeopleDto;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.mapper.UserProfileMapper;
import cn.wy.bs.service.PeopleService;
import cn.wy.bs.utils.BaseUtil;
import cn.wy.bs.utils.ResponseData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2019-01-09
 */
@RestController
@RequestMapping(value = "/people")
public class PeopleController {

    @Resource
    private UserProfileMapper userProfileMapper;

    @Resource
    private PeopleService peopleService;

    /**
     * 初始化请求数据
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseData query() {
        ResponseData responseData = new ResponseData();

        //团队架构
        List<PeopleDto> peopleStructure = new ArrayList<>();

        //未分配人员
        PeopleDto unDesignGroup = new PeopleDto();
        unDesignGroup.setResourceName(Constant.RESOURCE_UNDESIGN_GROUP_NAME);
        unDesignGroup.setKey(BaseUtil.getUUID());
        unDesignGroup.setType(Constant.PEOPLE_TYPE_UNDESIGN_GROUP);

        //团队候选者
        List<PeopleDto> unDesignList = new ArrayList<>();

        List<UserProfile> userProfiles = userProfileMapper.selectCandidate();
        for (UserProfile up : userProfiles) {
            PeopleDto p = new PeopleDto();
            p.setKey(up.getID());
            p.setResourceName(up.getResName());
            p.setResourceDepart(up.getResDepart());
            p.setResourceDepartName(up.getResDepartName());
            p.setResourceEmail(up.getEmail());
            p.setIsLeader(up.getIsLeader());
            p.setResourceDescription(up.getResDescription());
            p.setResourceTel(up.getTelephone());
            p.setResourcePhase(up.getResLevel());
            p.setResourceTitle(up.getResPosition());
            p.setResourceSetupDate(up.getSetupDate());
            p.setResType(up.getResType());
            p.setType(Constant.PEOPLE_TYPE_UNDESIGN_ELEMENT);
            unDesignList.add(p);
        }
        unDesignGroup.setChildren(unDesignList);

        //已分配人员
        PeopleDto designGroup = new PeopleDto();
        designGroup.setResourceName(Constant.RESOURCE_DESIGN_GROUP_NAME);
        designGroup.setKey(BaseUtil.getUUID());
        designGroup.setType(Constant.PEOPLE_TYPE_TOP);

        List<PeopleDto> designList = new ArrayList<>();

        //团队列表
        List<UserProfile> teamLeaderList = userProfileMapper.selectLeader();

        for (UserProfile u : teamLeaderList) {
            PeopleDto p = new PeopleDto();
            p.setKey(u.getID());
            p.setResourceName(u.getResName());
            p.setResourceDepart(u.getResDepart());
            p.setResourceDepartName(u.getResDepartName());
            p.setResourceEmail(u.getEmail());
            p.setIsLeader(u.getIsLeader());
            p.setResourceDescription(u.getResDescription());
            p.setResourceTel(u.getTelephone());
            p.setResourcePhase(u.getResLevel());
            p.setResourceTitle(u.getResPosition());
            p.setResourceSetupDate(u.getSetupDate());
            p.setResType(u.getResType());
            p.setType(Constant.PEOPLE_TYPE_LEADER_TYPE);

            HashMap<String, Object> map = new HashMap<>();
            map.put("resTeamId", u.getID());

            List<UserProfile> teamMemebers = userProfileMapper.selectTeamMember(map);
            List<PeopleDto> teamMembersList = new ArrayList<>();
            for (UserProfile us : teamMemebers) {
                PeopleDto pp = new PeopleDto();
                pp.setKey(us.getID());
                pp.setResourceName(us.getResName());
                pp.setResourceDepart(us.getResDepart());
                pp.setResourceDepartName(us.getResDepartName());
                pp.setResourceEmail(us.getEmail());
                pp.setIsLeader(us.getIsLeader());
                pp.setResourceDescription(us.getResDescription());
                pp.setResourceTel(us.getTelephone());
                pp.setResourcePhase(us.getResLevel());
                pp.setResourceTitle(us.getResPosition());
                pp.setResourceSetupDate(us.getSetupDate());
                pp.setResType(us.getResType());
                pp.setType(Constant.PEOPLE_TYPE_DESIGN_ELEMENT);
                teamMembersList.add(pp);
            }
            p.setChildren(teamMembersList);

            designList.add(p);
        }
        designGroup.setChildren(designList);

        peopleStructure.add(designGroup);
        peopleStructure.add(unDesignGroup);

        HashMap<String, Object> ret = new HashMap<>();
        ret.put("data", peopleStructure);
        ret.put("candidate", unDesignList);
        ret.put("team", designList);

        responseData.setData(ret);

        return responseData;
    }

    @RequestMapping(value = "/createTeam", method = RequestMethod.POST)
    public ResponseData createTeam(
            HttpSession session,
            @RequestBody HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        peopleService.createTeam(session, map);
        return responseData;
    }

}
