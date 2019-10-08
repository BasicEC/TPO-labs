public class Sinus {

   public static double sin(double x){
        x = normalize_input(x);
        double result = 0;
        for (int i = 1; i < 10 ; i++) {
            double sign = Math.pow(-1, i - 1);
            double val = Math.pow(x, 2 * i - 1);
            double factorial = factorial(i * 2 - 1);
            result += sign * val /  factorial;
        }
        return  result;
    }

    private static long factorial(int x){
        long result = 1;
        for (int i = 1; i <= x; i++)
            result *=i;
        return result == 0 ? 1 : result;
    }

     private static double normalize_input(double x){
        if (x >= Math.PI * -1 && x <= Math.PI)
            return x;
        int koef = (int)(Math.abs(x) / (Math.PI * 2)) + 1;
        x = x > 0 ? x - koef * Math.PI * 2: x + koef * Math.PI * 2;
        return x;
     }


}