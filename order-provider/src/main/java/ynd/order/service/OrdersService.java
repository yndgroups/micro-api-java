package ynd.order.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.order.pojo.entity.OrdersEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.order.pojo.dto.OrdersInsertDTO;
import ynd.order.pojo.dto.OrdersUpdateDTO;
import ynd.order.pojo.param.OrdersParam;

/**
 * <p>
 * 订单 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-25
 */
public interface OrdersService extends IService<OrdersEntity> {
    /**
      * description  订单管理新增
      *
      *@param ordersInsertDTO 新增参数
      *@return BackVO
      *@author yangdaqiong
      *@date 2021-09-25
      **/
    BackResult insertOrders(OrdersInsertDTO ordersInsertDTO) throws Exception;

    /**
      * description  订单管理删除
      *
      *@param deleteDTO 删除参数
      *@return BackResult
      *@author yangdaqiong
      *@date 2021-09-25
      **/
    BackResult deleteOrders(DeleteDTO deleteDTO) throws Exception;

    /**
      * description  订单管理修改
      *
      *@param ordersUpdateDTO
      *@return BackResult 返回修改结果
      *@author yangdaqiong
      *@date 2021-09-25
      **/
    BackResult updateOrders(OrdersUpdateDTO ordersUpdateDTO) throws Exception;

    /**
    * description 订单管理列表查询
    *
    *@param queryParameter
    *@return BackResult 返回查询结果
    *@author yangdaqiong
    *@date 2021-09-25
    **/
    BackResult queryOrdersPageList(QueryParameter<OrdersParam> queryParameter) throws Exception;

    /**
    * description 根据主键id详情查询
    *
    * @param orderId 主键id
    * @return BackResult 返回查询结果
    * @author yangdaqiong
    * @date 2021-09-25
    */
    BackResult queryOrdersEntityDetailById(String orderId) throws Exception;
}
