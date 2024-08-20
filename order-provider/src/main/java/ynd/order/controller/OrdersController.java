package ynd.order.controller;

import ynd.order.pojo.dto.OrdersInsertDTO;
import ynd.order.pojo.dto.OrdersUpdateDTO;
import ynd.order.pojo.param.OrdersParam;
import ynd.order.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-25
 */
@Api(tags = {"订单管理"})
@Validated
@RequestMapping("/order")
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @ApiOperation("订单管理-新增")
    @PostMapping
    public BackResult insertOrders(@RequestBody @Valid OrdersInsertDTO ordersInsertDTO) throws Exception {
        return ordersService.insertOrders(ordersInsertDTO);
    }

    @ApiOperation("订单管理-删除")
    @DeleteMapping
    public BackResult deleteOrders(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return ordersService.deleteOrders(deleteDTO);
    }

    @ApiOperation("订单管理-修改")
    @PutMapping
    public BackResult updateOrders(@RequestBody @Valid OrdersUpdateDTO ordersUpdateDTO) throws Exception {
        return ordersService.updateOrders(ordersUpdateDTO);
    }

    @ApiOperation("订单管理-查询列表")
    @PostMapping("/queryOrdersPageList")
    public BackResult queryOrdersPageList(@RequestBody @Valid QueryParameter<OrdersParam> queryParameter) throws Exception {
        return ordersService.queryOrdersPageList(queryParameter);
    }

    @ApiOperation("订单管理-根据orderId查询详情")
    @GetMapping("/queryOrdersEntityDetailById/{orderId}")
    public BackResult queryOrdersDetailById(@PathVariable String orderId) throws Exception {
        return ordersService.queryOrdersEntityDetailById(orderId);
    }

}
