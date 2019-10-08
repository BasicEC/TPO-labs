package lab2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

import static java.lang.Double.NaN;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class LogTest extends Assert {
    private static final double delta = 0.001;

    @Parameter
    public IMathFunc myFunc;

    @Parameter(1)
    public IMathFunc expectedFunc;

    @Parameters
    public static Collection<Object[]> TestData() {
        IMathFunc myLn = (x) -> MyMath.ln(x, delta);
        IMathFunc expectLn = Math::log;

        IMathFunc myLog10 = (x) -> MyMath.log10(x, delta);
        IMathFunc expectLog10 = Math::log10;

        IMathFunc myLog5 = (x) -> MyMath.log5(x, delta);
        IMathFunc expectLog5 = (x) -> Math.log(x) / Math.log(5);

        IMathFunc myLog3 = (x) -> MyMath.log3(x, delta);
        IMathFunc expectLog3 = (x) -> Math.log(x) / Math.log(3);

        IMathFunc myLog2 = (x) -> MyMath.log2(x, delta);
        IMathFunc expectLog2 = (x) -> Math.log(x) / Math.log(2);

        Object[][] data = new Object[][]{{myLn, expectLn}, {myLog10, expectLog10}, {myLog5, expectLog5}, {myLog3, expectLog3}, {myLog2, expectLog2}};
        return Arrays.asList(data);
    }

    @Test
    public void TestEValue() { testFunction(Math.E); }

    @Test
    public void Test56PiValue() { testFunction(Math.PI * 5 / 6); }

    @Test
    public void Test23PiValue() { testFunction(Math.PI * 2 / 3); }

    @Test
    public void Test12PiValue() { testFunction(Math.PI / 2); }

    @Test
    public void Test13PiValue() { testFunction(Math.PI / 3); }

    @Test
    public void Test16PiValue() { testFunction(Math.PI / 6); }

    @Test
    public void Test0Value() { testFunction(0); }

    @Test
    public void TestMinus16PiValue() { testFunction(-1 * Math.PI / 6); }

    @Test
    public void TestMinus13PiValue() { testFunction(-1 * Math.PI / 3); }

    @Test
    public void TestMinus12PiValue() { testFunction(-1 * Math.PI / 2); }

    @Test
    public void TestMinus23PiValue() { testFunction(-1 * Math.PI * 2 / 3); }

    @Test
    public void TestMinus56PiValue() { testFunction(-1 * Math.PI * 5 / 6); }

    @Test
    public void TestMinusPiValue() { testFunction(-1 * Math.PI); }

    @Test
    public void Test10Value() { testFunction(10); }

    @Test
    public void Test100Value() { testFunction(100); }

    @Test
    public void Test1000Value() { testFunction(1000); }

    @Test
    public void TestMinus10Value() { testFunction(-10); }

    @Test
    public void TestMinus100Value() { testFunction(-100); }

    @Test
    public void TestMinus1000Value() { testFunction(-1000); }

    @Test
    public void Test001Value() { testFunction(0.001); }

    @Test
    public void TestNaNValue() { testFunction(NaN); }

    private void testFunction(double testValue){
        double expected = expectedFunc.func(testValue);
        double actual = myFunc.func(testValue);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    private String assertMessage(double expected, double actual, double delta, boolean equal) {
        return "Expected: " + expected + " is assumed to be " + (equal ? "" : "not") + "equal to Actual: " + actual + " with Delta: " + delta + " difference: " + (expected - actual);
    }
}
