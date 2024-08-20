package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.StoreEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.StoreInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.StoreUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.StoreParam;

/**
 * <p>
 * 店铺 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-07
 */
public interface StoreService extends IService<StoreEntity> {

    /**
     * description  店铺管理新增
     *
     * @param storeInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-07
     **/
    BackResult insertStore(StoreInsertDTO storeInsertDTO) throws Exception;

    /**
     * description  店铺管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-08-07
     **/
    BackResult deleteStore(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  店铺管理修改
     *
     * @param storeUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-08-07
     **/
    BackResult updateStore(StoreUpdateDTO storeUpdateVo) throws Exception;

    /**
     * description 店铺管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-07
     **/
    BackResult queryStorePageList(QueryParameter<StoreParam> queryParameter) throws Exception;

}
