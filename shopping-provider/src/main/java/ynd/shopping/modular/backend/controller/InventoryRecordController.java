package ynd.shopping.modular.backend.controller;

import ynd.shopping.annotation.AdminController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.service.InventoryRecordService;
import ynd.shopping.modular.backend.pojo.dto.InventoryRecordInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.InventoryRecordUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.InventoryRecordParam;

/**
 * <p>
 * 库存记录 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-04
 */
@Api(tags = {"库存记录"})
@Validated
@RequestMapping("/inventoryRecord")
@AdminController("AminInventoryRecordController")
public class InventoryRecordController {

    @Autowired
    private InventoryRecordService inventoryRecordService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertInventoryRecord(@RequestBody @Valid InventoryRecordInsertDTO inventoryRecordInsertDTO) throws Exception {
        return inventoryRecordService.insertInventoryRecord(inventoryRecordInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteInventoryRecord(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return inventoryRecordService.deleteInventoryRecord(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateInventoryRecord(@RequestBody @Valid InventoryRecordUpdateDTO inventoryRecordUpdateVo) throws Exception {
        return inventoryRecordService.updateInventoryRecord(inventoryRecordUpdateVo);
    }

    @ApiOperation("查询列表")
    @PostMapping("/list")
    public BackResult queryInventoryRecordPageList(@RequestBody @Valid QueryParameter<InventoryRecordParam> queryParameter) throws Exception {
        return inventoryRecordService.queryInventoryRecordPageList(queryParameter);
    }

    @ApiOperation("根据id查询详情")
    @GetMapping("/detailById/{id}")
    public BackResult queryInventoryRecordDetailById(@PathVariable(value = "id") String inventoryRecordId) throws Exception {
        return inventoryRecordService.queryInventoryRecordDetailById(inventoryRecordId);
    }

}
