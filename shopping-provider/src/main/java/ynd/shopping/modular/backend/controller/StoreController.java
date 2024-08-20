package ynd.shopping.modular.backend.controller;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.annotation.AdminController;
import ynd.shopping.modular.backend.pojo.vo.StoreListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;
import ynd.shopping.modular.backend.service.StoreService;
import ynd.shopping.modular.backend.pojo.dto.StoreInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.StoreUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.StoreParam;

import java.util.List;

/**
 * <p>
 * 店铺 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-07
 */
@Api(tags = {"店铺管理"})
@Validated
@RequestMapping("/store")
@AdminController("AdminStoreController")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @ApiOperation("新增")
    @PostMapping
    public BackResult insertStore(@RequestBody @Valid StoreInsertDTO storeInsertDTO) throws Exception {
        return storeService.insertStore(storeInsertDTO);
    }

    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deleteStore(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return storeService.deleteStore(deleteDTO);
    }

    @ApiOperation("修改")
    @PutMapping
    public BackResult updateStore(@RequestBody @Valid StoreUpdateDTO storeUpdateVo) throws Exception {
        return storeService.updateStore(storeUpdateVo);
    }

    @ApiOperation("列表查询")
    @PostMapping("/list")
    public BackResult<List<StoreListVo>> queryStorePageList(@RequestBody @Valid QueryParameter<StoreParam> queryParameter) throws Exception {
        return storeService.queryStorePageList(queryParameter);
    }

}
