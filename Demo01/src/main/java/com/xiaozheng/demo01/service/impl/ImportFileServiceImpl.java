package com.xiaozheng.demo01.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.xiaozheng.demo01.service.ImportFileService;
import com.xiaozheng.demo01.utils.ExcelDataAnalysis;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zyl
 * @description TODO
 * @date 2023/9/7 16:26
 */
@Service
public class ImportFileServiceImpl implements ImportFileService {

    @Override
    public String importFile(MultipartFile file) {

        if (file.getSize() == 0){
            return "文件为空，不予处理";
        }
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray = ExcelDataAnalysis.readExcel(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取数据，打印数据
        jsonArray.stream().forEach(System.out::println);
        return null;
    }
}
