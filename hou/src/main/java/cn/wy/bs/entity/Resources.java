package cn.wy.bs.entity;

/**
 * 
 * 
 * @author wy
 * 
 * @date 2018-09-28
 */
public class Resources {

    /**
     * 资源名称
     */
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