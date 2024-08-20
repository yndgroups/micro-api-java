package ynd.common.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.common.entity.RoleEntity;
import ynd.common.pojo.vo.RoleListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色表 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {

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
    * description 角色表分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    List<RoleListVo> findRolePageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 角色表分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    Integer findRolePageListCount(QueryParameterExtend queryParameterExtend);
}
