package com.vzs.mysampleproject.configuration.cassandra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class VzsCassandraConfig extends AbstractCassandraConfiguration {
    private final VzsCassandraProperties vzsCassandraProperties;

    /*
     * Provide a contact point to the configuration.
     */
    @Override
    public String getContactPoints() {
        return vzsCassandraProperties.getContactPoints();
    }

    @Override
    protected String getKeyspaceName() {
        return vzsCassandraProperties.getKeyspaceName();
    }

    @Override
    protected int getPort() {
        return vzsCassandraProperties.getPort();
    }
}
