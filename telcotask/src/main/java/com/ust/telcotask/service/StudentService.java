package com.ust.telcotask.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.telcotask.model.Student;
import com.ust.telcotask.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	
	public List<Student> viewAllStudent(){
		List<Student> bookList =(List<Student>) studentRepository.findAll() ;		
		return bookList;
	}
	
	public void insertStudent(Student student) {
		studentRepository.save(student);
			
	}
	
	public Student updateStudent(Student student,String id) {
		return studentRepository.save(student);
		
	}
	
	public Student findStudentById(String id) {
		return studentRepository.findById(id).get();
		
	}
	
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}

}
