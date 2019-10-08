package lab2;

public class MyMath implements IMyMath {

    public double ln(double x, double accuracy) {
        accuracy = Math.abs(accuracy);
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NEGATIVE_INFINITY;
        x = (1 - x) / (1 + x);
        double result = 0;
        double delta = Double.MAX_VALUE;
        long i = 1;
        while (Math.abs(delta) > accuracy) {
            double pow = Math.pow(x, i);
            result += pow / i;
            delta = 4 * x / (i + 1);
            i += 2;
        }

        return -2 * result;
    }

    public double sin(double x, int accuracy) {
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

    private long factorial(int x) {
        long result = 1;
        for (int i = 1; i <= x; i++)
            result *= i;
        return result == 0 ? 1 : result;
    }

    private double normalizeInput(double x) {
        if (x >= Math.PI * -1 && x <= Math.PI)
            return x;
        int koef = (int) (Math.abs(x) / (Math.PI * 2)) + 1;
        x = x > 0 ? x - koef * Math.PI * 2 : x + koef * Math.PI * 2;
        return x;
    }
}
