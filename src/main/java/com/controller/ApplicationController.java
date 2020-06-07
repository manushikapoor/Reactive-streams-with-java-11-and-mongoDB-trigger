package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.document.Student;
@RestController
//@RequestMapping("/student");
public class ApplicationController {
	
	@Autowired
	StudentRepository repository;
	
	@PutMapping("/student")
	public ResponseEntity<Mono<Student>> save(@RequestBody Student student){
		return ResponseEntity.ok(repository.save(student));
	}
	@GetMapping("/student/{id}")
	public Mono<Student> getById(@PathVariable("id") final int id) {
	System.out.println("::Will Return a Student::");
	return repository.findOneBy_id(id);
	}
	
//	@GetMapping("/student")
//	public ResponseEntity<Flux<Student>> hello() {
//		repository.findAll().log().map(Student::getFirstname).subscribe(System.out::println);
//		return 
//	}
}