package com.corujito.champz.rest.repository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfigIT extends MongoConfig {

    @Bean
    @Profile("test")
    public MongoDbFactory mongoDbFactory() {
        String mongoHost = System.getProperty("mongo.ip", "localhost");
        String port = System.getProperty("mongo.port", "27017");
        String database = System.getProperty("mongo.db", "champz-it-db");

        MongoClient mongoClient = new MongoClient(mongoHost, Integer.valueOf(port));

        return new SimpleMongoDbFactory(mongoClient, database);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
