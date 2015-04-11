package org.kashpersky.scuttle.config.data;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
//@EnableMongoRepositories
@PropertySource("classpath:/data-config.properties")
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${mongo.db.name}")
    private String databaseName;

    @Value("${mongo.db.host}")
    private String databaseHost;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(databaseHost);
    }
}
