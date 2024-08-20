package ynd.common.controller;

import ynd.common.pojo.vo.EnumListVo;
import ynd.core.annotation.AuthPermissions;
import ynd.common.service.EnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.common.pojo.vo.EnumInsertVo;
import ynd.common.pojo.vo.EnumUpdateVo;
import ynd.common.pojo.param.EnumParam;
import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"枚举管理"})
@Validated
@RequestMapping("/enum")
@RestController
public class EnumController {

    @Autowired
    private EnumService enumService;

    @AuthPermissions("system:enum:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertEnum(@RequestBody @Valid EnumInsertVo enumInsertVo) throws Exception {
        return enumService.addEnum(enumInsertVo);
    }

    @AuthPermissions("system:enum:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteEnum(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return enumService.deleteEnum(deleteDTO);
    }

    @AuthPermissions("system:enum:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updateEnum(@RequestBody @Valid EnumUpdateVo enumUpdateVo) throws Exception {
        return enumService.updateEnum(enumUpdateVo);
    }

    @AuthPermissions("system:enum:query")
    @ApiOperation("列表查询")
    @PostMapping("/findEnumPageList")
    public BackResult<List<EnumListVo>> findEnumPageList(@RequestBody @Valid QueryParameter<EnumParam> queryParameter) throws Exception {
        return enumService.findEnumPageList(queryParameter);
    }

}
