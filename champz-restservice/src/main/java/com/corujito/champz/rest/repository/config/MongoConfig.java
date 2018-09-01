package com.corujito.champz.rest.repository.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {

    @Autowired
    private Environment env;

    @Bean
    public MongoDbFactory mongoDbFactory() {
        String mongoHost = env.getProperty("CHAMPZ_RESTSERVICE_MONGODB_SERVICE_SERVICE_HOST", "localhost");
        String port = env.getProperty("CHAMPZ_RESTSERVICE_MONGODB_SERVICE_SERVICE_PORT", "32356");
        String database = env.getProperty("CHAMPZ_RESTSERVICE_MONGODB_SERVICE_SERVICE_DB", "champz-prod-db");

        MongoClient mongoClient = new MongoClient(mongoHost, Integer.valueOf(port));

        return new SimpleMongoDbFactory(mongoClient, database);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
