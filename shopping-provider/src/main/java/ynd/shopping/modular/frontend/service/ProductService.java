package ynd.shopping.modular.frontend.service;

import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.frontend.entity.ProductEntity;
import ynd.shopping.modular.frontend.pojo.param.ProductParam;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
public interface ProductService extends IService<ProductEntity> {

    /**
     * description 商品SKU列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    BackResult findProductPageList(QueryParameter<ProductParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param productId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-11
     */
    BackResult findProductDetailById(String productId) throws Exception;

    /**
     * description 商品分类列表
     *
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-11
     */
    BackResult findProductCategory();
}
