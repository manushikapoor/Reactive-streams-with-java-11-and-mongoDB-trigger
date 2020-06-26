package com.connection;

import com.mongodb.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.repository.StudentRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses=StudentRepository.class)
@PropertySource("classpath:mongo.properties")
public abstract class connect extends AbstractReactiveMongoConfiguration {

	@Bean
	  public MongoClient mongoClient() {
	    return (MongoClient) MongoClients.create("mongodb://localhost:27017/student");
	  }
	  @Override
	  protected String getDatabaseName() {
	    return "student";
	  }
}

  
  