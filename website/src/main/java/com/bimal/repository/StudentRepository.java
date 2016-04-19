package com.bimal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bimal.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}












