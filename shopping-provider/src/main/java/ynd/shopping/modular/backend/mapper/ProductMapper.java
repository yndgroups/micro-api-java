package ynd.shopping.modular.backend.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameterExtend;
import ynd.shopping.modular.backend.entity.ProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ynd.shopping.modular.backend.pojo.vo.ProductListVo;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Repository("AdminProductSpecMapper")
public interface ProductMapper extends BaseMapper<ProductEntity> {

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
    * description 商品分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<ProductListVo>
    * @author yangdaqiong
    * @date 2021-11-12
    **/
    List<ProductListVo> findProductPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 商品分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-11-12
    **/
    Integer findProductPageListCount(QueryParameterExtend queryParameterExtend);
}
