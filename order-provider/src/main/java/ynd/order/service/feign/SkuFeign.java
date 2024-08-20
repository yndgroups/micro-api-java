package ynd.order.service.feign;

import ynd.core.result.BackResult;
import ynd.order.pojo.vo.ProductDetailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description 查询库存
 *
 * @author yangdaqiong
 * @date 2021-09-25 17:13:41
 **/
@FeignClient(value = "agile-shopping-provider")
@RequestMapping("/api/shopping")
public interface SkuFeign {

    /**
     * description 查询商品sku
     *
     * @param productId
     * @return
     * @author yangdaqiong
     * @date 2021-11-06 00:59:41
     */
    @GetMapping("/admin/product/{productId}")
    BackResult<ProductDetailVo> querySkuByProductId(@PathVariable String productId);

}
