package ynd.cms.modular.backend.service.impl;

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
import ynd.cms.modular.backend.entity.MessageBoardEntity;
import ynd.cms.modular.backend.mapper.MessageBoardMapper;
import ynd.cms.modular.backend.service.MessageBoardService;
import ynd.cms.modular.backend.pojo.dto.MessageBoardInsertDTO;
import ynd.cms.modular.backend.pojo.dto.MessageBoardUpdateDTO;
import ynd.cms.modular.backend.pojo.param.MessageBoardParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Service
public class MessageBoardServiceImpl extends ServiceImpl<MessageBoardMapper, MessageBoardEntity> implements MessageBoardService {

    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  留言板管理新增
     *
     *@param messageBoardInsertDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    @Override
    public BackResult insertMessageBoard(MessageBoardInsertDTO messageBoardInsertDTO) throws Exception {
        MessageBoardEntity messageBoardEntity = new MessageBoardEntity();
        BeanUtils.copyProperties(messageBoardInsertDTO, messageBoardEntity);
        messageBoardEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        messageBoardEntity.setMsgId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(messageBoardEntity));
    }

    /**
     * description  留言板管理删除
     *
     *@param deleteDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    @Override
    public BackResult deleteMessageBoard(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  留言板管理修改
     *
     *@param messageBoardUpdateDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    @Override
    public BackResult updateMessageBoard(MessageBoardUpdateDTO messageBoardUpdateDTO) throws Exception {
       MessageBoardEntity messageBoardEntity = new MessageBoardEntity();
       BeanUtils.copyProperties(messageBoardUpdateDTO, messageBoardEntity);
       messageBoardEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
       return BackResult.update(this.updateById(messageBoardEntity));
    }

    /**
     * description 留言板管理列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    @Override
    public BackResult findMessageBoardPageList(QueryParameter<MessageBoardParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findMessageBoardPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(),queryParameter.getPageSize(), totalCount,this.baseMapper.findMessageBoardPageList(queryParameterExtend)));
        } else {
        throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据msgId查询详情
     *
     *@param msgId 主键id
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    @Override
    public BackResult findMessageBoardDetailById(String msgId) throws Exception {
        LambdaQueryWrapper<MessageBoardEntity> eq = new QueryWrapper<MessageBoardEntity>().lambda().eq(MessageBoardEntity::getMsgId, msgId);
        MessageBoardEntity messageBoardEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(messageBoardEntity);
    }
}
