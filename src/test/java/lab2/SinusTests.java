package lab2;

import org.junit.Assert;
import org.junit.Test;


import static java.lang.Double.NaN;

public class SinusTests extends Assert {
    /*
     * Hash Maps: key - input, value - result.
     */
    private static final double delta = 0.001;
    public static IMyMath myMath = new MyMath();

    @Test
    public void TestPiValue() {
        testFunction(Math.PI);
    }

    @Test
    public void Test56PiValue() {
        testFunction(Math.PI * 5 / 6);
    }

    @Test
    public void Test23PiValue() {
        testFunction(Math.PI * 2 / 3);
    }

    @Test
    public void Test13PiValue() {
        testFunction(Math.PI / 3);
    }

    @Test
    public void Test16PiValue() {
        testFunction(Math.PI / 6);
    }

    @Test
    public void Test0Value() {
        testFunction(0);
    }

    @Test
    public void TestMinus16PiValue() {
        testFunction(-1 * Math.PI / 6);
    }

    @Test
    public void TestMinus13PiValue() {
        testFunction(-1 * Math.PI / 3);
    }

    @Test
    public void TestMinus23PiValue() {
        testFunction(-1 * Math.PI * 2 / 3);
    }

    @Test
    public void TestMinus56PiValue() {
        testFunction(-1 * Math.PI * 5 / 6);
    }

    @Test
    public void TestMinusPiValue() {
        testFunction(-1 * Math.PI);
    }

    @Test
    public void Test10Value() {
        testFunction(10);
    }

    @Test
    public void Test100Value() {
        testFunction(100);
    }

    @Test
    public void Test1000Value() {
        testFunction(1000);
    }

    @Test
    public void TestMinus10Value() {
        testFunction(-10);
    }

    @Test
    public void TestMinus100Value() {
        testFunction(-100);
    }

    @Test
    public void TestMinus1000Value() {
        testFunction(-1000);
    }

    @Test
    public void TestNaNValue() {
        testFunction(NaN);
    }

    @Test
    public void TestMinus12PiValue() {
        testFunction(-1 * Math.PI / 2);
    }

    @Test
    public void Test12PiValue() {
        testFunction(Math.PI / 2);
    }

    void testFunction(double testValue) {
        double actual = myMath.sin(testValue, delta);
        double expected = Math.sin(testValue);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    private String assertMessage(double expected, double actual, double delta, boolean equal) {
        return "Expected: " + expected + " is assumed to be " + (equal ? "" : "not") + "equal to Actual: " + actual + " with Delta: " + delta;
    }
}