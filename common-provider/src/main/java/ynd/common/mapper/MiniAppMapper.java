package ynd.common.mapper;

import java.util.List;

import ynd.common.entity.MiniAppEntity;
import ynd.common.pojo.vo.MiniAppListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ynd.core.dto.DeleteDTO;

/**
 * <p>
 * 微应用 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Mapper
public interface MiniAppMapper extends BaseMapper<MiniAppEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 微应用分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    List<MiniAppListVo> findMiniAppPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 微应用分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    Integer findMiniAppPageListCount(QueryParameterExtend queryParameterExtend);
}
