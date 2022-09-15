package com.friedman.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friedman.projectmanager.models.Task;
import com.friedman.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;
	
	public List<Task> allTasks() {
		return taskRepo.findAll();
	}
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}	
}

