package ynd.shopping.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.shopping.modular.backend.entity.BrandEntity;
import ynd.shopping.modular.backend.pojo.vo.BrandListVo;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.shopping.modular.backend.pojo.dto.BrandInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.BrandUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.BrandParam;

import java.util.List;

/**
 * <p>
 * 品牌 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-28
 */
public interface BrandService extends IService<BrandEntity> {
    /**
     * description  品牌管理新增
     *
     * @param brandInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-08-28
     **/
    BackResult insertBrand(BrandInsertDTO brandInsertDTO) throws Exception;

    /**
     * description  品牌管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-08-28
     **/
    BackResult deleteBrand(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  品牌管理修改
     *
     * @param brandUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-08-28
     **/
    BackResult updateBrand(BrandUpdateDTO brandUpdateVo) throws Exception;

    /**
     * description 品牌管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-28
     **/
    BackResult queryBrandPageList(QueryParameter<BrandParam> queryParameter) throws Exception;

    /**
     * description 品牌管理详情查询
     *
     * @param brandId 品牌id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-28
     */
    BackResult queryBrandDetailById(String brandId);

    /**
     * description
     *
     * @return result
     * @@param productCategoryId 商品分类id
     * @author yangdaqiong
     * @date 2021-11-07 20:53:11
     **/
    BackResult<List<BrandListVo>> listByProductCategoryId(String productCategoryId);

}
