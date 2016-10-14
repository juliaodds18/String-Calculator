package is.julia.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
//import org.hamcrest.Matcher;

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

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
    public void throwsIllegalArgumentExceptionMinus1() {
            thrown.expect(IllegalArgumentException.class);
            thrown.expectMessage("Negatives not allowed: -1");

            Calculator.add("-1");
     }

    @Test
    public void throwsIllegalArgumentExceptionTwoNumbers() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negatives not allowed: -2,-3");

        Calculator.add("-2,-3");
    }

     @Test
    public void throwsIllegalArgumentExceptionMoreNumbers() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negatives not allowed: -2,-3");
            
        Calculator.add("-2,-3,1,2,4");
    }

    @Test
    public void testLargeNum() {
    	assertEquals(0, Calculator.add("1001"));
    }

    @Test
    public void testLargeNums2() {
    	assertEquals(0, Calculator.add("1001,1002"));
    }
	
    @Test
    public void testLargeNumsMultiple() {
    	assertEquals(0, Calculator.add("1001,1002,4057,47165,5862,57109,18562,1057361"));
    }

    @Test
    public void testLargeNumAndSmallNum() {
    	assertEquals(1, Calculator.add("1,1002"));
    }

    @Test
    public void testLargeNumAndManySmallNums() {
    	assertEquals(5, Calculator.add("1,1,1,1,1,1002"));
    }

    @Test
    public void testManyLargeNumsAndManySmallNums() {
    	assertEquals(5, Calculator.add("1,1,1,1,1,1002,1002,4057,47165,5862,57109,18562,1057361"));
    }

    @Test
    public void testDifferentDelimiter() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
}
