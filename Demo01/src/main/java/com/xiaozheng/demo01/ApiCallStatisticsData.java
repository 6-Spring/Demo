package com.xiaozheng.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zyl
 * @description TODO
 * @date 2023/9/18 11:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiCallStatisticsData {
    private String instanceId;
    private String tenantName;
    private String appName;
    private String appId;
    private String appDesc;
    private int cycSuccess;
    private String tenantId;
    private String serviceId;
    private String serviceName;
    private int cycTotal;
    private int cycErr;
    private int callTotal;
}
