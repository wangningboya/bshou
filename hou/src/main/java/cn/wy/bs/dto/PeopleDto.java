package cn.wy.bs.dto;

import java.util.Date;
import java.util.List;

/**
 * @author wy
 * @CreateDate 2019/01/08
 */
public class PeopleDto {

    private String key;

    private String isLeader;

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

    private List<PeopleDto> children;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
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

    public String getResourceDepartName() {
        return resourceDepartName;
    }

    public void setResourceDepartName(String resourceDepartName) {
        this.resourceDepartName = resourceDepartName;
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

    public List<PeopleDto> getChildren() {
        return children;
    }

    public void setChildren(List<PeopleDto> children) {
        this.children = children;
    }
}
