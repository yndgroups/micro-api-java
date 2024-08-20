package ynd.order.service.impl;

import ynd.core.exception.CustomException;
import ynd.core.result.BackResult;
import ynd.core.service.RedisService;
import ynd.core.service.RedisUserService;
import ynd.order.pojo.vo.ProductDetailVo;
import ynd.order.service.CartService;
import ynd.order.service.feign.SkuFeign;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl extends RedisUserService implements CartService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private SkuFeign skuFeign;

    /**
     * description 添加购物车
     *
     * @param productId 商品id
     * @param num 商品数量
     * @return 返回添加结果
     * @author yangdaqiong
     * @date 2021-09-25 16:58:30
     **/
    @Override
    public BackResult addCart(String productId, String num) throws Exception {
        // 查询商品详情

        // 1) 查询sku
         BackResult<ProductDetailVo> skuEntityBackResult = skuFeign.querySkuByProductId(productId);
         if (skuEntityBackResult.getCode() != 200) {
             throw new CustomException(0, skuEntityBackResult.getMsg());
         }
        ProductDetailVo data = skuEntityBackResult.getData();

        // 2) 查询spu

        // 将加入购物车的商品信息封装成orderItem

        // 将购物车数据存入Redis
        redisService.setHashOps("cart_" + this.getAuthUser().getUserId(), productId , JSON.toJSONString(data));

        // 返回添加结果
        return BackResult.success(data);
    }

    /**
     * description 查询购物车列表
     *
     * @return 购物车列表
     * @author yangdaqiong
     * @date 2021-09-25 16:59:25
     **/
    @Override
    public BackResult queryCartList() throws Exception {
        List<Object> list = redisService.getHashOps("cart_" + this.getAuthUser().getUserId());
        List<JSONObject> res = new ArrayList<>();
        for (Object o : list) {
            res.add(JSONObject.parseObject(o.toString()));
        }
        return BackResult.success(res);
    }

    /**
     * description 删除购物车
     *
     * @return productId 商品id
     * @author yangdaqiong
     * @date 2021-11-06 09:57:36
     **/
    @Override
    public BackResult clearCartProductItem(String productId) throws Exception {
        redisService.deleteHashOps("cart" + this.getAuthUser().getUserId(), productId);
        return BackResult.success("删除购物车商品成功！");
    }

    @Override
    public BackResult clearCartProductAll() {
        return null;
    }
}
