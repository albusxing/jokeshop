package com.albusxing.msa.showcase.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author Albusxing
 * @created 2022/5/31
 */
@Component
public class ServiceHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // TODO 根据业务规则返回UP或者DOWN来指示服务的状态
        builder.up().withDetail("status", true);
        builder.down().withDetail("status", false);
    }
}
