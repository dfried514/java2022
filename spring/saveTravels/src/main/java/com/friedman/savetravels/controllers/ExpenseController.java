package com.friedman.savetravels.controllers;

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

import com.friedman.savetravels.models.Expense;
import com.friedman.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);	
		return "index.jsp";
	}
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	@PostMapping("/expenses/update/{id}")
	public String update(@PathVariable("id") Long id, 
			@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(id, expense);
			return "redirect:/expenses";
		}
	}	
	@PostMapping("/expenses/create")
	public String processForm(Model model, @Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);	
			return "redirect:/expenses";
		}
	}
	@PostMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
