package calculator;

public class Calculator {
	public float reverse(int a) {
//		Throws exception if division by zero happens.
		if (a == 0)
			throw new ArithmeticException();

		return (float) (1.0 / a);

	}

	public float square(int a) {
//		Throws exception if the input is negative.
		if (a < 0)
			throw new ArithmeticException();

		return (float) Math.sqrt(a);
	}
}
