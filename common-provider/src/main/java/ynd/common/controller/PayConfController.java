package ynd.common.controller;

import ynd.common.pojo.vo.PayConfListVo;
import ynd.core.annotation.AuthPermissions;
import ynd.core.dto.DeleteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import ynd.common.service.PayConfService;
import ynd.common.pojo.vo.PayConfInsertVo;
import ynd.common.pojo.vo.PayConfUpdateVo;
import ynd.common.pojo.param.PayConfParam;
import ynd.core.result.BackResult;
import ynd.core.query.QueryParameter;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Api(tags = {"支付管理"})
@Validated
@RequestMapping("/payConf")
@RestController
public class PayConfController {

    @Autowired
    private PayConfService payConfService;

    @AuthPermissions("system:pay-conf:insert")
    @ApiOperation("新增")
    @PostMapping
    public BackResult insertPayConf(@RequestBody @Valid PayConfInsertVo payConfInsertVo) throws Exception {
        return payConfService.addPayConf(payConfInsertVo);
    }

    @AuthPermissions("system:pay-conf:delete")
    @ApiOperation("删除")
    @DeleteMapping
    public BackResult deletePayConf(@RequestBody @Valid DeleteDTO deleteDTO) throws Exception {
        return payConfService.deletePayConf(deleteDTO);
    }

    @AuthPermissions("system:pay-conf:update")
    @ApiOperation("修改")
    @PutMapping
    public BackResult updatePayConf(@RequestBody @Valid PayConfUpdateVo payConfUpdateVo) throws Exception {
        return payConfService.updatePayConf(payConfUpdateVo);
    }

    @AuthPermissions("system:pay-conf:query")
    @ApiOperation("列表查询")
    @PostMapping("/findPayConfPageList")
    public BackResult<List<PayConfListVo>> findPayConfPageList(@RequestBody @Valid QueryParameter<PayConfParam> queryParameter) throws Exception {
        return payConfService.findPayConfPageList(queryParameter);
    }

}
