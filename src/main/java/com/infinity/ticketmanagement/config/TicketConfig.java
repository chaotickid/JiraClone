package com.infinity.ticketmanagement.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "couchbase-doc-maintainer.ticket-management.ticket-resource")
public class TicketConfig {

    private String classIdValue;

    private String initialValue;

}