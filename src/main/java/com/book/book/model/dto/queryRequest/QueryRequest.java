package com.book.book.model.dto.queryRequest;

import lombok.Data;

@Data
public class QueryRequest {
    private Integer pageNum = 1; // 当前页
    private Integer pageSize = 10; // 一页显示10条
    private String classNo;
    private String name;

    // 如果需要，可以手动添加 getter 和 setter 方法
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
