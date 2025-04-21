package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.NumberParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class NumberParserSteps {

    private String input;
    private NumberParser parser = new NumberParser();
    private Integer result;

    @Given("the input is {string}")
    public void the_input_is(String input) {
        this.input = input;
    }

    @Given("the input is null")
    public void the_input_is_null() {
        this.input = null;
    }

    @When("I parse the input")
    public void i_parse_the_input() {
        result = parser.parse(input);
    }

    @Then("the result value should be {int}")
    public void the_result_should_be(int expectedResult) {
        assertEquals(expectedResult, (int) result);
    }

    @Then("a NumberFormatException error should occur")
    public void a_NumberFormatException_error_should_occur() {
        assertThrows(NumberFormatException.class, () -> {
            parser = new NumberParser();
            parser.parse(input);
        });
    }

    @Then("a NullPointerException error should occur")
    public void a_NullPointerException_error_should_occur() {
        assertThrows(NullPointerException.class, () -> {
            parser = new NumberParser();
            parser.parse(input);
        });
    }
}