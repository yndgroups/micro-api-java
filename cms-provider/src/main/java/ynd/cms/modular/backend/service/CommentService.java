package ynd.cms.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.cms.modular.backend.entity.CommentEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.cms.modular.backend.pojo.dto.CommentInsertDTO;
import ynd.cms.modular.backend.pojo.dto.CommentUpdateDTO;
import ynd.cms.modular.backend.pojo.param.CommentParam;

/**
 * <p>
 * 评论服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
public interface CommentService extends IService<CommentEntity> {

    /**
     * description  评论管理新增
     *
     *@param commentInsertDTO 新增参数
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    BackResult insertComment(CommentInsertDTO commentInsertDTO) throws Exception;

    /**
     * description  评论管理删除
     *
     *@param deleteDTO 删除参数
     *@return BackResult
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    BackResult deleteComment(DeleteDTO deleteDTO) throws Exception;

    /**
      * description  评论管理修改
      *
      *@param commentUpdateDTO
      *@return BackResult 返回修改结果
      *@author yangdaqiong
      *@date 2021-12-10
      **/
    BackResult updateComment(CommentUpdateDTO commentUpdateDTO) throws Exception;

    /**
     * description 评论管理列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    BackResult findCommentPageList(QueryParameter<CommentParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param commentId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-10
     */
    BackResult findCommentDetailById(String commentId) throws Exception;
}
