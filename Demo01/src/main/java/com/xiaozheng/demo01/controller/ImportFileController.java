package com.xiaozheng.demo01.controller;

import com.xiaozheng.demo01.service.ImportFileService;
import com.xiaozheng.demo01.utils.ResultTEntity;
import com.xiaozheng.demo01.utils.ResultTUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zyl
 * @description 导入文件
 * @date 2023/9/7 16:19
 */
@RestController
@RequestMapping("zyl2")
public class ImportFileController {
    @Autowired
    private ImportFileService importFileService;

    @PostMapping(value = "/import")
    public ResultTEntity importAssets(@RequestParam("file") MultipartFile file) {

        String callBackMsg = importFileService.importFile(file);

        if (StringUtils.isNotEmpty(callBackMsg)){
            return ResultTUtil.error(callBackMsg);
        }
        return ResultTUtil.success(callBackMsg);
    }
}
