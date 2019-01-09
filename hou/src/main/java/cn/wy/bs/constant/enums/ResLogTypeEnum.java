package cn.wy.bs.constant.enums;

/**
 * @author wy
 * @CreateDate 2019/01/10
 */
public enum ResLogTypeEnum {

    T01("进入公司", "Entry"),
    T02("进入项目组", "EntryProjectTeam"),
    T03("离开项目组", "ExitProjectTeam"),
    T04("离开公司", "Exit"),
    T05("成为团队LEADER", "CreateProjectTeam"),
    T06("团队解散", "DismissProjectTeam")
    ;


    private String name;
    private String index;

    ResLogTypeEnum(String name, String index){
        this.name = name;
        this.index = index;
    }

    public static String getName(String index) {
        for (ResLogTypeEnum c : ResLogTypeEnum.values()) {
            if (c.getIndex().equals( index)) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
