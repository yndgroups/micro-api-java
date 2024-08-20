package ynd.shopping.modular.backend.service.impl;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.entity.StoreRankEntity;
import ynd.shopping.modular.backend.mapper.StoreRankMapper;
import ynd.shopping.modular.backend.pojo.dto.StoreRankInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.StoreRankUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.StoreRankParam;
import ynd.shopping.modular.backend.service.StoreRankService;
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
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 店铺等级 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-15
 */
@Service("AdminStoreRankServiceImpl")
public class StoreRankServiceImpl extends ServiceImpl<StoreRankMapper, StoreRankEntity> implements StoreRankService {

    @Autowired
    private StoreRankMapper storeRankMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  店铺等级管理新增
     *
     * @param storeRankInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-15
     **/
    @Override
    public BackResult insertStoreRank(StoreRankInsertDTO storeRankInsertDTO) throws Exception {
        StoreRankEntity storeRankEntity = new StoreRankEntity();
        BeanUtils.copyProperties(storeRankInsertDTO, storeRankEntity);
        storeRankEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        storeRankEntity.setStoreRankId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(storeRankEntity));
    }

    /**
     * description  店铺等级管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-15
     **/
    @Override
    public BackResult deleteStoreRank(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  店铺等级管理修改
     *
     * @param storeRankUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-15
     **/
    @Override
    public BackResult updateStoreRank(StoreRankUpdateDTO storeRankUpdateVo) throws Exception {
        StoreRankEntity storeRankEntity = new StoreRankEntity();
        BeanUtils.copyProperties(storeRankUpdateVo, storeRankEntity);
        storeRankEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(storeRankEntity));
    }

    /**
     * description 店铺等级管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-15
     **/
    @Override
    public BackResult queryStoreRankPageList(QueryParameter<StoreRankParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryStoreRankPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryStoreRankPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
