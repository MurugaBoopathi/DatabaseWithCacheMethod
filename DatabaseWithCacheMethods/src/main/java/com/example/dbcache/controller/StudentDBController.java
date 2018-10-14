package com.example.dbcache.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbcache.entity.Student;
import com.example.dbcache.service.StudentDBService;

@RestController
@RequestMapping(value = "/college/studentsdb/")
public class StudentDBController {

	@Autowired
	private StudentDBService studentDBService;
	
	@GetMapping(value = "/student/{studentId}")
	public Optional<Student> getStudentById(@PathVariable("studentId") Integer studentId)
	{
		return studentDBService.getStudentById(studentId);
	}
	
	@DeleteMapping(value="/student/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Integer studentId)
	{
		studentDBService.deleteStudentById(studentId);
	}
	
	@PutMapping(value="/student/{studentId}/{newEmailL.+}")
	public Student updateStudent(@PathVariable("studentId") Integer studentId, @PathVariable("newEmail") String newEmail)
	{
		return studentDBService.updateStudent(studentId, newEmail);
	}
	
}
