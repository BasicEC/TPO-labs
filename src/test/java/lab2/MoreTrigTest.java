package lab2;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class MoreTrigTest extends TrigTest {

    @Parameterized.Parameters
    public static Collection<Object[]> TestData() {
        IMathFunc mySin = (x) -> myMath.sin(x, deltaPow);
        IMathFunc expectSin = Math::sin;

        IMathFunc myCos =(x) -> myMath.cos(x,deltaPow);
        IMathFunc expectCos = Math::cos;

        Object[][] data = new Object[][]{{mySin, expectSin}, {myCos, expectCos}};
        return Arrays.asList(data);
    }


    @Test
    public void TestMinus12PiValue() {
        super.testFunction(-1 * Math.PI / 2);
    }

    @Test
    public void Test12PiValue() {
        testFunction(Math.PI / 2);
    }
}
