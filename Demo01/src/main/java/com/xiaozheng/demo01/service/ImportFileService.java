package com.xiaozheng.demo01.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author zyl
 * @description TODO
 * @date 2023/9/7 16:26
 */
public interface ImportFileService {

    String importFile(MultipartFile file);
}
