package ynd.shopping.modular.backend.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.entity.CartItemEntity;
import ynd.shopping.modular.backend.pojo.vo.CartItemListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 购物车项 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Mapper
public interface CartItemMapper extends BaseMapper<CartItemEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
     * description 购物车项分页列表查询
     *
     * @param queryParameterExtend 查询条件
     * @return List<CartItemListVo>
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    List<CartItemListVo> queryCartItemPageList(QueryParameterExtend queryParameterExtend);

    /**
     * description 购物车项分页列表总数查询
     *
     * @param queryParameterExtend 查询条件
     * @return Integer
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    Integer queryCartItemPageListCount(QueryParameterExtend queryParameterExtend);
}
