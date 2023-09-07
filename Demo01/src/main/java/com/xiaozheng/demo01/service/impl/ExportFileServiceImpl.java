package com.xiaozheng.demo01.service.impl;

import com.xiaozheng.demo01.service.ExportFileService;
import com.xiaozheng.demo01.utils.ExcelUtilsZeus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyl
 * @description TODO
 * @date 2023/9/7 15:07
 */
@Service
public class ExportFileServiceImpl implements ExportFileService {
    @Override
    public void exportFile(HttpServletResponse response) {

        ArrayList<Map<String, Object>> list = ExportFileServiceImpl.getList();
        String[] lables = new String[]{"姓名", "性别", "年龄", "是否傻逼"};
        String[] fileds = new String[]{"name", "sex", "age", "sb"};
        String fileName = "zyl.xlsx";

        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException var48) {
            var48.printStackTrace();
        }
        ExcelUtilsZeus.exportTest(response, list, lables, fileds, fileName);


    }



    // 模拟数据
    public static ArrayList<Map<String, Object>> getList(){
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (int i = 18; i < 23; i++) {
            Map map = new HashMap();
            map.put("age",i);
            map.put("name","郭吉孟");
            map.put("sex","女");
            map.put("sb","是");
            list.add(map);
        }
        return list;
    }
}
