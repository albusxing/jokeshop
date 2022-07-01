package com.albusxing.msa.showcase.health;

import com.albusxing.msa.showcase.health.ServiceHealthIndicator;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Albusxing
 * @created 2022/5/31
 */
@Component
public class ServiceHealthCheckHandler implements HealthCheckHandler {

    @Resource
    private ServiceHealthIndicator serviceHealthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        Status status = serviceHealthIndicator.health().getStatus();
        // TODO 根据 actuator的健康状态来返回给 Eureka 不同的服务状态
        if (status.equals(Status.UP)) {
            return InstanceInfo.InstanceStatus.UP;
        } else {
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
