package lab2;

public class MyFunc {

    private final int accuracy = 4;

    public double Calculate(double x){
        return x > 0 ? lowerEquation(x) : upperEquation(x);
    }

    private double upperEquation(double x){
       double result = (getMath().sec(x, accuracy) - getMath().cos(x, accuracy) + getMath().sec(x,accuracy)) / (getMath().tan(x,accuracy) + getMath().sec(x,accuracy));
       result += getMath().sin(x,accuracy) - getMath().sec(x,accuracy);
       result = result * result;
       return result;
    }

    private double lowerEquation(double x){
        double result = (getMath().log3(x,accuracy) * getMath().log3(x,accuracy)) / (getMath().log10(x,accuracy) * getMath().log5(x,accuracy));
        result -= getMath().log5(x,accuracy) * getMath().ln(x,accuracy);
        result /= getMath().ln(x,accuracy);
        result += getMath().ln(x,accuracy) - (getMath().log2(x,accuracy) / getMath().log5(x,accuracy)) + getMath().log3(x,accuracy);
        return result;
    }

    protected IMyMath getMath(){
        return new MyMath();
    }
}
