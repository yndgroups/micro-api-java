package ynd.common.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.common.entity.AreaEntity;
import ynd.common.pojo.vo.AreaListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 2020区划代码 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Mapper
public interface AreaMapper extends BaseMapper<AreaEntity> {

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
    * description 2020区划代码分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    List<AreaListVo> findAreaPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 2020区划代码分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    Integer findAreaPageListCount(QueryParameterExtend queryParameterExtend);

    /**
     * description 根据父亲的id查询下级地址
     *
     * @param parentId 父id
     * @return List<AreaListVo>
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    List<AreaListVo> findAreaListByParentCode(String parentId);
}
