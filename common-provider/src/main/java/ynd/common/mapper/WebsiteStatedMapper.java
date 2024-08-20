package ynd.common.mapper;

import java.util.List;

import ynd.common.pojo.vo.WebsiteStatedListVo;
import ynd.common.entity.WebsiteStatedEntity;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import ynd.core.dto.DeleteDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 站点使用协议及声明表 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-06-07
 */
@Mapper
public interface WebsiteStatedMapper extends BaseMapper<WebsiteStatedEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-06-07
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 站点使用协议及声明表分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-06-07
    **/
    List<WebsiteStatedListVo> findWebsiteStatedPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 站点使用协议及声明表分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-06-07
    **/
    Integer findWebsiteStatedPageListCount(QueryParameterExtend queryParameterExtend);
}
