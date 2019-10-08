package lab2;

public class Main {
    public static void main(String[] args) {
        double[] X = new double[]{0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1};
        double[] Y = new double[10];
        for (int i = 0; i < X.length; i++) {
            Y[i] = MyMath.ln(X[i], 0.01);
        }

        ChartCreater cc = new ChartCreater();
        cc.createChart(X, Y);
    }
}
