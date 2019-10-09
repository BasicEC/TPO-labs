package lab2;

public interface IMyMath {
    double ln(double x, double accuracy);

    default double log(double base, double x, double accuracy) {
        double acc = accuracy / 2;
        return ln(x, accuracy) / ln(base, accuracy);
    }

    default double log10(double x, double accuracy) {
        return log(10, x, accuracy);
    }

    default double log5(double x, double accuracy) {
        return log(5, x, accuracy);
    }

    default double log3(double x, double accuracy) {
        return log(3, x, accuracy);
    }

    default double log2(double x, double accuracy) {
        return log(2, x, accuracy);
    }

    double sin(double x, double accuracy);

    default double cos(double x, double accuracy) {
        return sin(x + Math.PI / 2, accuracy);
    }

    default double tan(double x, double accuracy) {
        return sin(x, accuracy) / cos(x, accuracy);
    }

    default double sec(double x, double accuracy) {
        return 1 / cos(x, accuracy);
    }
}
