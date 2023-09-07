package com.xiaozheng.demo01.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class Json {
    public static void main(String[] args) throws IOException {
        String jsonFilePath = "C:\\Users\\23925\\Desktop\\json.json"; // 替换为实际文件路径

        // 读取JSON文件内容
        String jsonData = new String(Files.readAllBytes(Paths.get(jsonFilePath)), StandardCharsets.UTF_8);

        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 解析JSON数据
        JsonNode rootNode = objectMapper.readTree(jsonData);

        // 获取groupList节点
        JsonNode groupListNode = rootNode.path("groupList");

        // 遍历groupList节点下的JSON对象，查找name等于"治理信息"的对象
        if (groupListNode.isArray()) {
            for (JsonNode group : groupListNode) {
                if (group.path("name").asText().equals("治理信息")) {
                    // 在找到"治理信息"的对象后，查找tags下label等于"表英文名"的JSON对象
                    JsonNode tagsNode = group.path("tags");
                    if (tagsNode.isArray()) {
                        for (JsonNode tag : tagsNode) {
                            if (tag.path("label").asText().equals("表英文名")) {
                                // 获取tags下的value的值
                                String value = tag.path("value").asText();
                                System.out.println("表英文名的值为: " + value);
                            }
                        }
                    }
                }
            }
        }
    }
}
