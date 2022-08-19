package com.friedman.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.friedman.studentroster.models.Dorm;
import com.friedman.studentroster.repositories.DormRepository;

@Service
public class DormService {
	private final DormRepository dormRepository;
	
	public DormService(DormRepository dormRepository) {
		this.dormRepository = dormRepository;
	}
	public List<Dorm> allDorms() {
		return dormRepository.findAll();
	}
	public Dorm findDorm(Long id) {
		Optional<Dorm> optionalDorm = dormRepository.findById(id);
		if (optionalDorm.isPresent())	
			return optionalDorm.get();
		return null;
	}
	public Dorm createDorm(Dorm dorm) {
		Dorm optionalDorm = dormRepository.findByName(dorm.getName());
		if (optionalDorm != null)
			return null;
		return dormRepository.save(dorm);
	}
}
