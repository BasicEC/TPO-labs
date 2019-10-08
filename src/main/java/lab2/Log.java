package lab2;

public class Log {

    public static double ln(double x, int accuracy) {
        x = (1 - x) / (1 + x);
        double result = 0;

        for (int i = 1; i <= accuracy * 4; i += 2) {
            double pow = Math.pow(x, i);
            result += pow / i;
        }
        return result * (-2);
    }

    public static double log(double base, double x, int accuracy) {
        int acc = accuracy * 2;
        return ln(x, acc) / ln(base, acc);
    }
}
