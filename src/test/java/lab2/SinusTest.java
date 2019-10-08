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
public class SinusTest extends Assert {
    /*
     * Hash Maps: key - input, value - result.
     */
    private static final double delta = 0.001;
    private static final int deltaPow = 4;

    @Parameter
    public IMathFunc myFunc;

    @Parameter(1)
    public IMathFunc expectedFunc;

    @Parameters
    public static Collection<Object[]> TestData() {
        IMathFunc mySin =(x) -> MyMath.sin(x,deltaPow);
        IMathFunc expectSin = Math::sin;

        Object[][] data = new Object[][]{{mySin, expectSin}};
        return Arrays.asList(data);
    }

    @Test
    public void TestPiValue() {
        double value = Math.PI;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void Test56PiValue() {
        double value = Math.PI * 5 / 6;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void Test23PiValue() {
        double value = Math.PI * 2 / 3;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void Test12PiValue() {
        double value = Math.PI / 2;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void Test13PiValue() {
        double value = Math.PI / 3;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void Test16PiValue() {
        double value = Math.PI / 6;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void Test0Value() {
        double value = 0;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestMinus16PiValue() {
        double value = -1 * Math.PI / 6;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestMinus13PiValue() {
        double value = -1 * Math.PI / 3;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestMinus12PiValue() {
        double value = -1 * Math.PI / 2;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestMinus23PiValue() {
        double value = -1 * Math.PI * 2 / 3;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestMinus56PiValue() {
        double value = -1 * Math.PI * 5 / 6;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestMinusPiValue() {
        double value = -1 * Math.PI;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void Test10Value() {
        double value = 10;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void Test100Value() {
        double value = 100;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void Test1000Value() {
        double value = 1000;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestMinus10Value() {
        double value = -10;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestMinus100Value() {
        double value = -100;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestMinus1000Value() {
        double value = -1000;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    @Test
    public void TestNaNValue() {
        double value = NaN;
        double expected = expectedFunc.func(value);
        double actual = myFunc.func(value);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    private String assertMessage(double expected, double actual, double delta, boolean equal) {
        return "Expected: " + expected + " is assumed to be " + (equal ? "" : "not") + "equal to Actual: " + actual + " with Delta: " + delta;
    }
}