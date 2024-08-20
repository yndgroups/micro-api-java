package ynd.file.service;

import ynd.core.result.BackResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * description 阿里云相关第三方服务管理
 * @author yangdaqiong
 * @date 2019-09-25 13:09
 **/
public interface AliService {
    /**
     * description 获取上传验证签名
     *
     * @param uploadPath 上传路径
     * @return R 返回验证签名
     * @author yangdaqiong
     * @date 2019-11-21 10:11
     **/
    BackResult getOssSign(String uploadPath, String bucketName, String endpointName, String accessKeyId, String keySecret, Long ossSignStoreTime);

    /**
     * description 通过后台上传阿里云
     * @param uploadPath
     * @param multipartFile
     * @param bucketName
     *@return BackVO
     *@author yangdaqiong
     *@date 2019-11-21 14:00
     * */
    BackResult ossUploadFile(String uploadPath, MultipartFile multipartFile, String bucketName, String endpointName, String accessKeyId, String keySecret);
}
