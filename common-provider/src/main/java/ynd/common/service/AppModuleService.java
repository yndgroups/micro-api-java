package ynd.common.service;

import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;
import ynd.core.result.BackResult;
import ynd.common.entity.AppModuleEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.AppModuleInsertVo;
import ynd.common.pojo.vo.AppModuleUpdateVo;
import ynd.common.pojo.param.AppModuleParam;

/**
 * <p>
 * 应用模块 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-30
 */
public interface AppModuleService extends IService<AppModuleEntity> {
    /**
     * description  应用模块管理新增
     *
     * @param appModuleInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    BackResult insertAppModule(AppModuleInsertVo appModuleInsertVo) throws Exception;

    /**
     * description  应用模块管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    BackResult deleteAppModule(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  应用模块管理修改
     *
     * @param appModuleUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    BackResult updateAppModule(AppModuleUpdateVo appModuleUpdateVo) throws Exception;

    /**
     * description 应用模块管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    BackResult findAppModulePageList(QueryParameter<AppModuleParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param mdId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-30
     */
    BackResult findAppModuleDetailById(String mdId) throws Exception;

    /**
     * description 根据主键appId详情模块列表
     *
     * @param appId appId
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-30
     */
    BackResult findAppModuleListByAppId(String appId);
}
