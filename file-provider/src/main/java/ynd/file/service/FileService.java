package ynd.file.service;

import ynd.core.result.BackResult;
import org.springframework.web.multipart.MultipartFile;

/**
  * description  文件管理
  *
  *@author yangdaqiong
  *@date 2020/06/23 17:19:33
  **/
public interface FileService {
    /**
      * description  eccel上传
      *
      *@param file
      *@param appId
      *@return BackVO
      *@author yangdaqiong
      *@date 2020/06/23 17:15:27
      **/
    BackResult uploadFile(MultipartFile file, String appId);

    /**
     * description 多规格尺寸上传
     *
     * @param  file  文件
     * @param  appId 应用id
     * @return result
     * @author yangdaqiong
     * @date 2021-11-15 01:25:10
     **/
    BackResult uploadFileMoreSize(MultipartFile file, String appId);

    /**
      * description  获取文件列表
      *
      *@param appId
      *@param dir
      *@return BackVO
      *@author yangdaqiong
      *@date 2020/06/23 17:15:52
      **/
    BackResult getFileList(String appId, String dir, String uploadPath);

    /**
      * description  删除文件
      *
      *@param basePath 基本路径
      *@param dir
      *@return BackVO
      *@author yangdaqiong
      *@date 2020/06/23 17:16:20
      **/
    BackResult deleteFile(String basePath, String dir);
}
