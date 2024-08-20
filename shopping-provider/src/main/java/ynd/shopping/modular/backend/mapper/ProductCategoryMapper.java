package ynd.shopping.modular.backend.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameterExtend;
import ynd.shopping.modular.backend.entity.ProductCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ynd.shopping.modular.backend.pojo.vo.ProductCategoryListVo;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品分类 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-22
 */
@Repository("AdminProductCategoryMapper")
public interface ProductCategoryMapper extends BaseMapper<ProductCategoryEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 商品分类分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<ProductCategoryListVo>
    * @author yangdaqiong
    * @date 2021-09-22
    **/
    List<ProductCategoryListVo> queryProductCategoryPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 商品分类分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-09-22
    **/
    Integer queryProductCategoryPageListCount(QueryParameterExtend queryParameterExtend);

    /**
     * description 根据父id查询下级分类列表
     *
     * @return parentId 父级if
     * @return List<ProductCategoryListVo> 下级列表
     * @author yangdaqiong
     * @date 2021-11-07 09:06:12
     **/
    List<ProductCategoryListVo> queryProductCategoryListByParentId(String parentId);
}
