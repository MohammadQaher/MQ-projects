package com.app;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

@ManagedBean(name = "mbCalc")
@ViewScoped
public class ManagedBeanCalculator {
	
	private String result;
	private double tmp;
	private String operation;
	//2+
	
	//--------------------------------------------
	//Initializing the page with result equals to nothing.
	@PostConstruct
	public void init() {
		result = "";
	}
	
	//--------------------------------------------
	//Adding numbers or '.' to the text field
	public void addNumber(String digit) {
		result += digit;
	}

	//--------------------------------------------
	//Operations ( + , - , * , / )
	// Add the current value of the text field then reset
	// it to process the next value
	public void addOperation(String operation) {
		tmp = Double.parseDouble(result);
		this.operation = operation;
		result = "";
	}
	
	//--------------------------------------------
	//Backspace (remove a number)
	public void clear() {
		result = result.substring(0, result.length() - 1);
	}
	
	//--------------------------------------------
	//Calculations (add, subtract, division, multiplication)
	public void calculate() {
		double value = Double.parseDouble(result);

		if("+".equals(operation)) {
			result = "" + (tmp + value);
		} else if("-".equals(operation)) {
			result = "" + (tmp - value);
		} else if("/".equals(operation)) {
			result = "" + (tmp / value);
		} else if("*".equals(operation)) {
			result = "" + (tmp * value);
		}
	}
	
	//--------------------------------------------
	//getters and setters 
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}	
}
