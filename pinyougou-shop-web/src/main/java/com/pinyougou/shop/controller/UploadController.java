package com.pinyougou.shop.controller;

import com.pinyougou.common.utils.OSSClientUtil;
import com.pinyougou.common.utils.QiniuyunOSSUtil;
import entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lhh
 * @date 2019/3/17 21:24
 * @Description:
 */
@RequestMapping("/upload")
@RestController
public class UploadController {
    private Logger logger = LoggerFactory.getLogger(UploadController.class);
    //图片上传的文件夹
    private final static String FILEDIR = "shop/";

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {
        StopWatch stopWatch = new StopWatch("图片上传");
        try {
            OSSClientUtil ossClient = new OSSClientUtil();
            QiniuyunOSSUtil qiniuyunOSSUtil = new QiniuyunOSSUtil();
            stopWatch.start("阿里云上传图片");
            String name = ossClient.uploadImg2Oss(file, FILEDIR);
            String imageUrl = ossClient.getImgUrl(name);
            System.out.println("路径:" + imageUrl);
            logger.info("图片名:{}上传图片路径:{}", name, imageUrl);
            stopWatch.stop();
            stopWatch.start("七牛云上传图片");
            String qiniuyunURL = qiniuyunOSSUtil.saveImage(file);
            logger.info("七牛云路径,{}", qiniuyunURL);
            stopWatch.stop();
            stopWatch.prettyPrint();
            stopWatch.shortSummary();
            return new Result(true, imageUrl);
        } catch (Exception e) {
            return new Result(false, "上传失败");
        }
    }
}
