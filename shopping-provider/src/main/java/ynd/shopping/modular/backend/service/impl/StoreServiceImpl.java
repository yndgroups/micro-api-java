package ynd.shopping.modular.backend.service.impl;

import ynd.core.dto.DeleteDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.shopping.modular.backend.entity.StoreEntity;
import ynd.shopping.modular.backend.mapper.StoreMapper;
import ynd.shopping.modular.backend.service.StoreService;
import ynd.shopping.modular.backend.pojo.dto.StoreInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.StoreUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.StoreParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 店铺 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-07
 */
@Service("AdminStoreServiceImpl")
public class StoreServiceImpl extends ServiceImpl<StoreMapper, StoreEntity> implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  店铺管理新增
     *
     * @param storeInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-07
     **/
    @Override
    public BackResult insertStore(StoreInsertDTO storeInsertDTO) throws Exception {
        StoreEntity storeEntity = new StoreEntity();
        BeanUtils.copyProperties(storeInsertDTO, storeEntity);
        storeEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        storeEntity.setStoreId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(storeEntity));
    }

    /**
     * description  店铺管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-07
     **/
    @Override
    public BackResult deleteStore(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  店铺管理修改
     *
     * @param storeUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-07
     **/
    @Override
    public BackResult updateStore(StoreUpdateDTO storeUpdateVo) throws Exception {
        StoreEntity storeEntity = new StoreEntity();
        BeanUtils.copyProperties(storeUpdateVo, storeEntity);
        storeEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(storeEntity));
    }

    /**
     * description 店铺管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-07
     **/
    @Override
    public BackResult queryStorePageList(QueryParameter<StoreParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryStorePageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryStorePageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
