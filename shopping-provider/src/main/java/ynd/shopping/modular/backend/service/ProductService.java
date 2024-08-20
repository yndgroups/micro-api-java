package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.ProductEntity;
import ynd.shopping.modular.backend.pojo.dto.GoodsDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.ProductUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductParam;

/**
 * <p>
 * 商品服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
public interface ProductService extends IService<ProductEntity> {

    /**
     * description  商品管理新增
     *
     *@param goodsDTO 新增参数
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-11-12
     **/
    BackResult insertProduct(GoodsDTO goodsDTO) throws Exception;

    /**
     * description  商品管理删除
     *
     *@param deleteDTO 删除参数
     *@return BackResult
     *@author yangdaqiong
     *@date 2021-11-12
     **/
    BackResult deleteProduct(DeleteDTO deleteDTO) throws Exception;

    /**
      * description  商品管理修改
      *
      *@param productUpdateDTO
      *@return BackResult 返回修改结果
      *@author yangdaqiong
      *@date 2021-11-12
      **/
    BackResult updateProduct(ProductUpdateDTO productUpdateDTO) throws Exception;

    /**
     * description 商品管理列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-11-12
     **/
    BackResult findProductPageList(QueryParameter<ProductParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param productId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-12
     */
    BackResult findProductDetailById(String productId) throws Exception;

}
