package lab2;

import org.junit.Assert;
import org.junit.Test;

public class EquationTests extends Assert{

    EquationTest equation = new EquationTest();
    private static final double delta = 0.001;

    @Test
    public void TestMinus100Value() { checkEquationResult(-100, 0.032676475); }

    @Test
    public void TestMinus10Value() { checkEquationResult(-10, 6.631422271); }

    @Test
    public void TestMinus3Value() { checkEquationResult(-3, 4.22912101); }

    @Test
    public void TestMinus1Value() { checkEquationResult(-1, 65.3224311); }

    @Test
    public void Test2Value() { checkEquationResult(2, 1.73932537); }

    @Test
    public void Test3Value() { checkEquationResult(3, -0.1110845); }

    @Test
    public void Test7Value() { checkEquationResult(7, -1.7784281); }

    @Test
    public void Test10Value() { checkEquationResult(10, -2.212446); }

    private void checkEquationResult(double x, double expectedValue){
        double actualValue = equation.Calculate(x);
        assertEquals(assertMessage(expectedValue, actualValue, delta, true), expectedValue , actualValue, delta);
    }

    private String assertMessage(double expected, double actual, double delta, boolean equal) {
        return "Expected: " + expected + " is assumed to be " + (equal ? "" : "not") + "equal to Actual: " + actual + " with Delta: " + delta;
    }


}
