package is.julia.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testSingleNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testAnotherSingleNumber() {
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testAnotherTwoNumbers() {
		assertEquals(4, Calculator.add("0,4"));
	}

	@Test
	public void testThreeNumbers() {
		assertEquals(6, Calculator.add("3,2,1"));
	}

	@Test
	public void testSixNumbers() {
		assertEquals(6, Calculator.add("1,1,1,1,1,1"));
	}

	@Test
	public void testTenNumbers() {
		assertEquals(11, Calculator.add("1,1,1,1,1,1,1,1,1,2"));
	}

	@Test
	public void testNewlineChar() {
		assertEquals(3, Calculator.add("1,\n2"));
	}

	@Test
	public void testNewlineCharMore() {
		assertEquals(3, Calculator.add("1,\n1,\n1"));
	}
}
