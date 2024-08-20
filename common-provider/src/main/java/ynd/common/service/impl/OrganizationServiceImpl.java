package ynd.common.service.impl;

import ynd.common.service.OrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.common.entity.OrganizationEntity;
import ynd.common.mapper.OrganizationMapper;
import ynd.common.pojo.vo.OrganizationInsertVo;
import ynd.common.pojo.vo.OrganizationUpdateVo;
import ynd.common.pojo.param.OrganizationParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ynd.core.dto.DeleteDTO;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;


/**
 * <p>
 * 企业或组织信息表 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, OrganizationEntity> implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  组织或机构管理新增
     *
     * @param organizationInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addOrganization(OrganizationInsertVo organizationInsertVo) throws Exception {
        OrganizationEntity organizationEntity = new OrganizationEntity();
        BeanUtils.copyProperties(organizationInsertVo, organizationEntity);
        organizationEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        organizationEntity.setOrgId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(organizationEntity));
    }

    /**
     * description  组织或机构管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deleteOrganization(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(organizationMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(organizationMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  组织或机构管理修改
     *
     * @param organizationUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updateOrganization(OrganizationUpdateVo organizationUpdateVo) throws Exception {
        OrganizationEntity organizationEntity = new OrganizationEntity();
        BeanUtils.copyProperties(organizationUpdateVo, organizationEntity);
        organizationEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(organizationEntity));
    }

    /**
     * description 组织或机构管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findOrganizationPageList(QueryParameter<OrganizationParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findOrganizationPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findOrganizationPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
