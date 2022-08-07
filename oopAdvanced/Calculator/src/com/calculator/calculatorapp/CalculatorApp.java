package com.calculator.calculatorapp;

import java.util.Scanner;

public class CalculatorApp {
	public CalculatorApp() {
		
	}
	public void performOperations() {
		Scanner scanner = new Scanner(System.in);
		Calculator calculator = new Calculator();
		
		System.out.println("Enter an operation ('q') to quit\n\n");
		String operation = scanner.nextLine();
		
		while (!operation.equals("q")) {
			calculator.performOperation(operation);
			
			System.out.println("Enter an operation ('q') to quit\n\n");
			operation = scanner.nextLine();
		}
		System.out.println("goodbye");
		scanner.close();
	}
}
