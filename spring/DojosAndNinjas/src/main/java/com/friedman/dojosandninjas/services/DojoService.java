package com.friedman.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.friedman.dojosandninjas.models.Dojo;
import com.friedman.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent())
			return optionalDojo.get();
		return null;
	}
	public Dojo createDojo(Dojo dojo) {
		Dojo optionalDojo = dojoRepository.findByLocation(dojo.getLocation());
		if (optionalDojo != null)
			return null;
		return dojoRepository.save(dojo);
	}
}
