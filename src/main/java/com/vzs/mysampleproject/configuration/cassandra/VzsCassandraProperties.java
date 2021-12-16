package com.vzs.mysampleproject.configuration.cassandra;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("vzs.cassandra")
public class VzsCassandraProperties {
    private String keyspaceName;
    private int port;
    private String contactPoints;
}
