package ynd.core.result;

import lombok.Data;

import java.util.List;

/**
 *@description 分页器
 *
 *@author yangdaqiong
 *@date 2021-05-12 22:55:21
 **/
@Data
public class Pager<T>{

    public Integer pageIndex;

    public Integer pageSize;

    public Integer totalCount;

    public List<T> list;

    public Pager() {}

    public Pager(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Pager(Integer pageIndex, Integer pageSize, Integer totalCount) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public Pager(Integer pageIndex, Integer pageSize, Integer totalCount, List<T> list) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = list;
    }

}
