package ynd.cms.modular.backend.mapper;

import java.util.List;

import ynd.cms.modular.backend.entity.CategoryEntity;
import ynd.cms.modular.backend.pojo.vo.CategoryListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import ynd.core.dto.DeleteDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 信息分类表 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 信息分类表分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<CategoryListVo>
    * @author yangdaqiong
    * @date 2021-12-10
    **/
    List<CategoryListVo> findCategoryPageList(QueryParameterExtend queryParameterExtend);

    /**
     * description 信息分类表分页列表总数查询
     *
     * @param queryParameterExtend 查询条件
     * @return Integer
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    Integer findCategoryPageListCount(QueryParameterExtend queryParameterExtend);

    /**
     * description 根据父id查询分类列表
     *
     * @param parentId 父id
     * @return Integer
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    List<CategoryListVo> findCategoryListByParentId(String parentId);

    /**
     * description 根据父id查询子集树形结构列表
     *
     * @param parentId 父id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-17 17:40:46
     */
    List<CategoryListVo> findCategoryTreeListByParentId(String parentId);
}
