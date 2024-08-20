package ynd.common.mapper;

import java.util.List;

import ynd.common.entity.DictEntity;
import ynd.common.pojo.vo.DictListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ynd.core.dto.DeleteDTO;

/**
 * <p>
 * 上传资源分类表 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Mapper
public interface DictMapper extends BaseMapper<DictEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 上传资源分类表分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    List<DictListVo> findDictPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 上传资源分类表分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    Integer findDictPageListCount(QueryParameterExtend queryParameterExtend);

    /**
     * description 查询字典树状列表
     *
     * @param parentId 父id
     * @return java.util.List<ynd.dao.common.backend.entity.DictEntity>
     * @author yangdaqiong
     * @date 2021-07-17 16:03:11
     **/
    List<DictListVo> queryDictTreeByParentId(String parentId);
}
