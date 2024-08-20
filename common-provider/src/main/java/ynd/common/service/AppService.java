package ynd.common.service;

import ynd.core.dto.DeleteDTO;
import ynd.common.entity.AppEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.AppInsertVo;
import ynd.common.pojo.vo.AppUpdateVo;
import ynd.common.pojo.param.AppParam;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;

/**
 * <p>
 * 应用表 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface AppService extends IService<AppEntity> {
    /**
     * description  应用管理新增
     *
     * @param appInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addApp(AppInsertVo appInsertVo) throws Exception;

    /**
     * description  应用管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deleteApp(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  应用管理修改
     *
     * @param appUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updateApp(AppUpdateVo appUpdateVo) throws Exception;

    /**
     * description 应用管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findPageList(QueryParameter<AppParam> queryParameter) throws Exception;

    /**
     * description 查询应用下的权限
     *
     * @author yangdaqiong
     * @date 2021-09-26 21:11:39
     **/
    BackResult findAppListByUserId() throws Exception;
}
