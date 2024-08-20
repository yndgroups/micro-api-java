package ynd.shopping.modular.backend.mapper;

import java.util.List;

import ynd.shopping.modular.backend.entity.StoreRankEntity;
import ynd.shopping.modular.backend.pojo.vo.StoreRankListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import ynd.core.dto.DeleteDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 店铺等级 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-15
 */
@Mapper
public interface StoreRankMapper extends BaseMapper<StoreRankEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-08-15
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 店铺等级分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<StoreRankListVo>
    * @author yangdaqiong
    * @date 2021-08-15
    **/
    List<StoreRankListVo> queryStoreRankPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 店铺等级分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-08-15
    **/
    Integer queryStoreRankPageListCount(QueryParameterExtend queryParameterExtend);
}
