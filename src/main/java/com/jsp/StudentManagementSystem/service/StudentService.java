package com.jsp.StudentManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.StudentManagementSystem.dao.StudentDao;
import com.jsp.StudentManagementSystem.dto.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	public Student getByIdStudent(int id) {
		return studentDao.getByIdStudent(id);
	}

	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
	}

}
