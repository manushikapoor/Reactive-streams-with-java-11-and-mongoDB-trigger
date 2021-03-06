package com.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;

import com.document.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends ReactiveMongoRepository < Student, String > {
    Flux < Student > findByDepartment(final String department);
    Mono < Student> findOneBy_id(final int _id);
    
    @Tailable
    Flux<Student> findWithTailableCursorBy();
	
}