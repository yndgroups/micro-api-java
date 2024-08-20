package ynd.file.service.impl;

import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.result.BackResult;
import ynd.core.service.RedisService;
import ynd.core.service.RedisUserService;
import ynd.file.service.AliService;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * description 阿里云相关第三方服务管理
 *
 * @param
 * @author yangdaqiong
 * @return
 * @date 2019/11/21 0021 9:47
 **/
@Service
public class AliServiceImpl implements AliService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description 获取阿里云oss签名
     *
     * @param uploadPath 需要上传的文件夹
     * @return 返回oss的签名
     * @author yangdaqiong
     * @date 2019/11/21 0021 11:20
     **/
    @Override
    public BackResult getOssSign(String uploadPath, String bucketName, String endpointName, String accessKeyId, String keySecret, Long ossSignStoreTime) {
        Map<Object, Object> ossSign = redisService.getMap("oss_sign");
        if (ossSign.isEmpty()) {
            /**
             * accessId -> 请填写您的AccessKeyId。
             * keySecret -> 请填写您的AccessKeySecret。
             * endpointConfig -> 请填写您的 endpoint。
             * bucketConfig -> 请填写您的 bucketname 。
             *  host -> host的格式为 bucketname.endpoint
             */
            String host = "https://" + bucketName + "." + endpointName;
            OSS client = new OSSClientBuilder().build(endpointName, accessKeyId, keySecret);
            try {
                /*签名有效期30分钟*/
                long expiryTime = System.currentTimeMillis() + 1000 * ossSignStoreTime;
                Date expiration = new Date(expiryTime);
                PolicyConditions policyConditions = new PolicyConditions();
                policyConditions.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
                policyConditions.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, uploadPath);

                String postPolicy = client.generatePostPolicy(expiration, policyConditions);
                byte[] binaryData = postPolicy.getBytes("utf-8");
                String encodedPolicy = BinaryUtil.toBase64String(binaryData);
                String postSignature = client.calculatePostSignature(postPolicy);

                HashMap<String, String> respMap = new HashMap<>(6);
                respMap.put("accessid",  accessKeyId);
                respMap.put("policy", encodedPolicy);
                respMap.put("signature", postSignature);
                respMap.put("dir", uploadPath);
                respMap.put("host", host);
                respMap.put("expire", String.valueOf(expiryTime / 1000));
                redisService.setMap("oss_sign", respMap, ossSignStoreTime);
                return new BackResult(respMap, ResponseEnum.REQ_SUCCESS);
            } catch (Exception e) {
                e.printStackTrace();
                throw new CustomException(0, "错误的请求参数");
            }
        } else {
            return new BackResult(ossSign, ResponseEnum.REQ_SUCCESS);
        }
    }

    /**
     * description 阿里云表单上传
     *@return
     *@param
     *@author yangdaqiong
     *@date 2019/11/21 0021 15:06
     **/
    @Override
    public BackResult ossUploadFile(String uploadPath, MultipartFile multipartFile,String bucketName, String endpointName, String accessKeyId, String keySecret){
        String originalFilename = multipartFile.getOriginalFilename();
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        OSSClient ossClient = (OSSClient) new OSSClientBuilder().build(endpointName, accessKeyId, keySecret);
        String filePathName = uploadPath + "/" + redisUserService.createPrimaryKey() + suffixName;
        try {
            PutObjectResult putObjectResult =  ossClient.putObject(bucketName, filePathName, multipartFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ossClient.shutdown();
        String fileAbsolutePath = "https://" + bucketName + "." + endpointName + "/" + filePathName;
        return new BackResult(fileAbsolutePath, ResponseEnum.REQ_SUCCESS);
    }
}
