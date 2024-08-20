package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils;

import lombok.Data;

import java.util.List;

/**
 * description 分页封装
 *
 *@return
 *@param
 *@author yangdaqiong
 *@date 2019/9/25 14:47
 **/
@Data
public class PagingUtil<T>{

    public Integer pageIndex;

    public Integer pageSize;

    public Integer totalCount;

    public List<T> list;
}
