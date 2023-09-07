package com.xiaozheng.demo01.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zyl
 * @description TODO
 * @date 2023/9/7 15:07
 */
public interface ExportFileService {
    void exportFile(HttpServletResponse response);
}
