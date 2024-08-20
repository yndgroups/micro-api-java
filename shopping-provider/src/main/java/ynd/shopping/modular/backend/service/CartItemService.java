package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.CartItemEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.CartItemInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.CartItemUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.CartItemParam;

/**
 * <p>
 * 购物车项 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
public interface CartItemService extends IService<CartItemEntity> {

    /**
     * description  购物车项管理新增
     *
     * @param cartItemInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    BackResult insertCartItem(CartItemInsertDTO cartItemInsertDTO) throws Exception;

    /**
     * description  购物车项管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    BackResult deleteCartItem(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  购物车项管理修改
     *
     * @param cartItemUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    BackResult updateCartItem(CartItemUpdateDTO cartItemUpdateVo) throws Exception;

    /**
     * description 购物车项管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    BackResult queryCartItemPageList(QueryParameter<CartItemParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param id 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-04
     */
    BackResult queryCartItemEntityDetailById(String id) throws Exception;

}
