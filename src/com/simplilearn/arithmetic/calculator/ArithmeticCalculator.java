package com.simplilearn.arithmetic.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ArithmeticCalculator {

	public static void main(String[] args) {
		
		String promptString = "T";
		char promptChar = promptString.charAt(0);
		while (promptChar == 'T') {
			ClearScreen();

			
	//		Define scanner to accept keyboard input
			Scanner keyInput = new Scanner(System.in);
	//		Display title
			System.out.println("The Arithmetic Calculator");
	
	//		Request first number
			System.out.print("\tEnter First Number" + "\t: ");
	//		Read and Accept input 
			double num1 = keyInput.nextDouble();
	
	//		Request operator		
			System.out.print("\tArithmetic Operator" + "\t: ");
	//		Read and Accept input
			String arithOperatorString = keyInput.next();
	// 		Convert operator string to char			
			char charArithOperator = arithOperatorString.charAt(0);
			
	//		Request second number
			System.out.print("\tEnter Second Number" + "\t: ");
	//		Read and Accept input 
			double num2 = keyInput.nextDouble();		
			
			DecimalFormat df = new DecimalFormat("#.##");
			
			//
			if (validArithmeticOperator(charArithOperator)) {
				String funcName = (getFunctionName (charArithOperator));
				double doubleResults = (getDoubleResults (num1,num2,charArithOperator));
				System.out.println("\n\t" + funcName + " results" + "\t= " + df.format(doubleResults));
				
			}else {
				System.out.println("\nInvalid operator. Valid operator are '+, -, *, /'");
			}
			System.out.print("\t\t\nT -> Try again/next,   Q -> Quit" + "\t:: ");
			promptString = keyInput.next().toUpperCase();
			promptChar = promptString.charAt(0);
		}
		System.out.print("\nGoodbye");
	}
	
	public static boolean validArithmeticOperator(char arithOperator) {
		if ((arithOperator == '+' ) ||
			(arithOperator == '-' ) ||
			(arithOperator == '*' ) ||
			(arithOperator == '/' )) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getFunctionName (char charArithOperator) {
		String funcName;
		switch (charArithOperator) {
			case '+':
				funcName = "Addition";
				break;
			case '-':
				funcName = "Subtraction";
				break;
			case '*':
				funcName = "Multiplication";
				break;
			default:
				funcName = "Division";
		}		
		return funcName;
	}
	
	public static double getDoubleResults (double num1, double num2,char charArithOperator) {
		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
		double doubleResults;
		switch (charArithOperator) {
			case '+':
				doubleResults = arithmeticCalculator.addition(num1, num2);
				break;
			case '-':
				doubleResults = arithmeticCalculator.subtraction(num1, num2);
				break;
			case '*':
				doubleResults = arithmeticCalculator.multiplication(num1, num2);
				break;
			default:
				doubleResults = arithmeticCalculator.division(num1, num2);
		}		
		return doubleResults; 
	}	
	
	
	public static Object ClearScreen() {  
		System.out.print("\033[H\033[2J"); 
		System.out.flush();  
		return null;
	}  
	
	public double addition(double num1, double num2) {
		return num1 + num2;
	}

	public double subtraction(double num1, double num2) {
		return num1 - num2;
	}

	public double multiplication(double num1, double num2) {
		return num1 * num2;
	}

	public double division(double num1, double num2) {
		return num1 / num2;
	}
	
}
