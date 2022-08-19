package com.friedman.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.friedman.studentroster.models.Dorm;
import com.friedman.studentroster.models.Student;
import com.friedman.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}
	public List<Student> allStudentNotInDorm(Long id) {
		return studentRepository.findByDormIdIsNullOrDormIdIsNot(id);
	}
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent())
			return optionalStudent.get();
		return null;
	}
	public Student createStudent(Student student) {
		Student optionalStudent = studentRepository.findByName(student.getName());
		if (optionalStudent != null)
			return null;
		return studentRepository.save(student);
	}
	public Student updateStudentDorm(Long id, Student student, Dorm dorm) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			student.setDorm(dorm);		
			return studentRepository.save(student);
		} else
			return null;
	}	
}
