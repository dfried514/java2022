package com.friedman.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.friedman.savetravels.models.Expense;
import com.friedman.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	public Expense updateExpense(Long id, String name, String vendor, Double amount, String description) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			Expense expense = new Expense(name, vendor, amount, description);
			expense.setId(id);
			return expenseRepository.save(expense);
		} else {
			return null;
		}
	}
	public Expense updateExpense(Long id, Expense expense) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			expense.setId(id);
			return expenseRepository.save(expense);
		} else {
			return null;
		}
	}
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
