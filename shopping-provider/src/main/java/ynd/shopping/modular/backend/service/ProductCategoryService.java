package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.ProductCategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.ProductCategoryInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductCategoryUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductCategoryParam;

/**
 * <p>
 * 商品分类 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-22
 */
public interface ProductCategoryService extends IService<ProductCategoryEntity> {
    /**
     * description  商品分类新增
     *
     * @param productCategoryInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    BackResult insertProductCategory(ProductCategoryInsertDTO productCategoryInsertDTO) throws Exception;

    /**
     * description  商品分类删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    BackResult deleteProductCategory(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  商品分类修改
     *
     * @param productCategoryUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    BackResult updateProductCategory(ProductCategoryUpdateDTO productCategoryUpdateVo) throws Exception;

    /**
     * description 商品分类列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    BackResult queryProductCategoryPageList(QueryParameter<ProductCategoryParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param productCategoryId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-22
     */
    BackResult queryProductCategoryDetailById(String productCategoryId) throws Exception;

    /**
     * description 根据父id查询产品分类
     *
     * @param parentId 分类父id
     * @author yangdaqiong
     * @date 2021-10-04 22:59:02
     **/
    BackResult queryProductCategoryListByParentId(String parentId);

}
