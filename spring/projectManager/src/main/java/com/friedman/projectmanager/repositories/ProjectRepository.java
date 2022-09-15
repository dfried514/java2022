package com.friedman.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.friedman.projectmanager.models.Project;
import com.friedman.projectmanager.models.User;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	List<Project> findAllByTeamUsersContainsOrLeadUserIdIs(User user, Long id2);
	
	List<Project> findByTeamUsersNotContainsAndLeadUserIdIsNot(User user, Long id2);
	
	Optional<Project> findById(Long id);
	
}

