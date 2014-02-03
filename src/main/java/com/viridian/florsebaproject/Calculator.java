package com.viridian.florsebaproject;

public class Calculator {

	private Double digitA;
	
	private Double digitB;
	
	private Double currentState;
	
	public Calculator() {
		this.digitA = null;
		this.digitB = null;
		this.currentState = new Double(0);
	}
	
	public Double add() {
		this.setCurrentState(digitA+digitB);
		return this.getCurrentState();
	}
	
	public Double substract() {
		this.setCurrentState(digitA-digitB);
		return this.getCurrentState();
	}
	
	public Double multiply() {
		this.setCurrentState(digitA*digitB);
		return this.getCurrentState();
	}
	
	public Double divide() {
		this.setCurrentState(digitA/digitB);
		return this.getCurrentState();
	}

	public Double getDigitA() {
		return digitA;
	}

	public void setDigitA(Double aDigit) {
		this.digitA = aDigit;
	}

	public Double getDigitB() {
		return digitB;
	}

	public void setDigitB(Double bDigit) {
		this.digitB = bDigit;
	}
	
	public void setDigit(Double digit) {
		if (this.getDigitA()==null) {
			this.setDigitA(digit);
		}
		else {
			if (this.getDigitB()==null) {
				this.setDigitB(digit);
			}
		}
		
	}

	public Double getCurrentState() {
		return currentState;
	}

	public void setCurrentState(Double currentState) {
		this.currentState = currentState;
	}
}
