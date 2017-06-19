package com.jerem.service;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
public class JerseyConfig extends ResourceConfig {

    @Value("${spring.jersey.application-path:/api}")
    private String apiPath;

    public JerseyConfig() {
        register(Endpoint.class);
        register(LoggingFeature.class);
    }

    @PostConstruct
    public void init() {
        // Register components where DI is needed
        this.configureSwagger();
    }

    private void configureSwagger() {

        // Available at localhost:port/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);
        BeanConfig config = new BeanConfig();
        config.setConfigId("springboot-jersey-swagger-docker-example");
        config.setTitle("Spring Boot + Jersey + Swagger + Docker Example");
        config.setVersion("v1");
        config.setContact("Jerem");
        config.setSchemes(new String[] { "http", "https" });
        config.setBasePath(this.apiPath);
        config.setResourcePackage("com.jerem.service");
        config.setPrettyPrint(true);
        config.setScan(true);

    }

}
