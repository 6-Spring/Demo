package com.xiaozheng.demo01;

import com.alibaba.fastjson.JSONException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author zyl
 * @description [{\"actRuleName\":\"111\",\"isEndFlow\":false,\"rule\":\" if INPUT_INT==1 then {OUTPUT_INT=2};\",\"executeResult\":2,\"isEndAction\":false}]
 * @date 2023/11/28 9:51
 */
public class jsonparse {
    public static void main(String[] args) throws JSONException {

        String inputStr = "[{\"actRuleName\":\"111\",\"isEndFlow\":false,\"rule\":\" if INPUT_INT==1 then {OUTPUT_INT=2};\",\"executeResult\":2,\"isEndAction\":false},{\"actRuleName\":\"111\",\"isEndFlow\":false,\"rule\":\" if INPUT_INT==1 then {OUTPUT_INT=2};\",\"executeResult\":2,\"isEndAction\":false}]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStr);

            if (jsonNode.isArray()) {
                for (JsonNode item : jsonNode) {
                    System.out.println((item.get("actRuleName")));
                    System.out.println(item);
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
