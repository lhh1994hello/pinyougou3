package com.pinyougou.shop.controller;

import entity.Result;
import org.springframework.stereotype.Controller;
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
    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {

        return null;
    }
}
