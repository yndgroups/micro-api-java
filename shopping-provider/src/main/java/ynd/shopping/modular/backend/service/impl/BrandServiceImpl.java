package ynd.shopping.modular.backend.service.impl;

import ynd.shopping.modular.backend.entity.BrandEntity;
import ynd.shopping.modular.backend.pojo.vo.BrandListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.core.dto.DeleteDTO;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.shopping.modular.backend.mapper.BrandMapper;
import ynd.shopping.modular.backend.service.BrandService;
import ynd.shopping.modular.backend.pojo.dto.BrandInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.BrandUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.BrandParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 * 品牌 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-28
 */
@Service("AdminBrandServiceImpl")
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandEntity> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  品牌管理新增
     *
     * @param brandInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-28
     **/
    @Override
    public BackResult insertBrand(BrandInsertDTO brandInsertDTO) throws Exception {
        BrandEntity brandEntity = new BrandEntity();
        BeanUtils.copyProperties(brandInsertDTO, brandEntity);
        brandEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        brandEntity.setBrandId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(brandEntity));
    }

    /**
     * description  品牌管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-28
     **/
    @Override
    public BackResult deleteBrand(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  品牌管理修改
     *
     * @param brandUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-28
     **/
    @Override
    public BackResult updateBrand(BrandUpdateDTO brandUpdateVo) throws Exception {
        BrandEntity brandEntity = new BrandEntity();
        BeanUtils.copyProperties(brandUpdateVo, brandEntity);
        brandEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(brandEntity));
    }

    /**
     * description 品牌管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-28
     **/
    @Override
    public BackResult queryBrandPageList(QueryParameter<BrandParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryBrandPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryBrandPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据商品id查询品牌
     *
     * @param productCategoryId 商品分类id
     * @return result
     * @author yangdaqiong
     * @date 2021-11-07 20:54:56
     **/
    @Override
    public BackResult<List<BrandListVo>> listByProductCategoryId(String productCategoryId) {
        List<BrandListVo> list = this.brandMapper.queryListByProductCategoryId(productCategoryId);
        if (list.size() > 0) {
            return BackResult.success(list);
        } else {
            throw new CustomException(0, "未查询到该分类下的品牌信息");
        }
    }

    /**
     * description 根据id查询详情
     *
     * @param brandId 品牌id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-29 02:04:02
     **/
    @Override
    public BackResult queryBrandDetailById(String brandId) {
        LambdaQueryWrapper<BrandEntity> eq = new QueryWrapper<BrandEntity>().lambda().eq(BrandEntity::getBrandId, brandId);
        BrandEntity brandEntity = this.brandMapper.selectOne(eq);
        return BackResult.success(brandEntity);
    }
}
