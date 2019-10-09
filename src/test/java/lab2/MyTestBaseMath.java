package lab2;

import java.util.HashMap;

import static java.lang.Double.NaN;
import static java.lang.Math.*;

public class MyTestBaseMath implements IMyMath {

    private static HashMap<Double, Double> lnMap = new HashMap<Double, Double>() {{
        put(E, Math.log(E));
        put(E * 5 / 6, Math.log(E * 5 / 6));
        put(E * 2 / 3, Math.log(E * 2 / 3));
        put(pow(E, 2), Math.log(pow(E, 2)));
        put(0D, Math.log(0));
        put(10D, Math.log(10));
        put(100D, Math.log(100));
        put(-10D, Math.log(-10));
        put(0.001, Math.log(0.001));
        put(NaN, Math.log(NaN));
        put(2D, Math.log(2));
        put(3D, Math.log(3));
        put(5D, Math.log(5));
    }};

    private static HashMap<Double, Double> sinMap = new HashMap<Double, Double>() {{
        put(PI, Math.sin(PI));
        put(PI * 5 / 6, Math.sin(PI * 5 / 6));
        put(PI * 2 / 3, Math.sin(PI * 2 / 3));
        put(PI / 2, Math.sin(PI / 2));
        put(PI / 3, Math.sin(PI / 3));
        put(PI / 6, Math.sin(PI / 6));

        put(-PI, Math.sin(-PI));
        put(-PI * 5 / 6, Math.sin(-PI * 5 / 6));
        put(-PI * 2 / 3, Math.sin(-PI * 2 / 3));
        put(-PI / 2, Math.sin(-PI / 2));
        put(-PI / 3, Math.sin(-PI / 3));
        put(-PI / 6, Math.sin(-PI / 6));

        put(0D, Math.sin(0));
        put(10D, Math.sin(10));
        put(100D, Math.sin(100));
        put(1000D, Math.sin(1000));
        put(-10D, Math.sin(-10));
        put(-100D, Math.sin(-100));
        put(-1000D, Math.sin(-1000));

        put(NaN, Math.sin(NaN));
    }};

    static {
        HashMap<Double, Double> map = new HashMap<>();
        for (Double key : sinMap.keySet()) {
            map.putIfAbsent(key + PI / 2, Math.sin(key + PI / 2));
            map.putIfAbsent(key + PI, Math.sin(key + PI));
        }
        sinMap.putAll(map);
    }

    @Override
    public double ln(double x, double accuracy) {
        try {
            return lnMap.get(x);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public double sin(double x, double accuracy) {
        try {
            return sinMap.get(x);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
