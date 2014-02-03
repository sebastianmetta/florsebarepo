package com.viridian.florsebaproject;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.viridian.florsebaproject.Calculator;

public class CalculatorSteps {

	private Calculator calculator = new Calculator();
	
	@Given("^I have entered (\\d+) as first digit into the calculator$")
    public void enterDigit(int digit) {
		this.getCalculator().setDigit(new Double(digit));
	}

	@And("^I have entered (\\d+) as second digit into the calculator$")
	public void enterOtherDigit(int digit) {
		this.getCalculator().setDigit(new Double(digit));
	}
	
	@When("^I press add$")
	public void sumDigits() {
		this.getCalculator().add();
	}
	
	@Then("^The result should be (\\d+)$")
	public void validateSum(int sumResult) {
		Double toCompare = new Double(sumResult);
		assertTrue(toCompare.equals(this.getCalculator().getCurrentState()));
	}
	
	protected Calculator getCalculator() {
		return this.calculator;
	}
	
}
