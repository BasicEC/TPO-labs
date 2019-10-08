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
    private static final int deltaPow = 4;

    @Parameter
    public IMathFunc myFunc;

    @Parameter(1)
    public IMathFunc expectedFunc;

    @Parameters
    public static Collection<Object[]> TestData() {
        IMathFunc myLn = (x) -> MyMath.ln(x, deltaPow);
        IMathFunc expectLn = Math::log;

        Object[][] data = new Object[][]{{myLn, expectLn}};
        return Arrays.asList(data);
    }

    @Test
    public void TestEValue() {
        double value = Math.E;
        testFunction(value);
    }

    @Test
    public void Test56PiValue() {
        double value = Math.PI * 5 / 6;
        testFunction(value);
    }

    @Test
    public void Test23PiValue() {
        double value = Math.PI * 2 / 3;
        testFunction(value);
    }

    @Test
    public void Test12PiValue() {
        double value = Math.PI / 2;
        testFunction(value);
    }

    @Test
    public void Test13PiValue() {
        double value = Math.PI / 3;
        testFunction(value);
    }

    @Test
    public void Test16PiValue() {
        double value = Math.PI / 6;
        testFunction(value);
    }

    @Test
    public void Test0Value() {
        double value = 0;
        testFunction(value);
    }

    @Test
    public void TestMinus16PiValue() {
        double value = -1 * Math.PI / 6;
        testFunction(value);
    }

    @Test
    public void TestMinus13PiValue() {
        double value = -1 * Math.PI / 3;
        testFunction(value);
    }

    @Test
    public void TestMinus12PiValue() {
        double value = -1 * Math.PI / 2;
        testFunction(value);
    }

    @Test
    public void TestMinus23PiValue() {
        double value = -1 * Math.PI * 2 / 3;
        testFunction(value);
    }

    @Test
    public void TestMinus56PiValue() {
        double value = -1 * Math.PI * 5 / 6;
        testFunction(value);
    }

    @Test
    public void TestMinusPiValue() {
        double value = -1 * Math.PI;
        testFunction(value);
    }

    @Test
    public void Test10Value() {
        double value = 10;
        testFunction(value);
    }

    @Test
    public void Test100Value() {
        double value = 100;
        testFunction(value);
    }

    @Test
    public void Test1000Value() {
        double value = 1000;
        testFunction(value);
    }

    @Test
    public void TestMinus10Value() {
        double value = -10;
        testFunction(value);
    }

    @Test
    public void TestMinus100Value() {
        double value = -100;
        testFunction(value);
    }

    @Test
    public void TestMinus1000Value() {
        double value = -1000;
        testFunction(value);
    }

    @Test
    public void TestNaNValue() {
        double value = NaN;
        testFunction(value);
    }

    private void testFunction(double testValue){
        double expected = expectedFunc.func(testValue);
        double actual = myFunc.func(testValue);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    private String assertMessage(double expected, double actual, double delta, boolean equal) {
        return "Expected: " + expected + " is assumed to be " + (equal ? "" : "not") + "equal to Actual: " + actual + " with Delta: " + delta;
    }
}
