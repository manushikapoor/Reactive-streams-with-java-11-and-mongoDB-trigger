package com;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.document.Student;
import com.repository.StudentRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootWebApplication implements CommandLineRunner {
  
  @Autowired
  StudentRepository personRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {
    
	  //personRepository.save(new Student(5,"hgRT","mittal",21,"manushikapoor@gmail.com","C"));
	  final Student johnAoe = new Student(3,"manushi","chillar",21,"manushikapoor@gmail.com","CS");
	  final Student varini = new Student(5,"hgRT","mittal",21,"manushikapoor@gmail.com","C");
////	  //MongoCollection<Document> gradesCollection = Student.getCollection("student
	  
	  
	  personRepository.saveAll(Flux.just(johnAoe, varini)).subscribe();
////      //personRepository.insert(personRepository);
////      //personRepository.findByDepartment("CS").log().map(Student::getFirstname).subscribe(System.out::println);
    personRepository.findAll().log().map(Student::getFirstname).subscribe(System.out::println);
//    
   
  }
}