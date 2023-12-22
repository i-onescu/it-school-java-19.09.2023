package org.bogdan.bankingsystem.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
// We can have multiple ways of injecting configurations from external sources
// another approach would be use @ConfigurationProperties with the prefix property
// By doing it you can aggregate a group of properties under a prefix
// if you use it, you must respect the property's name
@ConfigurationProperties(prefix = "banking")
public class BankingConfigurations {

    // We can inject values from the configuration files or from system variables
    // using the @Value annotation, and between the parentheses you should provide
    // the variable name within '${}'
    //@Value("${banking.url}")
    private String url;

    // Additionally, when using @ConfigurationProperties, a setter is required
    public void setUrl(String url) {
        this.url = url;
    }
}
