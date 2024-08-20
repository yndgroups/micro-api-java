package ynd.cms.modular.backend.service.impl;

import ynd.cms.modular.backend.entity.CategoryEntity;
import ynd.cms.modular.backend.mapper.CategoryMapper;
import ynd.cms.modular.backend.pojo.dto.CategoryInsertDTO;
import ynd.cms.modular.backend.pojo.dto.CategoryUpdateDTO;
import ynd.cms.modular.backend.pojo.param.CategoryParam;
import ynd.cms.modular.backend.pojo.vo.CategoryListVo;
import ynd.cms.modular.backend.service.CategoryService;
import ynd.core.constant.BaseConstant;
import ynd.core.dto.DeleteDTO;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 信息分类表服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  分类管理新增
     *
     * @param categoryInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    @Override
    public BackResult insertCategory(CategoryInsertDTO categoryInsertDTO) throws Exception {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categoryInsertDTO, categoryEntity);
        categoryEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        categoryEntity.setCategoryId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(categoryEntity));
    }

    /**
     * description  分类管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    @Override
    public BackResult deleteCategory(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  分类管理修改
     *
     * @param categoryUpdateDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    @Override
    public BackResult updateCategory(CategoryUpdateDTO categoryUpdateDTO) throws Exception {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categoryUpdateDTO, categoryEntity);
        categoryEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(categoryEntity));
    }

    /**
     * description 分类管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    @Override
    public BackResult findCategoryPageList(QueryParameter<CategoryParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findCategoryPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findCategoryPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据父id查询列表
     *
     * @param parentId 父id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    @Override
    public BackResult findCategoryListByParentId(String parentId) {
        List<CategoryListVo> listVos = this.baseMapper.findCategoryListByParentId(parentId);
        if (listVos.size() > 0) {
            return BackResult.success(listVos);
        } else {
            throw new CustomException(0, "未查询到分类列表");
        }
    }

    /**
     * description 根据categoryId查询详情
     *
     * @param categoryId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    @Override
    public BackResult findCategoryDetailById(String categoryId) throws Exception {
        LambdaQueryWrapper<CategoryEntity> eq = new QueryWrapper<CategoryEntity>().lambda().eq(CategoryEntity::getCategoryId, categoryId);
        CategoryEntity categoryEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(categoryEntity);
    }

    /**
     * description 根据父id查询子集树形结构列表
     *
     * @param parentId 父id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-17 17:40:11
     */
    @Override
    public BackResult findCategoryTreeListByParentId(String parentId) {
        List<CategoryListVo> listVos = this.baseMapper.findCategoryTreeListByParentId(parentId);
        if (listVos.size() > 0) {
            return BackResult.success(categoryTree(listVos, parentId));
        } else {
            throw new CustomException(0, "未查询到分类列表");
        }
    }

    /**
     * description 处理列表的树形关系
     *
     * @param listVos
     * @return List<CategoryListVo> 树形列表
     * @author yangdaqiong
     * @date 2021-12-18 00:50:14
     */
    private List<CategoryListVo> categoryTree(List<CategoryListVo> listVos, String parentId) {
        List<CategoryListVo> parentList = listVos.stream().filter(it -> it.getParentId().equals(parentId)).collect(Collectors.toList());
        List<CategoryListVo> childList = listVos.stream().filter(it -> !it.getParentId().equals(parentId)).collect(Collectors.toList());
        Map<String, List<CategoryListVo>> listMap = childList.stream().collect(Collectors.groupingBy(it -> it.getParentId()));
        parentList.stream().forEach(it -> {
            List<CategoryListVo> child = listMap.get(it.getCategoryId());
            if (child != null) {
                it.setChildren(childTree(child, listMap));
            }
        });
        return parentList;
    }

    /**
     * description 递归找出子级
     **/
    private List<CategoryListVo> childTree(List<CategoryListVo> listVos, Map<String, List<CategoryListVo>> listMap) {
        List<CategoryListVo> list = new ArrayList<>();
        listVos.stream().forEach(it -> {
            List<CategoryListVo> child = listMap.get(it.getCategoryId());
            if (child != null) {
                it.setChildren(childTree(child, listMap));
            }
        });
        return listVos;
    }
}
