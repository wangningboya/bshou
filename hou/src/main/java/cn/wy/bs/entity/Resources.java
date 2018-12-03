package cn.wy.bs.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author wy
 * @date 2018-09-28
 */
@Table(name="t_resources")
public class Resources {

    /**
     * 资源名称
     */
    @Column(name="RESNAME")
    private String resName;

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    @Override
    public String toString() {
        super.toString();
        return "Resources{" +
                "resName='" + resName + '\'' +
                '}';
    }
}