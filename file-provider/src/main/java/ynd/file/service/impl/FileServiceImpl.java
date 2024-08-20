package ynd.file.service.impl;

import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.result.BackResult;
import ynd.core.utils.DeleteFileUtil;
import ynd.file.configuration.Constant;
import ynd.file.service.FileService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * description  文件管理实现类
 *
 * @author yangdaqiong
 * @date 2020-06-23 17:19:59
 **/
@Service
public class FileServiceImpl implements FileService {

    /**
     * description 文件上传
     *
     * @param file
     * @param appId
     * @return BackVO
     * @author yangdaqiong
     * @date 2020-04-19 23:33
     */
    @Override
    public BackResult uploadFile(MultipartFile file, String appId) {
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        int month = (instance.get(Calendar.MONTH) + 1);
        int day = instance.get(Calendar.DAY_OF_MONTH);
        String yearPath = String.valueOf(year);
        String monthPath = "";
        String dayPath = "";
        if (month < 9) {
            monthPath = "0" + String.valueOf(month);
        } else {
            monthPath = String.valueOf(month);
        }
        if (day < 9) {
            dayPath = "0" + String.valueOf(day);
        } else {
            dayPath = String.valueOf(day);
        }
        String datePathString = yearPath + monthPath + dayPath;
        String urlPath = appId + "/" + suffix.replace(".", "") + "/" + datePathString;
        String newPath = Constant.uploadPath + urlPath;
        // String newPath = urlPath;
        File files = new File(newPath);
        if (!files.exists()) {
            files.mkdirs();
        }
        Path path = Paths.get(newPath);
        String filename = String.valueOf(instance.getTimeInMillis()) + suffix;
        if (file.isEmpty()) {
            throw new CustomException(0, "未能存储文件名为：${filename}的空文件");
        }
        if (filename.contains("src/test")) {
            throw new CustomException(0, "无法在当前src/test存储文件：${filename}");
        }
        try {
            Long res = Files.copy(file.getInputStream(), path.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            if (res > 0) {
                return BackResult.success("/resources/" + urlPath + "/" + filename);
            } else {
                return new BackResult(ResponseEnum.UPLOAD_FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(0, e.getMessage());
        }
    }

    /**
     * description 获取文件列表
     *
     * @param appId
     * @return dir
     * @author yangdaqiong
     * @date 2020-04-19 10:42
     */
    @Override
    public BackResult getFileList(String appId, String dir, String uploadPath) {
        // 文件数量
        int fileCount = 0;
        // 文件夹数量
        int folderCount = 0;
        String readPath = uploadPath + appId;
        if (!"/".equals(dir)) {
            readPath += "/" + dir;
        }
        File file = new File(readPath);
        if (file.exists()) {
            List<List<HashMap<String, String>>> result = new ArrayList<>();
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            List<HashMap<String, String>> folderList = new ArrayList<>();
            List<HashMap<String, String>> fileList = new ArrayList<>();
            for (File file2 : files) {
                HashMap<String, String> folderMap = new HashMap<>(16);
                HashMap<String, String> fileMap = new HashMap<>(16);
                if (file2.isDirectory()) {
                    String folderPath = "";
                    if (!"/".equals(dir)) {
                        folderPath = dir + "/" + file2.getName();
                    } else {
                        folderPath = file2.getName();
                    }
                    folderMap.put("folderName", folderPath);
                    list.add(file2);
                    folderList.add(folderMap);
                    folderCount++;
                    /*System.out.println("文件夹:" + file2.getAbsolutePath());*/
                } else {
                    String filePath = "";
                    if (!"/".equals(dir)) {
                        filePath = dir + "/" + file2.getName();
                    } else {
                        filePath = file2.getName();
                    }
                    fileMap.put("fileName", filePath);
                    fileList.add(fileMap);
                    fileCount++;
                    /*System.out.println("文件:" + file2.getAbsolutePath());*/
                }
            }
            if (!folderList.isEmpty()) {
                result.add(folderList);
            }
            if (!fileList.isEmpty()) {
                result.add(fileList);
            }
            HashMap<String, Object> map = new HashMap<>(16);
            map.put("list", result);
            map.put("result", "当前文件夹共有:" + folderCount + ",文件共有:" + fileCount);
            return BackResult.success(map);
        } else {
            System.out.println("文件不存在!");
            throw new CustomException(0, "没有任何文件!");
        }
    }

    /**
     * description 删除文件
     *
     * @param basePath
     * @param dir
     * @return BackVO
     * @author yangdaqiong
     * @date 2020-08-10 17:01
     **/
    @Override
    public BackResult deleteFile(String basePath, String dir) {
        String path = basePath;
        if (!"/".equals(dir)) {
            path += "/" + dir;
        }
        File file = new File(path);
        if (!file.exists()) {
            throw new CustomException(0, "文件夹不存在");
        } else {
            if (file.isFile()) {
                if (DeleteFileUtil.deleteFile(path)) {
                    return new BackResult(ResponseEnum.DELETE_FILE_SUCCESS);
                } else {
                    return new BackResult(ResponseEnum.DELETE_FILE_FAIL);
                }
            } else {
                if (DeleteFileUtil.deleteDirectory(path)) {
                    return new BackResult(ResponseEnum.DELETE_FOLDER_SUCCESS);
                } else {
                    return new BackResult(ResponseEnum.DELETE_FOLDER_FAIL);
                }
            }
        }
    }

    /**
     * description  多尺寸文件上传
     *
     * @param file  文件
     * @param appId 应用id
     * @return BackResult 返回结果
     * @author yangdaqiong
     * @date 2021-11-15 01:41:39
     **/
    @Override
    public BackResult uploadFileMoreSize(MultipartFile file, String appId) {
        String contentType = file.getContentType();
        String type;
        if (contentType != null && contentType.contains("image")) {
            type = "image";
        } else if (contentType != null && contentType.contains("video")) {
            type = "video";
        } else {
            type = "other";
        }
        String fileName = file.getOriginalFilename();
        String suffix = fileName != null ? fileName.substring(fileName.lastIndexOf(".")).toLowerCase() : "";
        List<String> pathList = createFilePath(appId, type, suffix);

        // 保存文件
        uploadFile(pathList.get(0), file);
        // 文件上传之后处理多尺寸
        HashMap<String, String> upLoadResult = new HashMap<>();
        // 判断是否为图片类型
        if (type.equals("image")) {
            // 创建固定分辨率图片
            upLoadResult = createImages(pathList);
        } else {
            upLoadResult.put(type, pathList.get(0));
        }
        return BackResult.success(upLoadResult);
    }

    /**
     * 上传文件
     *
     * @param path 文件路径
     * @param file 文件
     * @return
     */
    public Boolean uploadFile(String path, MultipartFile file) {
        String filePath = Constant.uploadPath + "/" + path;
        try {
            File newFile = new File(filePath);
            if (!newFile.exists()) {
                newFile.getParentFile().mkdirs();
                newFile.createNewFile();
            }
            // 会覆盖原文件
            file.transferTo(newFile);
            return true;
        } catch (IOException e) {
            throw new CustomException(0, e.getMessage());
        }
    }

    /**
     * 创建文件路径
     *
     * @param type   文件类型
     * @param suffix 文件后缀
     * @return res 资源列表
     */
    public static List<String> createFilePath(String appId, String type, String suffix) {
        List<String> res = new ArrayList();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        long timestamp = new Date().getTime();
        String date = f.format(timestamp);
        int randomNum = (int) (Math.random() * 900) + 100;
        String baseUrl = appId + "/" + type + "/";
        baseUrl += String.format("%s/%d/%d", date, timestamp, randomNum);
        if (type != null && type.equals("image")) {
            String source = baseUrl + "/source" + suffix; // source 原图
            String img1000 = baseUrl + "/large" + suffix; // 1000 large 大图
            String img400 = baseUrl + "/medium" + suffix; // 400 medium 中等图
            String img100 = baseUrl + "/thumbnail" + suffix; // 100 thumbnail 缩略图
            res.add(source);
            res.add(img1000);
            res.add(img400);
            res.add(img100);
        } else {
            String source = baseUrl + suffix;
            res.add(source);
        }
        return res;
    }

    /**
     * 创建固定分辨率图片
     *
     * @param pathList
     * @return HashMap<String, String> 路径地址
     */
    public static HashMap<String, String> createImages(List<String> pathList) {
        HashMap<String, String> upLoadResult = new HashMap<>();
        try {
            String baseUrl = Constant.uploadPath;
            String sourcePath = baseUrl  + "/" + pathList.get(0);
            ImageIcon img = new ImageIcon(sourcePath);
            int width = img.getIconWidth();
            int height = img.getIconHeight();
            upLoadResult.put("source", "/resources/" + pathList.get(0));
            if (width >= 1000) {
                InputStream is = new FileInputStream(sourcePath);
                OutputStream os = new FileOutputStream(baseUrl + "/" + pathList.get(1));
                Thumbnails.of(is).size(1000, 1000 * height / width).toOutputStream(os);
                upLoadResult.put("large", "/resources/" + pathList.get(1));
            }
            if (width >= 400) {
                InputStream is = new FileInputStream(sourcePath);
                OutputStream os = new FileOutputStream(baseUrl + "/" + pathList.get(2));
                Thumbnails.of(is).size(400, 400 * height / width).toOutputStream(os);
                upLoadResult.put("medium", "/resources/" + pathList.get(2));
            }
            if (width >= 100) {
                InputStream is = new FileInputStream(sourcePath);
                OutputStream os = new FileOutputStream(baseUrl + "/" + pathList.get(3));
                Thumbnails.of(is).size(100, 100 * height / width).toOutputStream(os);
                upLoadResult.put("thumbnail", "/resources/" + pathList.get(3));
            }
        } catch (Exception e) {
            throw new CustomException(0, e.getMessage());
        }
        return upLoadResult;
    }
}
