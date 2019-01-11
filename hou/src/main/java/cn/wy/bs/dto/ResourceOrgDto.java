package cn.wy.bs.dto;

import java.util.Date;
import java.util.List;

/**
 * @author wy
 * @CreateDate 2019/01/10
 */
public class ResourceOrgDto {

    private String key;

    private String resourceName;

    private String resourcePhase;

    private int type;

    private String resourceTitle;

    private String resourceTel;

    private String resourceEmail;

    private String resourceDepart;

    private String resourceDepartName;

    private Date resourceSetupDate;

    private String resourceDescription;

    private String resType;

    private String resRoleId;

    private List<ResourceOrgDto> children;

    public String getResourceDepartName() {
        return resourceDepartName;
    }

    public void setResourceDepartName(String resourceDepartName) {
        this.resourceDepartName = resourceDepartName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourcePhase() {
        return resourcePhase;
    }

    public void setResourcePhase(String resourcePhase) {
        this.resourcePhase = resourcePhase;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getResourceTel() {
        return resourceTel;
    }

    public void setResourceTel(String resourceTel) {
        this.resourceTel = resourceTel;
    }

    public String getResourceEmail() {
        return resourceEmail;
    }

    public void setResourceEmail(String resourceEmail) {
        this.resourceEmail = resourceEmail;
    }

    public String getResourceDepart() {
        return resourceDepart;
    }

    public void setResourceDepart(String resourceDepart) {
        this.resourceDepart = resourceDepart;
    }

    public Date getResourceSetupDate() {
        return resourceSetupDate;
    }

    public void setResourceSetupDate(Date resourceSetupDate) {
        this.resourceSetupDate = resourceSetupDate;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getResRoleId() {
        return resRoleId;
    }

    public void setResRoleId(String resRoleId) {
        this.resRoleId = resRoleId;
    }

    public List<ResourceOrgDto> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceOrgDto> children) {
        this.children = children;
    }
}
