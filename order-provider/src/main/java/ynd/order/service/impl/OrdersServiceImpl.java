package ynd.order.service.impl;

import ynd.core.dto.DeleteDTO;
import ynd.order.mapper.OrdersMapper;
import ynd.order.pojo.dto.OrdersInsertDTO;
import ynd.order.pojo.dto.OrdersUpdateDTO;
import ynd.order.pojo.entity.OrdersEntity;
import ynd.order.pojo.param.OrdersParam;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.order.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-25
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, OrdersEntity> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
      * description  订单管理新增
      *
      *@param ordersInsertDTO
      *@return BackVO
      *@author yangdaqiong
      *@date 2021-09-25
      **/
    @Override
    public BackResult insertOrders(OrdersInsertDTO ordersInsertDTO) throws Exception {
        OrdersEntity ordersEntity = new OrdersEntity();
        BeanUtils.copyProperties(ordersInsertDTO, ordersEntity);
        ordersEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        ordersEntity.setOrderId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(ordersEntity));
    }

    /**
      * description  订单管理删除
      *
      *@param deleteDTO
      *@return BackVO
      *@author yangdaqiong
      *@date 2021-09-25
      **/
    @Override
    public BackResult deleteOrders(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
      * description  订单管理修改
      *
      *@param ordersUpdateDTO
      *@return BackVO
      *@author yangdaqiong
      *@date 2021-09-25
      **/
    @Override
    public BackResult updateOrders(OrdersUpdateDTO ordersUpdateDTO) throws Exception {
       OrdersEntity ordersEntity = new OrdersEntity();
       BeanUtils.copyProperties(ordersUpdateDTO, ordersEntity);
       ordersEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
       return BackResult.update(this.updateById(ordersEntity));
    }

    /**
    * description 订单管理列表查询
    *
    *@param queryParameter
    *@return BackResult 返回查询结果
    *@author yangdaqiong
    *@date 2021-09-25
    **/
    @Override
    public BackResult queryOrdersPageList(QueryParameter<OrdersParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryOrdersPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(),queryParameter.getPageSize(), totalCount,this.baseMapper.queryOrdersPageList(queryParameterExtend)));
        } else {
        throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

        /**
        * description 根据orderId查询详情
        *
        *@param orderId 主键id
        *@return BackResult 返回查询结果
        *@author yangdaqiong
        *@date 2021-09-25
        **/
        @Override
        public BackResult queryOrdersEntityDetailById(String orderId) throws Exception {
            LambdaQueryWrapper<OrdersEntity> eq = new QueryWrapper<OrdersEntity>().lambda().eq(OrdersEntity::getOrderId, orderId);
            OrdersEntity ordersEntity = this.baseMapper.selectOne(eq);
            return BackResult.success(ordersEntity);
        }
}
