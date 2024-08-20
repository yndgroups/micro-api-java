package ynd.common.controller;

import ynd.common.pojo.param.DictParam;
import ynd.common.pojo.vo.DictInsertVo;
import ynd.common.pojo.vo.DictListVo;
import ynd.common.pojo.vo.DictUpdateVo;
import ynd.common.service.DictService;
import ynd.core.annotation.AuthPermissions;
import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 上传资源分类表 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"字典管理"})
@Validated
@RequestMapping("/dict")
@RestController
public class DictController {

    @Autowired
    private DictService dictService;

    @AuthPermissions("system:dict:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertDict(@RequestBody @Valid DictInsertVo dictInsertVo) throws Exception {
        return dictService.addDict(dictInsertVo);
    }

    @AuthPermissions("system:dict:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteDict(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return dictService.deleteDict(deleteDTO);
    }

    @AuthPermissions("system:dict:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updateDict(@RequestBody @Valid DictUpdateVo dictUpdateVo) throws Exception {
        return dictService.updateDict(dictUpdateVo);
    }

    @AuthPermissions("system:dict:query")
    @ApiOperation("列表查询")
    @PostMapping("/findDictPageList")
    public BackResult<List<DictListVo>> findDictPageList(@RequestBody @Valid QueryParameter<DictParam> queryParameter) throws Exception {
        return dictService.findDictPageList(queryParameter);
    }

    @ApiOperation("字典树状列表查询")
    @GetMapping("/findDictTreeByParentId/{parentId}")
    public BackResult<List<DictListVo>> findDictTreeByParentId(@PathVariable String parentId) throws Exception {
        return dictService.findDictTreeByParentId(parentId);
    }

}
