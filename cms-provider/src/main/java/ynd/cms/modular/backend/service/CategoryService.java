package ynd.cms.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.cms.modular.backend.entity.CategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.cms.modular.backend.pojo.dto.CategoryInsertDTO;
import ynd.cms.modular.backend.pojo.dto.CategoryUpdateDTO;
import ynd.cms.modular.backend.pojo.param.CategoryParam;

/**
 * <p>
 * 信息分类表服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
public interface CategoryService extends IService<CategoryEntity> {

    /**
     * description  分类管理新增
     *
     * @param categoryInsertDTO 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    BackResult insertCategory(CategoryInsertDTO categoryInsertDTO) throws Exception;

    /**
     * description  分类管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    BackResult deleteCategory(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  分类管理修改
     *
     * @param categoryUpdateDTO
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    BackResult updateCategory(CategoryUpdateDTO categoryUpdateDTO) throws Exception;

    /**
     * description 分类管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    BackResult findCategoryPageList(QueryParameter<CategoryParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param categoryId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-10
     */
    BackResult findCategoryDetailById(String categoryId) throws Exception;

    /**
     * description 根据父id查询列表
     *
     * @param parentId 父id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-10
     */
    BackResult findCategoryListByParentId(String parentId);

    /**
     * description 根据父id查询子集树形结构列表
     *
     * @param parentId 父id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-17 17:38:44
     */
    BackResult findCategoryTreeListByParentId(String parentId);
}
