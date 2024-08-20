package ynd.common.service;

import ynd.common.pojo.param.WebsiteStatedParam;
import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.common.entity.WebsiteStatedEntity;
import ynd.common.pojo.vo.WebsiteStatedInsertVo;
import ynd.common.pojo.vo.WebsiteStatedUpdateVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 站点使用协议及声明表 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-06-07
 */
public interface WebsiteStatedService extends IService<WebsiteStatedEntity> {

    /**
     * description  用户协议网站声明新增
     *
     * @param websiteStatedInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-06-07
     **/
    BackResult insertWebsiteStated(WebsiteStatedInsertVo websiteStatedInsertVo) throws Exception;

    /**
     * description  用户协议网站声明删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-06-07
     **/
    BackResult deleteWebsiteStated(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  用户协议网站声明修改
     *
     * @param websiteStatedUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-06-07
     **/
    BackResult updateWebsiteStated(WebsiteStatedUpdateVo websiteStatedUpdateVo) throws Exception;

    /**
     * description 用户协议网站声明列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-06-07
     **/
    BackResult findWebsiteStatedPageList(QueryParameter<WebsiteStatedParam> queryParameter) throws Exception;

    /**
     * description 根据appId获取网站声明详情
     *
     * @param appId 应用id
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-07-17 17:23:21
     **/
    BackResult findWebsiteStatedDetailByAppId(String appId);

    /**
     * description 根据stateId获取网站声明详情
     *
     * @param stateId 声明id
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-07-17 17:23:44
     **/
    BackResult findWebsiteStatedDetailByStateId(String stateId);
}
