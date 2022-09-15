package com.friedman.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.friedman.projectmanager.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

	List<Task> findAll();
}
