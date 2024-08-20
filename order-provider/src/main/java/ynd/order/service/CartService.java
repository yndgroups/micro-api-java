package ynd.order.service;

import ynd.core.result.BackResult;

public interface CartService {

    /**
     * description 添加购物车
     *
     * @param productId 商品id
     * @param productId 商品数量
     * @return BackResult 返回添加结果
     * @author yangdaqiong
     * @date 2021-09-25 16:56:36
     **/
    BackResult addCart(String productId, String num) throws Exception;


    /**
     * description 查询购物车列表
     *
     * @author yangdaqiong
     * @date 2021-09-25 16:57:27
     **/
    BackResult queryCartList() throws Exception;


    BackResult clearCartProductItem(String productId) throws Exception;

    /**
     * description 清空购物车
     *
     * @return key
     * @return result
     * @author yangdaqiong
     * @date 2021-11-06 23:07:44
     **/
    BackResult clearCartProductAll();
}
