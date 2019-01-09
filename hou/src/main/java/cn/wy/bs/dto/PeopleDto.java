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
}
