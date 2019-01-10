package cn.wy.bs.controller;

import cn.wy.bs.constant.Constant;
import cn.wy.bs.dto.IdDto;
import cn.wy.bs.dto.ResourceOrgDto;
import cn.wy.bs.entity.Category;
import cn.wy.bs.entity.UserProfile;
import cn.wy.bs.mapper.CategoryMapper;
import cn.wy.bs.mapper.UserProfileMapper;
import cn.wy.bs.service.ArchService;
import cn.wy.bs.service.UserProfileService;
import cn.wy.bs.utils.BaseModal;
import cn.wy.bs.utils.BaseUtil;
import cn.wy.bs.utils.ResponseData;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2019-01-10
 */
@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private UserProfileService userProfileService;

    @Resource
    private UserProfileMapper userProfileMapper;

    @Resource
    private ArchService archService;

    /**
     * 初始化数据
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    ResponseData query() throws Exception {

        ResponseData responseData = new ResponseData();

        List<ResourceOrgDto> orgStructure = new ArrayList<>();

        //获取组织的头儿
        List<Category> categoryList = categoryMapper.selectOrg();

        //获取资源
        for (Category category : categoryList) {

            ResourceOrgDto resourceOrgDto = new ResourceOrgDto();
            resourceOrgDto.setKey(category.getID());
            resourceOrgDto.setResourceName(category.getCategoryName());
            resourceOrgDto.setType(Constant.ORG_TYPE_TOP);
            resourceOrgDto.setResType(category.getCategoryCode());

            List<Category> categoryList1 = categoryMapper.selectMember(category.getCategoryCode());

            List<ResourceOrgDto> orgTop = new ArrayList<>();
            if (categoryList1.size() > 0) {

                // 获取成员
                for (Category cat : categoryList1) {
                    List<ResourceOrgDto> children = getResouceElement(cat);
                    ResourceOrgDto orgResDto = new ResourceOrgDto();
                    orgResDto.setKey(cat.getID());
                    orgResDto.setResourceName(cat.getCategoryName());
                    orgResDto.setType(Constant.ORG_TYPE_RESOURCE_TYPE);
                    orgResDto.setChildren(children);
                    orgResDto.setResType(cat.getCategoryCode());
                    orgTop.add(orgResDto);
                }

            } else {
                orgTop = getResouceElement(category);
            }

            resourceOrgDto.setChildren(orgTop);

            orgStructure.add(resourceOrgDto);

        }

        HashMap<String, Object> ret = new HashMap<>();
        ret.put("archData", archService.queryCascader());
        ret.put("orgData", orgStructure);

        responseData.setData(ret);
        responseData.setRspCode("000000");
        return responseData;
    }

    private List<ResourceOrgDto> getResouceElement(Category cat) {

        List<UserProfile> userProfiles = userProfileMapper.selectMembersByResType(cat.getCategoryCode());

        List<ResourceOrgDto> children = new ArrayList<>();

        for (UserProfile u : userProfiles) {
            ResourceOrgDto rOrg = new ResourceOrgDto();
            rOrg.setType(Constant.ORG_TYPE_RESOURCE_ELEMENT);
            rOrg.setResourceName(u.getResName());
            rOrg.setResourceDepart(u.getResDepart());
            rOrg.setResourcePhase(u.getResLevel());
            rOrg.setResourceTitle(u.getResPosition());
            rOrg.setResourceSetupDate(u.getSetupDate());
            rOrg.setResourceEmail(u.getEmail());
            rOrg.setResourceTel(u.getTelephone());
            rOrg.setResourceDescription(u.getResDescription());
            rOrg.setKey(u.getID());
            rOrg.setResourceDepartName(u.getResDepartName());
            rOrg.setResType(u.getResType());
            children.add(rOrg);
        }

        return children;
    }


    @RequestMapping(value = "/createOrg", method = RequestMethod.POST)
    public ResponseData createOrg(
            HttpSession session,
            @RequestBody ResourceOrgDto resourceOrgDto
    ) {
        ResponseData responseData = new ResponseData();
        try {
            responseData = userProfileService.create(session, resourceOrgDto);
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("创建失败");
            return responseData;
        }
    }

    @RequestMapping(value = "/updateOrg/{id}", method = RequestMethod.PATCH)
    public ResponseData updateOrg(
            HttpSession session,
            @PathVariable String id,
            @RequestBody ResourceOrgDto resourceOrgDto
    ) {
        ResponseData responseData = new ResponseData();
        try {
            responseData = userProfileService.updateOrg(session, id, resourceOrgDto);
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("修改失败");
            return responseData;
        }
    }

    @RequestMapping(value = "/removeOrg/{id}", method = RequestMethod.DELETE)
    public ResponseData removeOrg(
            HttpSession session,
            @PathVariable String id
    ) {
        ResponseData responseData = new ResponseData();
        try {
            userProfileService.removeOrg(session, id);
            responseData.setRspCode("000000");
            responseData.setRspMsg("删除成功");
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("删除失败");
            return responseData;
        }
    }


    @RequestMapping(value = "/createOrgResType", method = RequestMethod.POST)
    public ResponseData createOrgResType(
            HttpSession session,
            @RequestBody HashMap<String, Object> map
    ) {
        ResponseData responseData = new ResponseData();
        try {
            userProfileService.createOrgResType(session, map);
            responseData.setRspCode("000000");
            responseData.setRspMsg("新增资源类型成功");
            return responseData;
        } catch (Exception e) {
            responseData.setRspCode("999999");
            responseData.setRspMsg("新增资源类型失败");
            return responseData;
        }
    }

}
