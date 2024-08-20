package ynd.shopping.modular.backend.service.impl;

import ynd.shopping.modular.backend.pojo.vo.ProductCategoryListVo;
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
import ynd.shopping.modular.backend.entity.ProductCategoryEntity;
import ynd.shopping.modular.backend.mapper.ProductCategoryMapper;
import ynd.shopping.modular.backend.service.ProductCategoryService;
import ynd.shopping.modular.backend.pojo.dto.ProductCategoryInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductCategoryUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.ProductCategoryParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-22
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategoryEntity> implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  商品分类新增
     *
     * @param productCategoryInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    @Override
    public BackResult insertProductCategory(ProductCategoryInsertDTO productCategoryInsertDTO) throws Exception {
        ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
        BeanUtils.copyProperties(productCategoryInsertDTO, productCategoryEntity);
        productCategoryEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        productCategoryEntity.setProductCategoryId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(productCategoryEntity));
    }

    /**
     * description  商品分类删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    @Override
    public BackResult deleteProductCategory(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  商品分类修改
     *
     * @param productCategoryUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    @Override
    public BackResult updateProductCategory(ProductCategoryUpdateDTO productCategoryUpdateVo) throws Exception {
        ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
        BeanUtils.copyProperties(productCategoryUpdateVo, productCategoryEntity);
        productCategoryEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(productCategoryEntity));
    }

    /**
     * description 商品分类列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    @Override
    public BackResult queryProductCategoryPageList(QueryParameter<ProductCategoryParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryProductCategoryPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryProductCategoryPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据productCategoryId查询详情
     *
     * @param productCategoryId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-22
     **/
    @Override
    public BackResult queryProductCategoryDetailById(String productCategoryId) throws Exception {
        LambdaQueryWrapper<ProductCategoryEntity> eq = new QueryWrapper<ProductCategoryEntity>().lambda().eq(ProductCategoryEntity::getProductCategoryId, productCategoryId);
        ProductCategoryEntity productCategoryEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(productCategoryEntity);
    }

    /**
     * description 根据父亲id查询当前店铺下的商品分类
     *
     * @param
     * @return
     * @author yangdaqiong
     * @date 2021-10-04 23:03:10
     **/
    @Override
    public BackResult queryProductCategoryListByParentId(String parentId) {
        List<ProductCategoryListVo> productCategoryListVoList = this.baseMapper.queryProductCategoryListByParentId(parentId);
        return BackResult.success(productCategoryListVoList);
    }
}
