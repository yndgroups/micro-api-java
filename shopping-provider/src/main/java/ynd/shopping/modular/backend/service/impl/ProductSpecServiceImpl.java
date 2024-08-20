package ynd.shopping.modular.backend.service.impl;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.pojo.dto.ProductSpecUpdateDTO;
import ynd.shopping.modular.backend.pojo.vo.ProductSpecListVo;
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
import ynd.shopping.modular.backend.entity.ProductSpecEntity;
import ynd.shopping.modular.backend.mapper.ProductSpecMapper;
import ynd.shopping.modular.backend.service.ProductSpecService;
import ynd.shopping.modular.backend.pojo.dto.ProductSpecInsertDTO;
import ynd.shopping.modular.backend.pojo.param.ProductSpecParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 * 属性 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-08
 */
@Service
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecMapper, ProductSpecEntity> implements ProductSpecService {

    @Autowired
    private ProductSpecMapper productSpecMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  商品规格管理新增
     *
     * @param productSpecInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    @Override
    public BackResult insertProductSpec(ProductSpecInsertDTO productSpecInsertDTO) throws Exception {
        ProductSpecEntity productSpecEntity = new ProductSpecEntity();
        BeanUtils.copyProperties(productSpecInsertDTO, productSpecEntity);
        productSpecEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        productSpecEntity.setSpecId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(productSpecEntity));
    }

    /**
     * description  商品规格管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    @Override
    public BackResult deleteProductSpec(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  商品规格管理修改
     *
     * @param productSpecUpdateDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    @Override
    public BackResult updateProductSpec(ProductSpecUpdateDTO productSpecUpdateDTO) throws Exception {
        ProductSpecEntity productSpecEntity = new ProductSpecEntity();
        BeanUtils.copyProperties(productSpecUpdateDTO, productSpecEntity);
        productSpecEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(productSpecEntity));
    }

    /**
     * description 商品规格管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    @Override
    public BackResult queryProductSpecPageList(QueryParameter<ProductSpecParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryProductSpecPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryProductSpecPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据商品分类id获取商品规格
     *
     * @param productCategoryId
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-11-08 23:42:39
     **/
    @Override
    public BackResult listProductSpecByProductCategoryId(String productCategoryId) {
        List<ProductSpecListVo> productSpecListVos = this.baseMapper.listProductSpecByProductCategoryId(productCategoryId);
        if (productSpecListVos.size() > 0) {
            return BackResult.success(productSpecListVos);
        } else {
            return BackResult.fail("未查询到相关的规格参数，请去添加规格参数");
        }
    }

    /**
     * description 根据productAttrId查询详情
     *
     * @param specId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-11-08
     **/
    @Override
    public BackResult queryProductSpecDetailById(String specId) throws Exception {
        LambdaQueryWrapper<ProductSpecEntity> eq = new QueryWrapper<ProductSpecEntity>().lambda().eq(ProductSpecEntity::getSpecId, specId);
        ProductSpecEntity productSpecEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(productSpecEntity);
    }
}
