Feature: Calculator Addition

Scenario: add two numbers

	Given I have entered 5 into the calculator
	And I have entered 7 into the calculator
	When I press add
	Then The result should be 12
		