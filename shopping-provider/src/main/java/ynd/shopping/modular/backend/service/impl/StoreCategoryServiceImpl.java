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
import ynd.shopping.modular.backend.entity.StoreCategoryEntity;
import ynd.shopping.modular.backend.mapper.StoreCategoryMapper;
import ynd.shopping.modular.backend.service.StoreCategoryService;
import ynd.shopping.modular.backend.pojo.dto.StoreCategoryInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.StoreCategoryUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.StoreCategoryParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 店铺分类 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
@Service("AdminStoreCategoryServiceImpl")
public class StoreCategoryServiceImpl extends ServiceImpl<StoreCategoryMapper, StoreCategoryEntity> implements StoreCategoryService {

    @Autowired
    private StoreCategoryMapper storeCategoryMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  店铺分类管理新增
     *
     * @param storeCategoryInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-08
     **/
    @Override
    public BackResult insertStoreCategory(StoreCategoryInsertDTO storeCategoryInsertDTO) throws Exception {
        StoreCategoryEntity storeCategoryEntity = new StoreCategoryEntity();
        BeanUtils.copyProperties(storeCategoryInsertDTO, storeCategoryEntity);
        storeCategoryEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        storeCategoryEntity.setStoreCategoryId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(storeCategoryEntity));
    }

    /**
     * description  店铺分类管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-08
     **/
    @Override
    public BackResult deleteStoreCategory(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  店铺分类管理修改
     *
     * @param storeCategoryUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-08
     **/
    @Override
    public BackResult updateStoreCategory(StoreCategoryUpdateDTO storeCategoryUpdateVo) throws Exception {
        StoreCategoryEntity storeCategoryEntity = new StoreCategoryEntity();
        BeanUtils.copyProperties(storeCategoryUpdateVo, storeCategoryEntity);
        storeCategoryEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(storeCategoryEntity));
    }

    /**
     * description 店铺分类管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-08
     **/
    @Override
    public BackResult queryStoreCategoryPageList(QueryParameter<StoreCategoryParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryStoreCategoryPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryStoreCategoryPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
