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
import ynd.shopping.modular.backend.entity.ProductSkuEntity;
import ynd.shopping.modular.backend.mapper.ProductSkuMapper;
import ynd.shopping.modular.backend.service.ProductSkuService;
import ynd.shopping.modular.backend.pojo.dto.ProductSkuInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductSkuUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductSkuParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * sku 库存表服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Service
public class ProductSkuServiceImpl extends ServiceImpl<ProductSkuMapper, ProductSkuEntity> implements ProductSkuService {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  商品SKU新增
     *
     * @param productSkuInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult insertProductSku(ProductSkuInsertDTO productSkuInsertDTO) throws Exception {
        ProductSkuEntity productSkuEntity = new ProductSkuEntity();
        BeanUtils.copyProperties(productSkuInsertDTO, productSkuEntity);
        productSkuEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        productSkuEntity.setSkuId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(productSkuEntity));
    }

    /**
     * description  商品SKU删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult deleteProductSku(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  商品SKU修改
     *
     * @param productSkuUpdateDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult updateProductSku(ProductSkuUpdateDTO productSkuUpdateDTO) throws Exception {
        ProductSkuEntity productSkuEntity = new ProductSkuEntity();
        BeanUtils.copyProperties(productSkuUpdateDTO, productSkuEntity);
        productSkuEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(productSkuEntity));
    }

    /**
     * description 商品SKU列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult queryProductSkuPageList(QueryParameter<ProductSkuParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryProductSkuPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryProductSkuPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据skuId查询详情
     *
     * @param skuId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult queryProductSkuDetailById(String skuId) throws Exception {
        LambdaQueryWrapper<ProductSkuEntity> eq = new QueryWrapper<ProductSkuEntity>().lambda().eq(ProductSkuEntity::getSkuId, skuId);
        ProductSkuEntity productSkuEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(productSkuEntity);
    }
}
