package ynd.shopping.modular.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.core.dto.DeleteDTO;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.shopping.modular.backend.entity.InventoryRecordEntity;
import ynd.shopping.modular.backend.mapper.InventoryRecordMapper;
import ynd.shopping.modular.backend.service.InventoryRecordService;
import ynd.shopping.modular.backend.pojo.dto.InventoryRecordInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.InventoryRecordUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.InventoryRecordParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 库存记录 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-04
 */
@Service
public class InventoryRecordServiceImpl extends ServiceImpl<InventoryRecordMapper, InventoryRecordEntity> implements InventoryRecordService {

    @Autowired
    private InventoryRecordMapper inventoryRecordMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  库存记录新增
     *
     * @param inventoryRecordInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    @Override
    public BackResult insertInventoryRecord(InventoryRecordInsertDTO inventoryRecordInsertDTO) throws Exception {
        InventoryRecordEntity inventoryRecordEntity = new InventoryRecordEntity();
        BeanUtils.copyProperties(inventoryRecordInsertDTO, inventoryRecordEntity);
        inventoryRecordEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        inventoryRecordEntity.setInventoryRecordId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(inventoryRecordEntity));
    }

    /**
     * description  库存记录删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    @Override
    public BackResult deleteInventoryRecord(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  库存记录修改
     *
     * @param inventoryRecordUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    @Override
    public BackResult updateInventoryRecord(InventoryRecordUpdateDTO inventoryRecordUpdateVo) throws Exception {
        InventoryRecordEntity inventoryRecordEntity = new InventoryRecordEntity();
        BeanUtils.copyProperties(inventoryRecordUpdateVo, inventoryRecordEntity);
        inventoryRecordEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(inventoryRecordEntity));
    }

    /**
     * description 库存记录列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    @Override
    public BackResult queryInventoryRecordPageList(QueryParameter<InventoryRecordParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryInventoryRecordPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryInventoryRecordPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据inventoryRecordId查询详情
     *
     * @param inventoryRecordId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-04
     **/
    @Override
    public BackResult queryInventoryRecordDetailById(String inventoryRecordId) throws Exception {
        LambdaQueryWrapper<InventoryRecordEntity> eq = new QueryWrapper<InventoryRecordEntity>().lambda().eq(InventoryRecordEntity::getInventoryRecordId, inventoryRecordId);
        InventoryRecordEntity inventoryRecordEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(inventoryRecordEntity);
    }
}
