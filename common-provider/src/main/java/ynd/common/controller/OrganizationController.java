package ynd.common.controller;

import ynd.common.pojo.vo.OrganizationListVo;
import ynd.core.annotation.AuthPermissions;
import ynd.core.dto.DeleteDTO;
import ynd.common.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.common.pojo.vo.OrganizationInsertVo;
import ynd.common.pojo.vo.OrganizationUpdateVo;
import ynd.common.pojo.param.OrganizationParam;
import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;

import java.util.List;

/**
 * <p>
 * 企业或组织信息表 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"组织管理"})
@Validated
@RequestMapping("/organization")
@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @AuthPermissions("system:organization:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertOrganization(@RequestBody @Valid OrganizationInsertVo organizationInsertVo) throws Exception {
        return organizationService.addOrganization(organizationInsertVo);
    }

    @AuthPermissions("system:organization:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteOrganization(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return organizationService.deleteOrganization(deleteDTO);
    }

    @AuthPermissions("system:organization:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updateOrganization(@RequestBody @Valid OrganizationUpdateVo organizationUpdateVo) throws Exception {
        return organizationService.updateOrganization(organizationUpdateVo);
    }

    @AuthPermissions("system:organization:query")
    @ApiOperation("列表查询")
    @PostMapping("/findOrganizationPageList")
    public BackResult<List<OrganizationListVo>> findOrganizationPageList(@RequestBody @Valid QueryParameter<OrganizationParam> queryParameter) throws Exception {
        return organizationService.findOrganizationPageList(queryParameter);
    }

}
