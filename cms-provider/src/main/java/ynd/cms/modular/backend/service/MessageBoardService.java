package ynd.cms.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.cms.modular.backend.entity.MessageBoardEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.cms.modular.backend.pojo.dto.MessageBoardInsertDTO;
import ynd.cms.modular.backend.pojo.dto.MessageBoardUpdateDTO;
import ynd.cms.modular.backend.pojo.param.MessageBoardParam;

/**
 * <p>
 * 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
public interface MessageBoardService extends IService<MessageBoardEntity> {

    /**
     * description  留言板管理新增
     *
     *@param messageBoardInsertDTO 新增参数
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    BackResult insertMessageBoard(MessageBoardInsertDTO messageBoardInsertDTO) throws Exception;

    /**
     * description  留言板管理删除
     *
     *@param deleteDTO 删除参数
     *@return BackResult
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    BackResult deleteMessageBoard(DeleteDTO deleteDTO) throws Exception;

    /**
      * description  留言板管理修改
      *
      *@param messageBoardUpdateDTO
      *@return BackResult 返回修改结果
      *@author yangdaqiong
      *@date 2021-12-11
      **/
    BackResult updateMessageBoard(MessageBoardUpdateDTO messageBoardUpdateDTO) throws Exception;

    /**
     * description 留言板管理列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    BackResult findMessageBoardPageList(QueryParameter<MessageBoardParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param msgId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-11
     */
    BackResult findMessageBoardDetailById(String msgId) throws Exception;
}
