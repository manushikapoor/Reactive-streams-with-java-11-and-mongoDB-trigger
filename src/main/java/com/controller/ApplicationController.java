package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PutMapping("/student/{id}/{firstname}/{lastname}/{age}/{email}/{department}")
	public Mono<Student> save(@PathVariable("id") final int id,@PathVariable("firstname") final String firstname,@PathVariable("lastname") final String lastname,@PathVariable("age") final int age,@PathVariable("email") final String email,@PathVariable("department") final String department){
		Student student=new Student(id,firstname,lastname,age,email,department);
		return repository.save(student);
	}
	
	@GetMapping("/student/{id}")
	public Mono<Student> getById(@PathVariable("id") final int id) {
	System.out.println("::Will Return a Student::");
	return repository.findOneBy_id(id);
	}
	
	@GetMapping("/student/all")
	public Flux<Student> showAll() {
		repository.findAll().log().map(Student::getFirstname).subscribe(System.out::println);
		return repository.findAll();
	}
	
	@GetMapping("/student")
	public Flux<Student> showByDepartment(@RequestParam(value="department") String department) {
		repository.findByDepartment(department).log().map(Student::getFirstname).subscribe(System.out::println);
		return repository.findByDepartment(department);
	}
}
