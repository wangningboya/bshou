package cn.wy.bs.dto;

public class DemandDto {

    /**
     * 需求编号
     */
    private String demandNO;

    /**
     * 需求名称
     */
    private String demandName;

    /**
     * 需求类型（0需求/1BUG）
     */
    private Integer demandType;

    /**
     * 项目编号
     */
    private String projectNO;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 状态（0提出需求/1需求审核/2审核通过/3审核未通过/4预估时间/5开发开始/6开发暂停/7开发结束/8开发关闭/9需求验收）
     */
    private Integer state;
}
