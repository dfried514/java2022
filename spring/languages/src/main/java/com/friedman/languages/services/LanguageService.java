package com.friedman.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.friedman.languages.models.Language;
import com.friedman.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	public Language updateLanguage(Long id, Language language) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			language.setId(id);
			return languageRepository.save(language);
		} else {
			return null;
		}
	}
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
}

