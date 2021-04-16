package org.jeecg.meeting.utils;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.meeting.constant.CacheConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: org.jeecg.common.util
 * @ClassName: UploaUtil
 * @Author: Stephen
 * @CreateTime: 2020/9/23
 * @Description: 上传文件工具类
 */
@Slf4j
public class UploadLocalUtil {

    @Value(value = "${jeecg.path.upload}")
    private static String uploadpath;

    /**
     * 本地文件上传
     * @param mf 文件
     * @param bizPath  自定义路径
     * @return
     */
    public static Map<String, String> uploadLocal(MultipartFile mf,String bizPath){
        Map<String, String> fileInfo = new HashMap<>();
        try {
            String ctxPath = CacheConstant.CTX_PATH;
            String fileName = null;
            File file = new File(ctxPath + File.separator + bizPath + File.separator );
            if (!file.exists()) {
                file.mkdirs();// 创建文件根目录
            }
            String orgName = mf.getOriginalFilename();// 获取文件名
            orgName = CommonUtils.getFileName(orgName);
            fileName = orgName;
            String savePath = file.getPath() + File.separator + fileName;
            File savefile = new File(savePath);
            FileCopyUtils.copy(mf.getBytes(), savefile);
            String dbpath = null;
            if(oConvertUtils.isNotEmpty(bizPath)){
                dbpath = bizPath + File.separator + fileName;
            }else{
                dbpath = fileName;
            }
            if (dbpath.contains("\\")) {
                dbpath = dbpath.replace("\\", "/");
            }
            fileInfo.put("fileName", fileName);
            fileInfo.put("path", dbpath);
            return fileInfo;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return fileInfo;
    }

}
