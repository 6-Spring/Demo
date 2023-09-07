package com.xiaozheng.demo01.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;

/**
 * @author zyl
 * @description TODO
 * @date 2023/9/7 16:28
 */
public class ResultTUtil {
    public ResultTUtil() {
    }

    public static ResultTEntity success() {
        return success((Object)null);
    }

    public static ResultTEntity success(Object object) {
        return success("操作成功！", object);
    }

    public static ResultTEntity success(String msg, Object object) {
        ResultTEntity result = new ResultTEntity();
        result.setCode(0);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static ResultTEntity error(Integer code, String msg) {
        ResultTEntity result = new ResultTEntity();
        result.setCode(code);
        result.setMsg(msg);
        result.setData((Object)null);
        return result;
    }

    public static ResultTEntity error() {
        ResultTEntity result = new ResultTEntity();
        result.setCode(0);
        result.setMsg("失败！");
        result.setData((Object)null);
        return result;
    }

    public static ResultTEntity error(String msg) {
        ResultTEntity result = new ResultTEntity();
        result.setCode(0);
        result.setMsg(msg);
        result.setData((Object)null);
        return result;
    }

    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", new Date());
        jsonObject.put("id", "1111");
        jsonArray.add(jsonObject);
        String oldStr = JSON.toJSONString(jsonObject, new SerializerFeature[]{SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteDateUseDateFormat});
        System.out.println(oldStr);
        ResultTEntity resultTEntity = success(jsonObject);
        System.out.println(JSON.toJSONString(resultTEntity));
    }
}