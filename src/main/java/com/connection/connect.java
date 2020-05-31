package com.connection;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages="com.repository")
@PropertySource("classpath:mongo.properties")
public abstract class connect extends AbstractReactiveMongoConfiguration {
	
	@Bean
	  public MongoClient mongoClient() {
	    return (MongoClient) MongoClients.create();
	  }
	  @Override
	  protected String getDatabaseName() {
	    return "student";
	  }
	  @Bean
	  public ReactiveMongoTemplate reactiveMongoTemplate() {
	    return new ReactiveMongoTemplate((com.mongodb.reactivestreams.client.MongoClient) mongoClient(), getDatabaseName());
	  }
}