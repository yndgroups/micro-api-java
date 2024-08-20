package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.CartEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.CartInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.CartUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.CartParam;

/**
 * <p>
 * 购物车 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
public interface CartService extends IService<CartEntity> {

    /**
     * description  购物车管理新增
     *
     * @param cartInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    BackResult insertCart(CartInsertDTO cartInsertDTO) throws Exception;

    /**
     * description  购物车管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    BackResult deleteCart(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  购物车管理修改
     *
     * @param cartUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    BackResult updateCart(CartUpdateDTO cartUpdateVo) throws Exception;

    /**
     * description 购物车管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    BackResult queryCartPageList(QueryParameter<CartParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param cartId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-04
     */
    BackResult queryCartEntityDetailById(String cartId) throws Exception;

}
