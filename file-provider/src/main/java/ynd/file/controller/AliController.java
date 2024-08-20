package ynd.file.controller;

import ynd.core.result.BackResult;
import ynd.file.service.AliService;
import ynd.file.configuration.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * description 阿里云相关第三方服务管理
 *
 * @author yangdaqiong
 * @date 2020-04-18 22:02
 */
@RestController
@Validated
@Api(tags = {"阿里云相关服务"})
@RequestMapping("/resources/aly")
public class AliController {

  @Autowired
  private AliService aliService;

  @ApiOperation(value = "获取阿里云oss签名")
  @GetMapping("/ossSign/{uploadPath}")
  public BackResult getOssSign(@PathVariable String uploadPath){
   return aliService.getOssSign(uploadPath, Constant.bucketName, Constant.endpointName, Constant.accessKeyId, Constant.keySecret, Constant.ossSignStoreTime);
  }

  @ApiOperation(value = "阿里云文件表单上传")
  @PostMapping("/ossUploadFile/{uploadPath}")
  public BackResult ossUploadFile(@PathVariable String uploadPath, @RequestParam("file") MultipartFile multipartFile){
   return aliService.ossUploadFile(uploadPath, multipartFile, Constant.bucketName, Constant.endpointName, Constant.accessKeyId, Constant.keySecret);
  }
}
