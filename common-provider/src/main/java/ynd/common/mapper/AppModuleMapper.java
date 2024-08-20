package ynd.common.mapper;

import java.util.List;

import ynd.common.entity.AppModuleEntity;
import ynd.common.pojo.vo.AppModuleListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import ynd.core.dto.DeleteDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 应用模块 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-30
 */
@Mapper
public interface AppModuleMapper extends BaseMapper<AppModuleEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 应用模块分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<SysAppModuleListVo>
    * @author yangdaqiong
    * @date 2021-10-30
    **/
    List<AppModuleListVo> findAppModulePageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 应用模块分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-10-30
    **/
    Integer findAppModulePageListCount(QueryParameterExtend queryParameterExtend);


    /**
     * description 应用模块分页列表总数查询
     *
     * @param appId 应用id
     * @return List<SysAppModuleListVo>
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    List<AppModuleListVo> findAppModuleListByAppId(String appId);

}
