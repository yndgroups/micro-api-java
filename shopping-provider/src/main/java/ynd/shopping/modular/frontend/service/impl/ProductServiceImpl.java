package ynd.shopping.modular.frontend.service.impl;

import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.shopping.modular.frontend.entity.ProductEntity;
import ynd.shopping.modular.frontend.mapper.ProductMapper;
import ynd.shopping.modular.frontend.pojo.param.ProductParam;
import ynd.shopping.modular.frontend.pojo.vo.ProductCategoryListVo;
import ynd.shopping.modular.frontend.service.ProductService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-11
 */
@Service("FrontendProductServiceImpl")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductEntity> implements ProductService {

    /**
     * description 商品SKU列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    @Override
    public BackResult findProductPageList(QueryParameter<ProductParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, null);
        Integer totalCount = this.baseMapper.findProductPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(),queryParameter.getPageSize(), totalCount,this.baseMapper.findProductPageList(queryParameterExtend)));
        } else {
        throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据productId查询详情
     *
     *@param productId 主键id
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-11
     **/
    @Override
    public BackResult findProductDetailById(String productId) throws Exception {
        LambdaQueryWrapper<ProductEntity> eq = new QueryWrapper<ProductEntity>().lambda().eq(ProductEntity::getProductId, productId);
        ProductEntity productEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(productEntity);
    }

    /**
     * description 查询商品分类
     *
     * @param
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-11 17:06:23
     */
    @Override
    public BackResult findProductCategory() {
        List<ProductCategoryListVo> listVoList = this.baseMapper.findProductCategory();
        return BackResult.success(productCategoryTree(listVoList));
    }

    /**
     * description 处理列表的树形关系
     *
     * @param listVos
     * @return java.util.List<ynd.dao.common.backend.entity.MenuEntity>
     * @author yangdaqiong
     * @date 2021-06-05 08:19:24
     **/
    private List<ProductCategoryListVo> productCategoryTree(List<ProductCategoryListVo> listVos) {
        List<ProductCategoryListVo> parentList = listVos.stream().filter(it -> it.getParentId().equals("1")).collect(Collectors.toList());
        List<ProductCategoryListVo> childList = listVos.stream().filter(it -> !it.getParentId().equals("1")).collect(Collectors.toList());
        Map<String, List<ProductCategoryListVo>> listMap = childList.stream().collect(Collectors.groupingBy(it -> it.getParentId()));
        parentList.stream().forEach(it -> {
            List<ProductCategoryListVo> child = listMap.get(it.getProductCategoryId());
            if (child != null) {
                it.setChildren(childTree(child, listMap));
            }
        });
        return parentList;
    }

    /**
     * description 递归找出子级
     **/
    private List<ProductCategoryListVo> childTree(List<ProductCategoryListVo> listVos, Map<String, List<ProductCategoryListVo>> listMap) {
        List<ProductCategoryListVo> list = new ArrayList<>();
        listVos.stream().forEach(it -> {
            List<ProductCategoryListVo> child = listMap.get(it.getProductCategoryId());
            if (child != null) {
                it.setChildren(childTree(child, listMap));
            }
        });
        return listVos;
    }
}
