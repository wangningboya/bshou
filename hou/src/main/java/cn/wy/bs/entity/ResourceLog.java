package cn.wy.bs.entity;

import cn.wy.bs.utils.BaseModal;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author wy
 * @CreateDate 2019/01/10
 */
@Table(name = "T_RESOURCELOG")
public class ResourceLog extends BaseModal {

    @Column(name = "USERPROFILEID")
    private String userProfileId;

    @Column(name = "OCCURTIME")
    private Date occurTime;

    @Column(name = "LOGTYPE")
    private String logType;

    @Column(name = "LOGTYPENAME")
    private String logTypeName;

    @Column(name = "LOGCONTENT")
    private String logContent;

    public String getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(String userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogTypeName() {
        return logTypeName;
    }

    public void setLogTypeName(String logTypeName) {
        this.logTypeName = logTypeName;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }
}
