package ynd.cms.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.cms.modular.backend.entity.WebsiteStatedEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.cms.modular.backend.pojo.dto.WebsiteStatedInsertDTO;
import ynd.cms.modular.backend.pojo.dto.WebsiteStatedUpdateDTO;
import ynd.cms.modular.backend.pojo.param.WebsiteStatedParam;

/**
 * <p>
 * 站点使用协议及声明表服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-15
 */
public interface WebsiteStatedService extends IService<WebsiteStatedEntity> {

    /**
     * description  站长声明管理新增
     *
     *@param websiteStatedInsertDTO 新增参数
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-15
     **/
    BackResult insertWebsiteStated(WebsiteStatedInsertDTO websiteStatedInsertDTO) throws Exception;

    /**
     * description  站长声明管理删除
     *
     *@param deleteDTO 删除参数
     *@return BackResult
     *@author yangdaqiong
     *@date 2021-12-15
     **/
    BackResult deleteWebsiteStated(DeleteDTO deleteDTO) throws Exception;

    /**
      * description  站长声明管理修改
      *
      *@param websiteStatedUpdateDTO
      *@return BackResult 返回修改结果
      *@author yangdaqiong
      *@date 2021-12-15
      **/
    BackResult updateWebsiteStated(WebsiteStatedUpdateDTO websiteStatedUpdateDTO) throws Exception;

    /**
     * description 站长声明管理列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-15
     **/
    BackResult findWebsiteStatedPageList(QueryParameter<WebsiteStatedParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param stateId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-15
     */
    BackResult findWebsiteStatedDetailById(String stateId) throws Exception;
}
