package ynd.shopping.modular.backend.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.entity.InventoryRecordEntity;
import ynd.shopping.modular.backend.pojo.vo.InventoryRecordListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 库存记录 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-04
 */
@Mapper
public interface InventoryRecordMapper extends BaseMapper<InventoryRecordEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 库存记录分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<InventoryRecordListVo>
    * @author yangdaqiong
    * @date 2021-10-04
    **/
    List<InventoryRecordListVo> queryInventoryRecordPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 库存记录分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-10-04
    **/
    Integer queryInventoryRecordPageListCount(QueryParameterExtend queryParameterExtend);
}
