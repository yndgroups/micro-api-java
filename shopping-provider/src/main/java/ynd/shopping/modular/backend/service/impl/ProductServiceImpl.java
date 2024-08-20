package ynd.shopping.modular.backend.service.impl;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.entity.ProductSkuEntity;
import ynd.shopping.modular.backend.mapper.ProductSkuMapper;
import ynd.shopping.modular.backend.pojo.dto.GoodsDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductSkuInsertDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.shopping.modular.backend.entity.ProductEntity;
import ynd.shopping.modular.backend.mapper.ProductMapper;
import ynd.shopping.modular.backend.service.ProductService;
import ynd.shopping.modular.backend.pojo.dto.ProductUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 * 商品服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductEntity> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RedisUserService redisUserService;

    @Autowired
    private ProductSkuMapper productSkuMapper;

    /**
     * description  商品管理新增
     *
     * @param goodsDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult insertProduct(GoodsDTO goodsDTO) throws Exception {
        // 添加一个商品 添加多个SKU ? 分类idsku是都需要存储
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(goodsDTO.getProductInsertDTO(), productEntity);
        productEntity.setProductId(redisUserService.createPrimaryKey("PRODUCT_KEY_ID"));
        productEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        List<Long> productCategoryId = goodsDTO.getProductInsertDTO().getProductCategoryId();
        productEntity.setProductCategoryId(productCategoryId.get(productCategoryId.size() - 1));

        // 新增SKU
        List<ProductSkuInsertDTO> skuList = goodsDTO.getProductSkuInsertDTO();
        int insert = 0;
        for (ProductSkuInsertDTO skuInsertDTO : skuList) {
            ProductSkuEntity productSkuEntity = new ProductSkuEntity();
            BeanUtils.copyProperties(skuInsertDTO, productSkuEntity);
            productSkuEntity.setSkuId(redisUserService.createPrimaryKey("PRODUCT_KEY_ID"));
            String skuName = productEntity.getName() + "sku" + "params";
            productSkuEntity.setSkuName(skuName);
            productSkuEntity.setProductId(productEntity.getProductId());
            productSkuEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
            insert += productSkuMapper.insert(productSkuEntity);
        }
        return BackResult.insert(this.save(productEntity));
    }

    /**
     * description  商品管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult deleteProduct(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  商品管理修改
     *
     * @param productUpdateDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult updateProduct(ProductUpdateDTO productUpdateDTO) throws Exception {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productUpdateDTO, productEntity);
        productEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(productEntity));
    }

    /**
     * description 商品管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult findProductPageList(QueryParameter<ProductParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findProductPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findProductPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据productId查询详情
     *
     * @param productId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-12
     **/
    @Override
    public BackResult findProductDetailById(String productId) throws Exception {
        LambdaQueryWrapper<ProductEntity> eq = new QueryWrapper<ProductEntity>().lambda().eq(ProductEntity::getProductId, productId);
        ProductEntity productEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(productEntity);
    }
}
