package ynd.cms.modular.backend.mapper;

import java.util.List;

import ynd.cms.modular.backend.entity.CommentEntity;
import ynd.cms.modular.backend.pojo.vo.CommentListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import ynd.core.dto.DeleteDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 评论 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 评论分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<CommentListVo>
    * @author yangdaqiong
    * @date 2021-12-10
    **/
    List<CommentListVo> findCommentPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 评论分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-12-10
    **/
    Integer findCommentPageListCount(QueryParameterExtend queryParameterExtend);
}
