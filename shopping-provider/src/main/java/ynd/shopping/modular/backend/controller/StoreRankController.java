package ynd.shopping.modular.backend.controller;

import ynd.shopping.annotation.AdminController;
import ynd.shopping.modular.backend.pojo.vo.StoreRankListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.service.StoreRankService;
import ynd.shopping.modular.backend.pojo.dto.StoreRankInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.StoreRankUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.StoreRankParam;

import java.util.List;

/**
 * <p>
 * 店铺等级 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
@Api(tags = {"店铺等级管理"})
@Validated
@RequestMapping("/storeRank")
@AdminController("AdminStoreRankController")
public class StoreRankController {

    @Autowired
    private StoreRankService storeRankService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertStoreRank(@RequestBody @Valid StoreRankInsertDTO storeRankInsertDTO) throws Exception {
        return storeRankService.insertStoreRank(storeRankInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteStoreRank(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return storeRankService.deleteStoreRank(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateStoreRank(@RequestBody @Valid StoreRankUpdateDTO storeRankUpdateVo) throws Exception {
        return storeRankService.updateStoreRank(storeRankUpdateVo);
    }

    @ApiOperation("列表查询")
    @PostMapping("/list")
    public BackResult<List<StoreRankListVo>> queryStoreRankPageList(@RequestBody @Valid QueryParameter<StoreRankParam> queryParameter) throws Exception {
        return storeRankService.queryStoreRankPageList(queryParameter);
    }

}
