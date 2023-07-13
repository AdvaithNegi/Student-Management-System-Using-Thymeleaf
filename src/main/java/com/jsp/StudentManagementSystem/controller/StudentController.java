package com.jsp.StudentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jsp.StudentManagementSystem.dto.Student;
import com.jsp.StudentManagementSystem.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "addstudent";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/update/{id}")
	public String updateStudent(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.getByIdStudent(id));
		return "updatestudent";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
		Student student2 = studentService.getByIdStudent(id);

		if (student.getFirst_name() != null)
			student2.setFirst_name(student.getFirst_name());

		if (student.getLast_name() != null)
			student2.setLast_name(student.getLast_name());

		if (student.getEmail() != null)
			student2.setEmail(student.getEmail());

		studentService.updateStudent(student2);
		return "redirect:/students";

	}

	@GetMapping("students/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}

}
