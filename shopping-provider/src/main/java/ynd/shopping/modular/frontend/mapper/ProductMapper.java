package ynd.shopping.modular.frontend.mapper;

import java.util.List;

import ynd.shopping.modular.frontend.pojo.vo.ProductCategoryListVo;
import ynd.core.query.QueryParameterExtend;
import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.frontend.entity.ProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ynd.shopping.modular.frontend.pojo.vo.ProductListVo;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Repository("FrontendProductMapper")
public interface ProductMapper extends BaseMapper<ProductEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-12-11
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 商品分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<ProductListVo>
    * @author yangdaqiong
    * @date 2021-12-11
    **/
    List<ProductListVo> findProductPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 商品分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-12-11
    **/
    Integer findProductPageListCount(QueryParameterExtend queryParameterExtend);

    /**
     * description 查询商品分类
     *
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-11 16:59:31
     */
    List<ProductCategoryListVo> findProductCategory();
}
