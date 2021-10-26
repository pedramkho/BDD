package calculator;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
	private Calculator calculator;
	private int input;
	private String operation;
	private float result;
	private boolean division_by_zero;
	private boolean negative_square_root;

	@Before
	public void before() {
		calculator = new Calculator();
		division_by_zero = false;
		negative_square_root = false;

	}

	@Given("^Input value (-?\\d+), and the operation \"([^\"]*)\"$")
	public void twoInputValuesAnd(int arg0, String arg1) {
		input = arg0;
		operation = arg1;
	}

	@When("^I do operation$")
	public void iAddTheTwoValues() {
		if (operation.equals("rvs")) {

			try {
				result = calculator.reverse(input);
			} catch (ArithmeticException exception) {
				division_by_zero = true;
			}
		}

		if (operation.equals("sqr")) {
			try {
				result = calculator.square(input);
			} catch (ArithmeticException exception) {
				negative_square_root = true;
			}

		}
	}


	@Then("^I expect exception, division by zero$")
	public void iExpectExceptionDivbyZero() {
		Assert.assertTrue(division_by_zero);
	}

	@Then("^I expect exception, negative square root$")
	public void iExpectExceptionNegSqrt() {
		Assert.assertTrue(negative_square_root);
	}

	@Then("^I expect the result (-?\\d+(?:\\.\\d+)?)$")
	public void iExpectTheResult(double arg0) {
		Assert.assertEquals(arg0, result, 0.00001);
	}

}
