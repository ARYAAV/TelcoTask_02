package com.ust.telcotask.repository;

import org.springframework.data.repository.CrudRepository;

import com.ust.telcotask.model.Student;

public interface StudentRepository extends CrudRepository<Student, String>{

}
