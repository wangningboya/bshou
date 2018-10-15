package cn.wy.bs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Page<T> {

    // 当前页码
    private int pageNo;

    // 每页行数
    private int pageSize;

    // 总记录数
    private int totalRecord;

    // 总页数
    private int totalPage;

    // 查询条件
    private Map<String, Object> params;

    // 数据
    private List<T> list=new ArrayList<T>();


    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        double a = ((double) totalRecord/pageSize);
        return (int) Math.ceil(a);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
