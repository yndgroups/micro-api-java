package ynd.order.controller;

import ynd.core.result.BackResult;
import ynd.order.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * description 购物车
 *
 * @author yangdaqiong
 * @date 2021-09-25 16:48:00
 **/
@Api(tags = { "购物车管理" })
@Validated
@RestController
@RequestMapping("/cat")
public class CartController {

    @Autowired
    private CartService cartService;

    @ApiOperation("加入购物车")
    @GetMapping("add/{productId}/{num}")
    public BackResult addCart(@PathVariable String productId, @PathVariable String num) throws Exception {
        return cartService.addCart(productId, num);
    }

    @ApiOperation("删除购物车项")
    @GetMapping("/clearItem/{productId}")
    public BackResult clearCartProductItem(@PathVariable String productId) throws Exception {
        return cartService.clearCartProductItem(productId);
    }

    @ApiOperation("清空购物车")
    @GetMapping("/clear")
    public BackResult clearCartProductAll() throws Exception {
        return cartService.clearCartProductAll();
    }

    @ApiOperation("查询购物车列表")
    @GetMapping("/list")
    public BackResult queryCartList() throws Exception {
        return cartService.queryCartList();
    }

}
