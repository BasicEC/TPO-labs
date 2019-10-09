package lab2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

import static java.lang.Double.NaN;

import static org.junit.runners.Parameterized.*;

public class LogTests extends Assert {
    private static final double delta = 0.001;
    private static final IMyMath myMath = new MyMath();


    @Test
    public void TestEValue() { testFunction(Math.E); }

    @Test
    public void Test56EValue() { testFunction(Math.E * 5 / 6); }

    @Test
    public void Test23EValue() { testFunction(Math.E * 2 / 3); }

    @Test
    public void Test2EValue() { testFunction(Math.pow(Math.E, 2)); }

    @Test
    public void Test0Value() { testFunction(0); }

    @Test
    public void Test10Value() { testFunction(10); }

    @Test
    public void Test100Value() { testFunction(100); }

    @Test
    public void TestMinus10Value() { testFunction(-10); }

    @Test
    public void Test001Value() { testFunction(0.001); }

    @Test
    public void TestNaNValue() { testFunction(NaN); }

    private void testFunction(double testValue){
        double expected = Math.log(testValue);
        double actual = myMath.ln(testValue, delta);
        assertEquals(assertMessage(expected, actual, delta, true), expected, actual, delta);
    }

    private String assertMessage(double expected, double actual, double delta, boolean equal) {
        return "Expected: " + expected + " is assumed to be " + (equal ? "" : "not") + "equal to Actual: " + actual + " with Delta: " + delta + " difference: " + (expected - actual);
    }
}
