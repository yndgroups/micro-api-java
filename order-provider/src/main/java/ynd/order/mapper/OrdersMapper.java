package ynd.order.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.order.pojo.vo.OrdersListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import ynd.order.pojo.entity.OrdersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 订单 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-25
 */
@Mapper
public interface OrdersMapper extends BaseMapper<OrdersEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-09-25
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 订单分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<OrdersListVo>
    * @author yangdaqiong
    * @date 2021-09-25
    **/
    List<OrdersListVo> queryOrdersPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 订单分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-09-25
    **/
    Integer queryOrdersPageListCount(QueryParameterExtend queryParameterExtend);
}
