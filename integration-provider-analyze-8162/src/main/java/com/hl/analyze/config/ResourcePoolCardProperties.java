package com.hl.analyze.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author ForteScarlet
 */
@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "cards")
public class ResourcePoolCardProperties {

    private ResourcePoolCardProperty heavyLoad;
    private ResourcePoolCardProperty customerNeeds;

    private Map<String, Double[]> coordinates;

    /**
     * 一个中心点的申请ID，周围轻空载点位ID。
     */
    @Data
    public static class ResourcePoolCardProperty {
        private String center;
        private List<String> lightLoads;
    }
}
