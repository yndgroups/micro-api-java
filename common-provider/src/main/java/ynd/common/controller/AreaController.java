package ynd.common.controller;

import ynd.common.pojo.vo.AreaListVo;
import ynd.core.annotation.AuthPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.common.service.AreaService;
import ynd.common.pojo.vo.AreaInsertVo;
import ynd.common.pojo.vo.AreaUpdateVo;
import ynd.common.pojo.param.AreaParam;
import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;

import java.util.List;

/**
 * <p>
 * 2020区划代码 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"地区管理"})
@Validated
@RequestMapping("/area")
@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;

    @AuthPermissions("system:area:insert")
    @ApiOperation("地区管理-新增")
    @PostMapping
    public BackResult insertArea(@RequestBody @Valid AreaInsertVo areaInsertVo) throws Exception {
        return areaService.addArea(areaInsertVo);
    }

    @AuthPermissions("system:area:delete")
    @ApiOperation("地区管理-删除")
    @DeleteMapping
    public BackResult deleteArea(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return areaService.deleteArea(deleteDTO);
    }

    @AuthPermissions("system:area:update")
    @ApiOperation("地区管理-修改")
    @PutMapping
    public BackResult updateArea(@RequestBody @Valid AreaUpdateVo areaUpdateVo) throws Exception {
        return areaService.updateArea(areaUpdateVo);
    }

    // @AuthPermissions("system:area:query")
    @ApiOperation("地区管理-列表查询")
    @PostMapping("/findAreaPageList")
    public BackResult<List<AreaListVo>> findPageList(@RequestBody @Valid QueryParameter<AreaParam> queryParameter) throws Exception {
        return areaService.findAreaPageList(queryParameter);
    }

    // @AuthPermissions("system:area:query")
    @ApiOperation("地区管理-根据parentCode查询地区列表")
    @PostMapping("/findAreaListByParentCode/{parentCode}")
    public BackResult<List<AreaListVo>> findAreaListByParentCode(@PathVariable String parentCode) {
        return areaService.findAreaListByParentCode(parentCode);
    }

    


}
