package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Calculator;

import static org.junit.Assert.assertEquals;

public class CalculatorSteps {

    private int num1, num2;
    private int sum;
    private double quotient;
    private double floatNum1, floatNum2;
    private Calculator calculator = new Calculator();

    @Given("I have two integers {int} and {int}")
    public void i_have_two_integers_and(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @When("I add them")
    public void i_add_them() {
        sum = this.calculator.add(this.num1, this.num2);
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expectedSum) {
        assertEquals("Sum is incorrect", expectedSum, sum);
    }

    @Given("I enter integers {int} and {int} into the calculator")
    public void i_enter_integers_and_into_the_calculator_int(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @When("I request integer division")
    public void i_request_integer_division() {
        quotient = this.calculator.divide(num1, num2);  // String return, e.g., "5" or "Cannot divide by zero"
    }

    @Then("I should get the result {double}")
    public void i_should_get_the_result(double expected) {
        assertEquals(expected, quotient, 0);
    }

    @Then("I should get the error message {string}")
    public void i_should_get_the_error_message(String expectedMessage) {
        assertEquals(expectedMessage, quotient + "");
    }

    @Given("I enter floats {double} and {double} into the calculator")
    public void i_enter_floats_and_into_the_calculator_float(double num1, double num2) {
        this.floatNum1 = num1;
        this.floatNum2 = num2;
    }

    @When("I request float division")
    public void i_request_float_division() {
        quotient = this.calculator.divide(floatNum1, floatNum2); // Returns a String like "3.5" or "Cannot divide by zero"
    }

    @Then("I should get the float result {double}")
    public void i_should_get_the_float_result(double expected) {
        assertEquals(expected, quotient, 0);
    }
}
