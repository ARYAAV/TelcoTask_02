package com.ust.telcotask.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.telcotask.model.Student;
import com.ust.telcotask.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	// List view of all student
	@ResponseBody 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Student> viewAllStudents () throws ParseException{
		List<Student> studentList = studentService.viewAllStudent();
		return studentList;
	}
	
	
	// insert new student
	@ResponseBody 
	@RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
	public void insertStudent(@RequestBody Student student) throws ParseException{
		studentService.insertStudent(student);
	}
	
	
	// update student by id
	@ResponseBody 
	@RequestMapping(value = "/updateStudent/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	public List<Student> updateStudent(@RequestBody Student student, @PathVariable("id") String id)
			throws ParseException{
		studentService.updateStudent(student, id);
		List<Student> studentList = studentService.viewAllStudent();		
		return studentList;
	}
	
	
	// find student by id
	@ResponseBody 
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public Student findbyId( @PathVariable("id") String id)throws ParseException {
		Student student = studentService.findStudentById(id);
		return student;
	}
	
	
	// delete student by id
	@ResponseBody 
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void deleteStudentByid( @PathVariable("id") String id)
			throws ParseException {
		studentService.deleteStudent(id);
	}
	
}
