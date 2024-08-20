package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.StoreCategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.StoreCategoryInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.StoreCategoryUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.StoreCategoryParam;

/**
 * <p>
 * 店铺分类 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
public interface StoreCategoryService extends IService<StoreCategoryEntity> {

    /**
     * description  店铺分类管理新增
     *
     * @param storeCategoryInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-08
     **/
    BackResult insertStoreCategory(StoreCategoryInsertDTO storeCategoryInsertDTO) throws Exception;

    /**
     * description  店铺分类管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-08-08
     **/
    BackResult deleteStoreCategory(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  店铺分类管理修改
     *
     * @param storeCategoryUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-08-08
     **/
    BackResult updateStoreCategory(StoreCategoryUpdateDTO storeCategoryUpdateVo) throws Exception;

    /**
     * description 店铺分类管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-08
     **/
    BackResult queryStoreCategoryPageList(QueryParameter<StoreCategoryParam> queryParameter) throws Exception;

}
