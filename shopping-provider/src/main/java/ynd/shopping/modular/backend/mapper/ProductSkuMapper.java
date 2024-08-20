package ynd.shopping.modular.backend.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.entity.ProductSkuEntity;
import ynd.shopping.modular.backend.pojo.vo.ProductSkuListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * sku 库存表 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Mapper
public interface ProductSkuMapper extends BaseMapper<ProductSkuEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description sku 库存表分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<ProductSkuListVo>
    * @author yangdaqiong
    * @date 2021-11-12
    **/
    List<ProductSkuListVo> queryProductSkuPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description sku 库存表分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-11-12
    **/
    Integer queryProductSkuPageListCount(QueryParameterExtend queryParameterExtend);
}
