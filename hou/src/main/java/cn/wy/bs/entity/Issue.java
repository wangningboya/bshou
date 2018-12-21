package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2018-12-14
 */
@Table(name = "t_issue")
public class Issue extends BaseModal {

    /**
     * 问题编号
     */
    @Column(name = "ISSUENO")
    private String issueNo;

    /**
     * 问题名称
     */
    @Column(name = "ISSUENAME")
    private String issueName;

    /**
     * 问题内容
     */
    @Column(name = "ISSUECONTENT")
    private String issueContent;

    /**
     * 问题状态
     */
    @Column(name = "STATE")
    private Integer state;

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public String getIssueContent() {
        return issueContent;
    }

    public void setIssueContent(String issueContent) {
        this.issueContent = issueContent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
