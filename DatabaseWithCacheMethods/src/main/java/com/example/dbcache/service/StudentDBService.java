package com.example.dbcache.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dbcache.entity.Student;
import com.example.dbcache.repository.StudentRepository;

@Service
public class StudentDBService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Cacheable(value="studentsDBCache", key="#studentId")
	public Optional<Student> getStudentById(Integer studentId)
	{
		return studentRepository.findById(studentId);
	}
	
	@Cacheable(value="studentsDBCache", key="#studentId")
	public void deleteStudentById(Integer studentId)
	{
		return studentRepository.deleteById(studentId);
	}
	
	@CachePut(value="studentsDBCache", key="#studentId")
	public Student updateStudent(Integer studentId, String newEmail)
	{
		Student updateStudent = null;
		Optional<Student> studentFromDB = studentRepository.findById(studentId);
		
		if(studentFromDB != null)
		{
			studentFromDB.get().setEmail(newEmail);
			updateStudent = studentRepository.save(studentFromDB);
		}
		
		return updateStudent;
	}
}
