package com.friedman.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.friedman.studentroster.models.Dorm;
import com.friedman.studentroster.models.Student;
import com.friedman.studentroster.services.DormService;
import com.friedman.studentroster.services.StudentService;

@Controller
public class MainController {

		@Autowired
		DormService dormService;
		
		@Autowired
		StudentService studentService;
		
		@GetMapping("/dorms")
		public String dorms(Model model) {
			List<Dorm> dorms = dormService.allDorms();
			model.addAttribute("dorms", dorms);
			return "dorms.jsp";
		}
		@GetMapping("/dorms/new") 
		public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
			return "newDorm.jsp";
		}
		@GetMapping("/dorms/{id}")
		public String getDorm(@PathVariable("id") Long id, Model model) {
			Dorm dorm = dormService.findDorm(id);
			List<Student> students = studentService.allStudentNotInDorm(id);
			model.addAttribute("dorm", dorm);
			model.addAttribute("students", students);
			return "dorm.jsp";
		}
		@GetMapping("/students/new")
		public String newStudent(Model model, @ModelAttribute("student") Student student) {
			List<Dorm> dorms = dormService.allDorms();
			model.addAttribute("dorms", dorms);
			return "newStudent.jsp";
		}
		@PostMapping("/dorms/new")
		public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
			if (result.hasErrors())
				return "newDorm.jsp";
			dormService.createDorm(dorm);
			return "redirect:/dorms";
		}
		@PostMapping("/students/new")
		public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
			if (result.hasErrors())
				return "newStudent.jsp";
			studentService.createStudent(student);
			return "redirect:/dorms";
		}	
		@PostMapping("dorms/addStudent/{dormId}")
		public String addStudentToDorm(@PathVariable("dormId") Long dormId, @RequestParam("studentId") Long studentId) {
			Dorm dorm = dormService.findDorm(dormId);
			Student student = studentService.findStudent(studentId);
			studentService.updateStudentDorm(studentId, student, dorm);
			return "redirect:/dorms/" + dormId;
		}
		@RequestMapping("/dorms/removeStudent/{dormId}/{studentId}")
		public String removeStudentFromDorm(@PathVariable("dormId") Long dormId, @PathVariable("studentId") Long studentId) {
			Student student = studentService.findStudent(studentId);
			studentService.updateStudentDorm(studentId, student, null);
			return "redirect:/dorms/" + dormId;
		}
}
