package ynd.shopping.modular.backend.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameterExtend;
import ynd.shopping.modular.backend.entity.ProductSpecEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ynd.shopping.modular.backend.pojo.vo.ProductSpecListVo;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 属性 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-08
 */
@Repository("FrontendProductSpecMapper")
public interface ProductSpecMapper extends BaseMapper<ProductSpecEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
     * description 规格分页列表查询
     *
     * @param queryParameterExtend 查询条件
     * @return List<ProductSpecListVo>
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    List<ProductSpecListVo> queryProductSpecPageList(QueryParameterExtend queryParameterExtend);

    /**
     * description 规格分页列表总数查询
     *
     * @param queryParameterExtend 查询条件
     * @return Integer
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    Integer queryProductSpecPageListCount(QueryParameterExtend queryParameterExtend);

    /**
     * description
     *
     * @param  productCategoryId 商品分
     * @return List<ProductSpecListVo>
     * @author yangdaqiong
     * @date 2021-11-08 23:46:33
     **/
    List<ProductSpecListVo> listProductSpecByProductCategoryId(String productCategoryId);
}
