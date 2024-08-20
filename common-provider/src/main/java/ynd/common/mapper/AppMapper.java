package ynd.common.mapper;

import java.util.List;

import ynd.common.entity.AppEntity;
import ynd.common.pojo.vo.AppListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ynd.core.dto.DeleteDTO;

/**
 * <p>
 * 应用表 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Mapper
public interface AppMapper extends BaseMapper<AppEntity> {

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
    * description 应用表分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    List<AppListVo> findPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 应用表分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    Integer findPageListCount(QueryParameterExtend queryParameterExtend);

    /**
     * description 查询应用下的权限
     *
     * @param userId
     * @return List<AppList>
     * @author yangdaqiong
     * @date 2021-09-26 21:13:03
     **/
    List<AppListVo> findAppListByUserId(Long userId);

    /**
     * description 查询所有应用
     *
     * @return
     * @author yangdaqiong
     * @date 2021-10-04 11:03:04
     **/
    List<AppListVo> findAllAppListByUserId();
}
