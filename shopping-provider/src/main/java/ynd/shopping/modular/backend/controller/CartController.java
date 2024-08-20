package ynd.shopping.modular.backend.controller;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.annotation.AdminController;
import ynd.shopping.modular.backend.pojo.param.CartItemParam;
import ynd.shopping.modular.backend.pojo.param.CartParam;
import ynd.shopping.modular.backend.pojo.dto.CartInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.CartItemInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.CartItemUpdateDTO;
import ynd.shopping.modular.backend.pojo.dto.CartUpdateDTO;
import ynd.shopping.modular.backend.service.CartItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.shopping.modular.backend.service.CartService;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Api(tags = {"购物车管理"})
@Validated
@RequestMapping("/cart")
@AdminController("AdminCartController")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertCart(@RequestBody @Valid CartInsertDTO cartInsertDTO) throws Exception {
        return cartService.insertCart(cartInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteCart(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return cartService.deleteCart(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateCart(@RequestBody @Valid CartUpdateDTO cartUpdateVo) throws Exception {
        return cartService.updateCart(cartUpdateVo);
    }

    @ApiOperation("查询列表")
    @PostMapping("/list")
    public BackResult queryCartPageList(@RequestBody @Valid QueryParameter<CartParam> queryParameter) throws Exception {
        return cartService.queryCartPageList(queryParameter);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("/queryCartEntityDetailById/{id}")
    public BackResult queryCartDetailById(@PathVariable(value = "id") String cartId) throws Exception {
        return cartService.queryCartEntityDetailById(cartId);
    }

    @ApiOperation("购物车项管理-新增")
    @PostMapping("/cartItem")
    public BackResult insertCartItem(@RequestBody @Valid CartItemInsertDTO cartItemInsertDTO) throws Exception {
        return cartItemService.insertCartItem(cartItemInsertDTO);
    }

    @ApiOperation("购物车项管理-删除")
    @DeleteMapping("/cartItem")
    public BackResult deleteCartItem(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return cartItemService.deleteCartItem(deleteDTO);
    }

    @ApiOperation("购物车项管理-修改")
    @PutMapping("/cartItem")
    public BackResult updateCartItem(@RequestBody @Valid CartItemUpdateDTO cartItemUpdateVo) throws Exception {
        return cartItemService.updateCartItem(cartItemUpdateVo);
    }

    @ApiOperation("购物车项管理-查询列表")
    @PostMapping("/cartItem/queryCartItemPageList")
    public BackResult queryCartItemPageList(@RequestBody @Valid QueryParameter<CartItemParam> queryParameter) throws Exception {
        return cartItemService.queryCartItemPageList(queryParameter);
    }

    @ApiOperation("购物车项管理-根据id查询详情")
    @GetMapping("/cartItem/queryCartItemDetailById/{id}")
    public BackResult queryCartItemDetailById(@PathVariable String id) throws Exception {
        return cartItemService.queryCartItemEntityDetailById(id);
    }

}
