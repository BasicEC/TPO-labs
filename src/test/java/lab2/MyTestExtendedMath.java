package lab2;

import java.util.HashMap;

import static java.lang.Double.NaN;
import static java.lang.Math.*;
import static java.lang.Math.PI;

public class MyTestExtendedMath extends MyTestBaseMath {
    protected static HashMap<Double, Double> cosMap = new HashMap<Double, Double>() {{
        put(PI, Math.cos(PI));
        put(PI * 5 / 6, Math.cos(PI * 5 / 6));
        put(PI * 2 / 3, Math.cos(PI * 2 / 3));
        put(PI / 2, Math.cos(PI / 2));
        put(PI / 3, Math.cos(PI / 3));
        put(PI / 6, Math.cos(PI / 6));

        put(-PI, Math.cos(-PI));
        put(-PI * 5 / 6, Math.cos(-PI * 5 / 6));
        put(-PI * 2 / 3, Math.cos(-PI * 2 / 3));
        put(-PI / 2, Math.cos(-PI / 2));
        put(-PI / 3, Math.cos(-PI / 3));
        put(-PI / 6, Math.cos(-PI / 6));

        put(0D, Math.cos(0));
        put(10D, Math.cos(10));
        put(100D, Math.cos(100));
        put(1000D, Math.cos(1000));
        put(-10D, Math.cos(-10));
        put(-100D, Math.cos(-100));
        put(-1000D, Math.cos(-1000));

        put(NaN, Math.cos(NaN));

        put(-1D, Math.cos(-1));
        put(-3D, Math.cos(-3));
    }};

    static {
        HashMap<Double, Double> map = new HashMap<>();
        for (Double key : cosMap.keySet()) {
            map.putIfAbsent(key + PI / 2, Math.cos(key + PI / 2));
            map.putIfAbsent(key + PI, Math.cos(key + PI));
        }
        cosMap.putAll(map);
    }

    @Override
    public double cos(double x, double accuracy) {
        try {
            return cosMap.get(x);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
