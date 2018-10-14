package com.example.dbcache.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.dbcache.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
	