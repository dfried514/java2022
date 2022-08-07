package com.calculator.calculatorapp;

import java.util.regex.Pattern;

public class Calculator implements java.io.Serializable {
	static final long serialVersionUID = 0;
	
	private double operandOne;
	private double operandTwo;
	private String operationOne;
	private String operationTwo;
	private double results;
	
	public Calculator() {
		
	}

	public double getOperandOne() {
		return operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public String getOperationOne() {
		return operationOne;
	}
	public String getOperationTwo() {
		return operationTwo;
	}
	public double getResults() {
		return results;
	}
	public void setOperandOne(double operand) {
		operandOne = operand;
	}
	public void setOperandTwo(double operand) {
		operandTwo = operand;
	}
	public void setOperationOne(String operation) {
		operationOne = operation;
	}
	public void setOperationTwo(String operation) {
		operationTwo = operation;
	}
	public void setResults(double results) {
		this.results = results;
	}
	public void setResults() {
		results = operandTwo == 0
				? operandOne
				: calculateResult(operandOne, operandTwo, operationOne);
	}
	public void showResults() {
		System.out.println("results:  " + results);
	}
	public double calculateResult(double val1, double val2, String operation) {
		double res = 0;
		switch(operation) {
			case "+":	res = val1 + val2;
						break;
			case "-": 	res = val1 - val2;
						break;
			case ("*"): res = val1 * val2;
						break;
			case ("/"): res =  val1 / val2;
						break;
			default:	res = 0;
						break;
		}
		return res;
	}
	// handles number inputs
	public void handleOperand(double input) {
		if (operandOne == 0) 
			operandOne = input;
		else if (operandTwo == 0) {
			if (operationOne.equals("*") || operationOne.equals("/")) 
				operandOne = calculateResult(operandOne, input, operationOne);
			else
				operandTwo = input;
		} else
			operandTwo = calculateResult(operandTwo, input, operationTwo);
	}
	// main function for accepting input
	public void performOperation(String input) {
		String inputCur = input.trim();
		// if input is a number:
		if (Pattern.matches("^\\d+(\\.\\d+)?$", inputCur))
			handleOperand(Double.parseDouble(inputCur));
		// if input is '='
		else if (inputCur.equals("=")) {
			setResults();
			showResults();
			resetFields();
		}
		// else input is an operator
		else if (operandTwo == 0) 
			operationOne = inputCur;
		else
			operationTwo = inputCur;
		//showFields();
	}
	public void resetFields() {
		operandOne = 0;
		operandTwo = 0;
		operationOne = "";
		operationTwo = "";
		results = 0;
	}
	public void showFields() {
		System.out.println("operandOne: " + operandOne);
		System.out.println("operandTwo: " + operandTwo);
		System.out.println("operationOne: " + operationOne);
		System.out.println("operationTwo: " + operationTwo);
		System.out.println("results:  " + results);
	}
}
