package lab2;

public class MyMath {

    public static double ln(double x, int accuracy) {
        long n = accuracy * 5;
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NEGATIVE_INFINITY;
        x = (1 - x) / (1 + x);
        double result = 0;

        for (long i = 1; i <= n; i += 2) {
            double pow = Math.pow(x, i);
            result += pow / i;
        }
        return result * (-2);
    }

    public static double log(double base, double x, int accuracy) {
        int acc = accuracy * 2;
        return ln(x, acc) / ln(base, acc);
    }

    public static double sin(double x) {
        x = normalizeInput(x);
        double result = 0;
        for (int i = 1; i < 10; i++) {
            double sign = Math.pow(-1, i - 1);
            double val = Math.pow(x, 2 * i - 1);
            double factorial = factorial(i * 2 - 1);
            result += sign * val / factorial;
        }
        return result;
    }

    private static long factorial(int x) {
        long result = 1;
        for (int i = 1; i <= x; i++)
            result *= i;
        return result == 0 ? 1 : result;
    }

    private static double normalizeInput(double x) {
        if (x >= Math.PI * -1 && x <= Math.PI)
            return x;
        int koef = (int) (Math.abs(x) / (Math.PI * 2)) + 1;
        x = x > 0 ? x - koef * Math.PI * 2 : x + koef * Math.PI * 2;
        return x;
    }
}
