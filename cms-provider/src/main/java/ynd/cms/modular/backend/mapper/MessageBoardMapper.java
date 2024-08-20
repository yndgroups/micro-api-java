package ynd.cms.modular.backend.mapper;

import java.util.List;

import ynd.cms.modular.backend.entity.MessageBoardEntity;
import ynd.cms.modular.backend.pojo.vo.MessageBoardListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import ynd.core.dto.DeleteDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Mapper
public interface MessageBoardMapper extends BaseMapper<MessageBoardEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-12-11
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<MessageBoardListVo>
    * @author yangdaqiong
    * @date 2021-12-11
    **/
    List<MessageBoardListVo> findMessageBoardPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-12-11
    **/
    Integer findMessageBoardPageListCount(QueryParameterExtend queryParameterExtend);
}
