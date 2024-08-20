package ynd.shopping.modular.backend.mapper;

import java.util.List;

import ynd.shopping.modular.backend.entity.StoreCategoryEntity;
import ynd.shopping.modular.backend.pojo.vo.StoreCategoryListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import ynd.core.dto.DeleteDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 店铺分类 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
@Mapper
public interface StoreCategoryMapper extends BaseMapper<StoreCategoryEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-08-08
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 店铺分类分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-08-08
    **/
    List<StoreCategoryListVo> queryStoreCategoryPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 店铺分类分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-08-08
    **/
    Integer queryStoreCategoryPageListCount(QueryParameterExtend queryParameterExtend);
}
