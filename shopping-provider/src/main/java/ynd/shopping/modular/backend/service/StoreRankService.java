package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.StoreRankEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.StoreRankInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.StoreRankUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.StoreRankParam;

/**
 * <p>
 * 店铺等级 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-15
 */
public interface StoreRankService extends IService<StoreRankEntity> {

    /**
     * description  店铺等级管理新增
     *
     * @param storeRankInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-15
     **/
    BackResult insertStoreRank(StoreRankInsertDTO storeRankInsertDTO) throws Exception;

    /**
     * description  店铺等级管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-08-15
     **/
    BackResult deleteStoreRank(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  店铺等级管理修改
     *
     * @param storeRankUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-08-15
     **/
    BackResult updateStoreRank(StoreRankUpdateDTO storeRankUpdateVo) throws Exception;

    /**
     * description 店铺等级管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-15
     **/
    BackResult queryStoreRankPageList(QueryParameter<StoreRankParam> queryParameter) throws Exception;

}
