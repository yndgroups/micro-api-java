package ynd.shopping.modular.backend.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.entity.StoreEntity;
import ynd.shopping.modular.backend.pojo.vo.StoreListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 店铺 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-07
 */
@Mapper
public interface StoreMapper extends BaseMapper<StoreEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-08-07
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 店铺分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-08-07
    **/
    List<StoreListVo> queryStorePageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 店铺分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-08-07
    **/
    Integer queryStorePageListCount(QueryParameterExtend queryParameterExtend);
}
