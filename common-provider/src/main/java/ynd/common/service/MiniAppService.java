package ynd.common.service;

import ynd.common.entity.MiniAppEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.MiniAppInsertVo;
import ynd.common.pojo.vo.MiniAppUpdateVo;
import ynd.common.pojo.param.MiniAppParam;
import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;

/**
 * <p>
 * 微应用 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface MiniAppService extends IService<MiniAppEntity> {

    /**
     * description  小程序管理新增
     *
     * @param miniAppInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addMiniApp(MiniAppInsertVo miniAppInsertVo) throws Exception;

    /**
     * description  小程序管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deleteMiniApp(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  小程序管理修改
     *
     * @param miniAppUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updateMiniApp(MiniAppUpdateVo miniAppUpdateVo) throws Exception;

    /**
     * description 小程序管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findMiniAppPageList(QueryParameter<MiniAppParam> queryParameter) throws Exception;
}
