package ynd.cms.modular.backend.service.impl;

import ynd.cms.modular.backend.entity.CommentEntity;
import ynd.cms.modular.backend.mapper.CommentMapper;
import ynd.cms.modular.backend.pojo.dto.CommentInsertDTO;
import ynd.cms.modular.backend.pojo.dto.CommentUpdateDTO;
import ynd.cms.modular.backend.pojo.param.CommentParam;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.core.dto.DeleteDTO;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.cms.modular.backend.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 评论服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentEntity> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  评论管理新增
     *
     *@param commentInsertDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult insertComment(CommentInsertDTO commentInsertDTO) throws Exception {
        CommentEntity commentEntity = new CommentEntity();
        BeanUtils.copyProperties(commentInsertDTO, commentEntity);
        commentEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        commentEntity.setCommentId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(commentEntity));
    }

    /**
     * description  评论管理删除
     *
     *@param deleteDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult deleteComment(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  评论管理修改
     *
     *@param commentUpdateDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult updateComment(CommentUpdateDTO commentUpdateDTO) throws Exception {
       CommentEntity commentEntity = new CommentEntity();
       BeanUtils.copyProperties(commentUpdateDTO, commentEntity);
       commentEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
       return BackResult.update(this.updateById(commentEntity));
    }

    /**
     * description 评论管理列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult findCommentPageList(QueryParameter<CommentParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findCommentPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(),queryParameter.getPageSize(), totalCount,this.baseMapper.findCommentPageList(queryParameterExtend)));
        } else {
        throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据commentId查询详情
     *
     *@param commentId 主键id
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult findCommentDetailById(String commentId) throws Exception {
        LambdaQueryWrapper<CommentEntity> eq = new QueryWrapper<CommentEntity>().lambda().eq(CommentEntity::getCommentId, commentId);
        CommentEntity commentEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(commentEntity);
    }
}
