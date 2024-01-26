package com.xiaozheng.demo01;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


import java.util.*;

public class haha {
    public static void main(String[] args) throws JSONException {

        String json = "{\"states\":{\"rect1\":{\"type\":\"start\",\"text\":{\"text\":\"开始\",\"fill\":\"#02BABC\"},\"attr\":{\"x\":295,\"y\":193,\"width\":62,\"height\":26,\"fill\":\"#E7F5F5\"},\"props\":{\"text\":{\"value\":\"开始\"}}},\"rect2\":{\"type\":\"task\",\"text\":{\"text\":\"新建规则集-1.0\",\"fill\":\"#1B4485\"},\"attr\":{\"x\":434,\"y\":210,\"width\":146,\"height\":26,\"fill\":\"#D6E1F3\"},\"props\":{\"isPublic\":{\"value\":\"1\"},\"ruleSetId\":{\"value\":\"2c9093f58a3b4e03018a456aa44b0028\"},\"text\":{\"value\":\"新建规则集-1.0\"},\"action\":{\"value\":[{\"actRuleName\":\"78990\",\"LHS\":{\"union\":\"or\",\"condition\":[\"{\\\"varId\\\":\\\"[2c9093f58a3b4e03018a3f2c62e10007]\\\",\\\"opt\\\":\\\">\\\",\\\"valueType\\\":\\\"t_value\\\",\\\"value\\\":\\\"7\\\"}\",\"{\\\"varId\\\":\\\"[2c9093f58a3b4e03018a3f2bef720005]\\\",\\\"opt\\\":\\\">\\\",\\\"valueType\\\":\\\"t_value\\\",\\\"value\\\":\\\"8\\\"}\"]},\"LHSTxt\":[\"hx输出参数0829 大于 7\",\"hx参数0829 大于 8\"],\"RHS\":[\"{\\\"varId\\\":\\\"[2c9093f58a3b4e03018a3f2c62e10007]\\\",\\\"opt\\\":\\\"=\\\",\\\"valueType\\\":\\\"t_value\\\",\\\"value\\\":\\\"8\\\"}\"],\"RHSTxt\":[\"hx输出参数0829 等于 8\"],\"uid\":1693381653498,\"isEndAction\":false,\"isEndFlow\":false},{\"actRuleName\":\"2\",\"LHS\":{\"union\":\"or\",\"condition\":[\"{\\\"varId\\\":\\\"[2c9093f58a3b4e03018a3f2c62e10007]\\\",\\\"opt\\\":\\\">\\\",\\\"valueType\\\":\\\"t_value\\\",\\\"value\\\":\\\"13\\\"}\"]},\"LHSTxt\":[\"hx输出参数0829 大于 13\"],\"RHS\":[\"{\\\"varId\\\":\\\"[2c9093f58a3b4e03018a3f2c62e10007]\\\",\\\"opt\\\":\\\"=\\\",\\\"valueType\\\":\\\"t_value\\\",\\\"value\\\":\\\"12\\\"}\"],\"RHSTxt\":[\"hx输出参数0829 等于 12\"],\"uid\":1693381684647,\"isEndAction\":false,\"isEndFlow\":false}]}}},\"rect3\":{\"type\":\"end\",\"text\":{\"text\":\"结束\",\"fill\":\"#CE2C2C\"},\"attr\":{\"x\":675,\"y\":338,\"width\":62,\"height\":26,\"fill\":\"#FCE0E0\"},\"props\":{\"text\":{\"value\":\"结束\"}}},\"rect4\":{\"type\":\"task\",\"text\":{\"text\":\"规则集\",\"fill\":\"#1B4485\"},\"attr\":{\"x\":431,\"y\":357,\"width\":70,\"height\":26,\"fill\":\"#D6E1F3\"},\"props\":{\"isPublic\":{\"value\":\"-1\"},\"ruleSetId\":{\"value\":\"\"},\"text\":{\"value\":\"规则集\"},\"action\":{\"value\":[{\"actRuleName\":\"aaaaa\",\"LHS\":{\"union\":\"or\",\"condition\":[\"{\\\"varId\\\":\\\"[2c9093f58a3b4e03018a3f2c62e10007]\\\",\\\"opt\\\":\\\"<\\\",\\\"valueType\\\":\\\"t_value\\\",\\\"value\\\":\\\"3\\\"}\",\"{\\\"varId\\\":\\\"[2c9093f58a3b4e03018a3f2c62e10007]\\\",\\\"opt\\\":\\\"==\\\",\\\"valueType\\\":\\\"t_value\\\",\\\"value\\\":\\\"2\\\"}\"]},\"LHSTxt\":[\"hx输出参数0829 小于 3\",\"hx输出参数0829 等于 2\"],\"RHS\":[\"{\\\"varId\\\":\\\"[2c9093f58a3b4e03018a3f2c62e10007]\\\",\\\"opt\\\":\\\"=\\\",\\\"valueType\\\":\\\"t_value\\\",\\\"value\\\":\\\"2\\\"}\"],\"RHSTxt\":[\"hx输出参数0829 等于 2\"],\"uid\":1695695755705,\"isEndAction\":false,\"isEndFlow\":false}]}}},\"rect5\":{\"type\":\"interface\",\"text\":{\"text\":\"接口\",\"fill\":\"#EB6813\"},\"attr\":{\"x\":286,\"y\":374,\"width\":70,\"height\":26,\"fill\":\"#F9E4D7\"},\"props\":{\"text\":{\"value\":\"接口\"},\"ointerface\":{\"value\":\"\"}}}},\"paths\":{},\"props\":{\"pkgId\":\"00000\",\"id\":\"00000\",\"props\":{\"text\":{\"value\":\"新建规则\"}}},\"svgWidth\":2000,\"svgHeight\":1800}";
        JSONObject jsonObject = new JSONObject(json);
        JSONObject states = jsonObject.getJSONObject("states");

        // 遍历states，找到type为task的节点，并获取其text值

        List<Map> list = new ArrayList<>();

        JSONArray stateKeys = states.names();
        for (int i = 0; i < stateKeys.length(); i++) {
            Map<String, String> taskNodes = new HashMap<>();
            String key = stateKeys.getString(i);
            JSONObject node = states.getJSONObject(key);
            if (node.getString("type").equals("task")) {
                String nodeName = key;
                String nodeText = node.getJSONObject("text").getString("text");
                taskNodes.put(nodeName, nodeText);
            }
            if (!taskNodes.isEmpty()){
                list.add(taskNodes);
            }
        }

        // 打印结果
        list.forEach(System.out::println);


    }
}