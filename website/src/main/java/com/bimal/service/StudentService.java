package com.bimal.service;

import java.util.List;

import com.bimal.model.Student;

public interface StudentService {
	
	public void saveStudent(Student student);
	public void deleteStudent(Long id);
	public List<Student> getAllStudent();
	//public boolean update

}
