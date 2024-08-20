package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.ProductSpecEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.ProductSpecInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductSpecUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductSpecParam;

/**
 * <p>
 * 属性 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-08
 */
public interface ProductSpecService extends IService<ProductSpecEntity> {
    /**
     * description  商品规格管理新增
     *
     * @param productSpecInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    BackResult insertProductSpec(ProductSpecInsertDTO productSpecInsertDTO) throws Exception;

    /**
     * description  商品规格管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    BackResult deleteProductSpec(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  商品规格管理修改
     *
     * @param productSpecUpdateDTO
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    BackResult updateProductSpec(ProductSpecUpdateDTO productSpecUpdateDTO) throws Exception;

    /**
     * description 商品规格管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    BackResult queryProductSpecPageList(QueryParameter<ProductSpecParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param specId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-08
     */
    BackResult queryProductSpecDetailById(String specId) throws Exception;

    /**
     * description 根据分类id查询商品规格
     *
     * @param productCategoryId
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-11-08 23:35:44
     **/
    BackResult listProductSpecByProductCategoryId(String productCategoryId);

}
