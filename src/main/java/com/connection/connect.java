package com.connection;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

//@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@Configuration
@EnableReactiveMongoRepositories(basePackageClasses=StudentRepository.class)
@PropertySource("classpath:mongo.properties")
public abstract class connect extends AbstractReactiveMongoConfiguration {
//	@Autowired
//	  private Environment env;
//	
	@Bean
	  public MongoClient mongoClient() {
	    return (MongoClient) MongoClients.create("mongodb://localhost:27017/student");
	  }
	  @Override
	  protected String getDatabaseName() {
	    return "student";
	  }
//	  @Bean
//	  public ReactiveMongoTemplate reactiveMongoTemplate() {
//	    return new ReactiveMongoTemplate((com.mongodb.reactivestreams.client.MongoClient) reactiveMongoClient(), getDatabaseName());
//	  }
//	  protected String getMappingBasePackage() {
//		    return "com.document";
//		  }
//	  
////	  public Mongo mongo() throws Exception {
////	    return new MongoClient(env.getProperty("spring.data.mongodb.host"), Integer.parseInt(env.getProperty("spring.data.mongodb.port")));
////	  }
//	@Override
//	public com.mongodb.reactivestreams.client.MongoClient reactiveMongoClient() {
//		// TODO Auto-generated method stub
//		return MongoClients.create("mongodb://localhost:27017/student");
//	}
}

  
  