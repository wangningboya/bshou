package cn.wy.bs.constant.enums;

public enum DemandStateEnum {
	T01("提出需求", 0),
	T02("审核通过", 1),
	T03("审核未通过", 2),
	T04("项目经理预估时间", 3),
	T05("开发开始", 4),
	T06("开发暂停", 5),
	T07("开发结束", 6),
	T08("开发关闭",7),
	T09("验收通过",8),
	T10("验收未通过",9);
	//状态（0提出需求/1审核通过/2审核未通过/3预估时间/4开发开始/5开发暂停/6开发结束/7开发关闭/8验收通过/9验收未通过）

	private String name;
	private Integer index;

	DemandStateEnum(String name, Integer index){
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public Integer getIndex() {
		return index;
	}

	public static String getName(int index) {
		for (DemandStateEnum c : DemandStateEnum.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}

	public static int getIndex(String name) {
		for (DemandStateEnum c : DemandStateEnum.values()) {
			if (c.getName() == name) {
				return c.index;
			}
		}
		return -1;
	}


}
