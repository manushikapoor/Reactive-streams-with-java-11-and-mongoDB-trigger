package com.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repository.StudentRepository;

import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.document.Student;

@RestController
@Api(value="Students", description="Operations for students of Universities.")
public class ApplicationController {
	
	@Autowired
	StudentRepository repository;
	
	@PostMapping("/student/saveOne")
	public Mono<Student> saveOne(@RequestParam(value="id") int id,@RequestParam(value="firstName") String firstname,@RequestParam(value="lastName") String lastname,@RequestParam(value="age") int age,@RequestParam(value="email") String email,@RequestParam(value="department") String department){
		Student student=new Student(id,firstname,lastname,age,email,department);
		System.out.println("::Saving a Student::");
		return repository.save(student);
	}
	
	@GetMapping("/student/id/{id}")
	public Mono<Student> getOneById(@PathVariable("id") final int id) {
	System.out.println("::Will Return a Student::");
	return repository.findOneBy_id(id);
	}
	
	@GetMapping(value="/student/showall",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Student> getByTailing(){
		System.out.println("::Will Return All the Students in real time::");
        return repository.findWithTailableCursorBy().delayElements(Duration.ofSeconds(1));
	}
	
	@GetMapping("/student/department/{department}")
	public Flux<Student> getByDepartment(@PathVariable("department") final String department) {
		System.out.println("::Will Return Students filtered by department::");
		return repository.findByDepartment(department);
	}
	
	@PostMapping("/student/saveMany")
	Flux<Student> saveMany(@RequestBody() final List<Student> student){
		System.out.println("::Will Save Multiple Students::");
		return repository.saveAll(student);
	}
    
}
