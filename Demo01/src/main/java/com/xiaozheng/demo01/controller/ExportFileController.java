package com.xiaozheng.demo01.controller;

import com.xiaozheng.demo01.service.ExportFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zyl
 * @description 导出文件
 * @date 2023/9/7 15:04
 */
@RestController
@RequestMapping("zyl1")
public class ExportFileController {
    @Autowired
    private ExportFileService exportFileService;

    /***
     * @description TODO
     * @param response
     * @Param 还可以穿其他参数
     * @return void
     * @author zyl
     * @date 2023/9/7 15:45
    */
    @GetMapping(value = "/export")
    public void exportAssets(HttpServletResponse response) {
        exportFileService.exportFile(response);
    }
}
