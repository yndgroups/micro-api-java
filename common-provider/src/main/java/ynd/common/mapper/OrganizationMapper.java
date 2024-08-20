package ynd.common.mapper;

import java.util.List;

import ynd.core.dto.DeleteDTO;
import ynd.common.entity.OrganizationEntity;
import ynd.common.pojo.vo.OrganizationListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 企业或组织信息表 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Mapper
public interface OrganizationMapper extends BaseMapper<OrganizationEntity> {

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
    * description 企业或组织信息表分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    List<OrganizationListVo> findOrganizationPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 企业或组织信息表分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    Integer findOrganizationPageListCount(QueryParameterExtend queryParameterExtend);
}
