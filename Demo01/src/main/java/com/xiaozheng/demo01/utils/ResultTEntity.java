package com.xiaozheng.demo01.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @author zyl
 * @description 通用返回实体
 * @date 2023/9/7 16:20
 */
    public class ResultTEntity<T> implements Serializable {
        private static final long serialVersionUID = -1L;
        private Integer code;
        private String msg;
        private T data;

        public ResultTEntity() {
        }

        public Integer getCode() {
            return this.code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            if (data != null) {
                if (data instanceof String) {
                    this.data = data;
                } else {
                    String tempData = JSON.toJSONString(data, new SerializerFeature[]{SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteDateUseDateFormat});
                    this.data = (T) JSON.parse(tempData);
                }
            }

        }
}


