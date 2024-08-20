package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.ProductSkuEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.ProductSkuInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductSkuUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductSkuParam;

/**
 * <p>
 * sku 库存表服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
public interface ProductSkuService extends IService<ProductSkuEntity> {

    /**
     * description  商品SKU新增
     *
     * @param productSkuInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    BackResult insertProductSku(ProductSkuInsertDTO productSkuInsertDTO) throws Exception;

    /**
     * description  商品SKU删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    BackResult deleteProductSku(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  商品SKU修改
     *
     * @param productSkuUpdateDTO
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    BackResult updateProductSku(ProductSkuUpdateDTO productSkuUpdateDTO) throws Exception;

    /**
     * description 商品SKU列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    BackResult queryProductSkuPageList(QueryParameter<ProductSkuParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param skuId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-12
     */
    BackResult queryProductSkuDetailById(String skuId) throws Exception;

}
