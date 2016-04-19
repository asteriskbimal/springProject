package com.bimal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimal.model.Student;
import com.bimal.repository.StudentRepository;
import com.bimal.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void saveStudent(Student student) {

		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.delete(id);
		
	}

	@Override
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();
		
	}

}
