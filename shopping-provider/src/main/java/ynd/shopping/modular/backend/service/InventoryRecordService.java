package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.InventoryRecordEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.InventoryRecordInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.InventoryRecordUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.InventoryRecordParam;

/**
 * <p>
 * 库存记录 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-04
 */
public interface InventoryRecordService extends IService<InventoryRecordEntity> {
    /**
     * description  库存记录新增
     *
     * @param inventoryRecordInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    BackResult insertInventoryRecord(InventoryRecordInsertDTO inventoryRecordInsertDTO) throws Exception;

    /**
     * description  库存记录删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    BackResult deleteInventoryRecord(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  库存记录修改
     *
     * @param inventoryRecordUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    BackResult updateInventoryRecord(InventoryRecordUpdateDTO inventoryRecordUpdateVo) throws Exception;

    /**
     * description 库存记录列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    BackResult queryInventoryRecordPageList(QueryParameter<InventoryRecordParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param inventoryRecordId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-04
     */
    BackResult queryInventoryRecordDetailById(String inventoryRecordId) throws Exception;

}
