package ynd.common.service;

import ynd.core.dto.DeleteDTO;
import ynd.common.entity.OrganizationEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.OrganizationInsertVo;
import ynd.common.pojo.vo.OrganizationUpdateVo;
import ynd.common.pojo.param.OrganizationParam;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;

/**
 * <p>
 * 企业或组织信息表 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface OrganizationService extends IService<OrganizationEntity> {

    /**
     * description  组织或机构管理新增
     *
     * @param organizationInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addOrganization(OrganizationInsertVo organizationInsertVo) throws Exception;

    /**
     * description  组织或机构管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deleteOrganization(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  组织或机构管理修改
     *
     * @param organizationUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updateOrganization(OrganizationUpdateVo organizationUpdateVo) throws Exception;

    /**
     * description 组织或机构管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findOrganizationPageList(QueryParameter<OrganizationParam> queryParameter) throws Exception;
}
