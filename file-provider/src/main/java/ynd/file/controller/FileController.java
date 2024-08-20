package ynd.file.controller;

import ynd.core.result.BackResult;
import ynd.file.service.FileService;
import ynd.file.configuration.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * description  文件管理
 *
 * @author yangdaqiong
 * @date 2020-05-23 17:19:13
 **/
@Api(tags = {"文件管理"})
@RequestMapping("/resources/file")
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation("文件单个上传")
    @PostMapping("/upload")
    public BackResult uploadFile(@RequestParam("file") MultipartFile file, @RequestParam String appId) {
        return fileService.uploadFile(file, appId);
    }

    @ApiOperation("文件批量上传")
    @PostMapping("/uploadFileList")
    public BackResult uploadFileList(@RequestParam("file") List<MultipartFile> files, @RequestParam String appId) {
        return null;
    }

    @ApiOperation("文件列表")
    @PostMapping("/getFileList")
    public BackResult getFileList(@RequestParam String appId, @RequestParam(defaultValue = "/") String dir) {
        return fileService.getFileList(appId, dir, Constant.uploadPath);
    }

    @ApiOperation("文件删除")
    @PostMapping("/deleteFile")
    public BackResult deleteFile(@RequestParam String appId, @RequestParam(defaultValue = "/") String dir) {
        return fileService.deleteFile(Constant.uploadPath + appId, dir);
    }

    @ApiOperation("多尺寸文件上传")
    @PostMapping("uploadFileMoreSize")
    public BackResult uploadFile(@RequestParam String appId, @RequestParam("file") MultipartFile file) throws Exception {
        return fileService.uploadFileMoreSize(file, appId);
    }
}
