package com.friedman.projectmanager.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.friedman.projectmanager.models.Project;
import com.friedman.projectmanager.models.User;
import com.friedman.projectmanager.repositories.ProjectRepository;


@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;
	
	public List<Project> allProjectsInvolving(User user, Long id) {
		return projectRepo.findAllByTeamUsersContainsOrLeadUserIdIs(user, id);
	}
	
	public List<Project> allProjectsNotInvolving(User user, Long id) {
		return projectRepo.findByTeamUsersNotContainsAndLeadUserIdIsNot(user, id);
	}
	public Project findProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if (optionalProject.isPresent())
			return optionalProject.get();
		return null;
	}
	public Project createProject(Project project, BindingResult result) {
		LocalDate projectDueDateLocal = project.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate nowLocal =  LocalDate.now();
		
		if (projectDueDateLocal.compareTo(nowLocal) < 0) {
			result.rejectValue("dueDate", "invalid", "Due date must be in the future!");
			return null;
		}
		return projectRepo.save(project);
	}
	public Project updateProject(Long id, Project project, BindingResult result) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if (optionalProject.isPresent()) {
			LocalDate projectDueDateLocal = project.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate nowLocal =  LocalDate.now();
			
			if (projectDueDateLocal.compareTo(nowLocal) < 0) {
				result.rejectValue("dueDate", "invalid", "Due date must be in the future!");
				return null;
			}
			project.setId(id);
			return projectRepo.save(project);
		} 
		return null;
	}
	public Project addUserToProject(Long projectId, User user) {
		Optional<Project> optionalProject = projectRepo.findById(projectId);
		if (optionalProject.isPresent()) {
			List<User> teamUsers = optionalProject.get().getTeamUsers();
			if (teamUsers.contains(user))
				return null;
			teamUsers.add(user);
			return projectRepo.save(optionalProject.get());
		}
		return null;
	}
	public Project removeUserFromProject(Long projectId, User user) {
		Optional<Project> optionalProject = projectRepo.findById(projectId);
		if (optionalProject.isPresent()) {
			optionalProject.get().getTeamUsers().remove(user);
			return projectRepo.save(optionalProject.get());
		}
		return null;
	}
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}	
}
