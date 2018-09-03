package com.corujito.champz.rest.repository.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig {

    @Autowired
    private Environment env;

    @Bean
    public MongoDbFactory mongoDbFactory() {
        String mongoHost = env.getProperty("CHAMPZ_RESTSERVICE_MONGODB_SERVICE_SERVICE_HOST", "localhost");
        String port = env.getProperty("CHAMPZ_RESTSERVICE_MONGODB_SERVICE_SERVICE_PORT", "32356");

        String database = env.getProperty("CHAMPZ_RESTSERVICE_DB_NAME", "champz-prod-db");
        String user = env.getProperty("CHAMPZ_RESTSERVICE_DB_USER");
        String password = env.getProperty("CHAMPZ_RESTSERVICE_DB_PASSWORD");

        ServerAddress addr = new ServerAddress(mongoHost, Integer.valueOf(port));
        MongoClientOptions options = new MongoClientOptions.Builder().build();
        MongoCredential credential = MongoCredential.createCredential(user, database, password.toCharArray());
        MongoClient mongoClient = new MongoClient(addr, credential, options);

        return new SimpleMongoDbFactory(mongoClient, database);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
