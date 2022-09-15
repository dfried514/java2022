package com.friedman.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestMethod;

import com.friedman.projectmanager.models.LoginUser;
import com.friedman.projectmanager.models.Project;
import com.friedman.projectmanager.models.Task;
import com.friedman.projectmanager.models.User;
import com.friedman.projectmanager.services.ProjectService;
import com.friedman.projectmanager.services.TaskService;
import com.friedman.projectmanager.services.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired 
	ProjectService projectService;
	
	@GetMapping("/")
	public String index(Model model) {
		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "index.jsp";
	}
	 
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		List<Project> involvedProjects = projectService.allProjectsInvolving(user, userId);
		List<Project> uninvolvedProjects = projectService.allProjectsNotInvolving(user, userId);
		model.addAttribute("involvedProjects", involvedProjects);
		model.addAttribute("uninvolvedProjects", uninvolvedProjects);
		return "dashboard.jsp";
	}
	
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		return "newProject.jsp";
	}
	
	@GetMapping("/projects/{projectId}")
	public String getProject(@PathVariable("projectId") Long projectId, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		Project project = projectService.findProject(projectId);
		model.addAttribute("project", project);
		return "project.jsp";
	}
	
	@GetMapping("/projects/edit/{id}")
	public String editProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		Project project = projectService.findProject(id);
		model.addAttribute("project", project);
		return "editProject.jsp";
	}
	
	@GetMapping("/projects/tasks/{projectId}")
	public String tasks(@PathVariable("projectId") Long projectId, @ModelAttribute("task") Task task,
			Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		Project project = projectService.findProject(projectId);
		model.addAttribute("project", project);
		return "tasks.jsp";
	}
	
	@RequestMapping(value="/projects/edit/{id}", method=RequestMethod.PUT)
	public String updateProject(@PathVariable("id") Long id, 
			@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		if (result.hasErrors())
			return "editProject.jsp";
		projectService.updateProject(id, project, result);
		if (result.hasErrors())
			return "editProject.jsp";
		return "redirect:/dashboard";
		
	}
	
	@PostMapping("/projects/new")
	public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result,
			HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		if (result.hasErrors())
			return "newProject.jsp";
		projectService.createProject(project, result);
		if (result.hasErrors())
			return "newProject.jsp";
		return "redirect:/dashboard";
	}
	
	@PostMapping("/projects/tasks/{projectId}")
	public String addTaskToProject(@PathVariable("projectId") Long projectId, @Valid @ModelAttribute("task") Task task,
			BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		if (result.hasErrors())
			return "tasks.jsp";
		taskService.createTask(task);
		return "redirect:/projects/tasks/" + projectId;
	}
	
	@GetMapping("/projects/{projectId}/addUser/{userId}")
	public String addUserToProject(@PathVariable("userId") Long userId, @PathVariable("projectId") Long projectId) {
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		projectService.addUserToProject(projectId, user);
		return "redirect:/dashboard";
	}	
	
	@GetMapping("/projects/{projectId}/removeUser/{userId}")
	public String removeUserFromProject(@PathVariable("userId") Long userId, @PathVariable("projectId") Long projectId) {
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		projectService.removeUserFromProject(projectId, user);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/cancel")
	public String cancel(HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		return "redirect:/dashboard";
	}
	
	@PostMapping("/projects/delete/{projectId}")
	public String destroy(@PathVariable("projectId") Long projectId, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		projectService.deleteProject(projectId);
		return "redirect:/dashboard";
	} 
	 
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {
	     
		User user = userService.register(newUser, result);
	    if(result.hasErrors()) {
	    	// Be sure to send in the empty LoginUser before 
	        // re-rendering the page.
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    session.setAttribute("userId", user.getId());
	    return "redirect:/dashboard";
	}
	 
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
			BindingResult result, Model model, HttpSession session) {
	     
		User user = userService.login(newLogin, result);
	 
	    if(result.hasErrors() || user == null) {
	    	model.addAttribute("newUser", new User());
	    	return "index.jsp";
	    }
	 
	    // No errors! 
	    // TO-DO Later: Store their ID from the DB in session, 
	    // in other words, log them in.
	    session.setAttribute("userId", user.getId());
	    return "redirect:/dashboard";
	}
	 
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}
}
