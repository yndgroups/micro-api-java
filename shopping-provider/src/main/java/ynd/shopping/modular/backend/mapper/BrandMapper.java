package ynd.shopping.modular.backend.mapper;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameterExtend;
import ynd.shopping.modular.backend.entity.BrandEntity;
import ynd.shopping.modular.backend.pojo.vo.BrandListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 品牌 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-28
 */
@Mapper
public interface BrandMapper extends BaseMapper<BrandEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-08-28
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 品牌分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<BrandListVo>
    * @author yangdaqiong
    * @date 2021-08-28
    **/
    List<BrandListVo> queryBrandPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 品牌分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-08-28
    **/
    Integer queryBrandPageListCount(QueryParameterExtend queryParameterExtend);

    /**
     * description
     *
     * @param  productCategoryId 商品分类id
     * @return result
     * @author yangdaqiong
     * @date 2021-11-07 21:03:02
     **/
    List<BrandListVo> queryListByProductCategoryId(String productCategoryId);
}
