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
// 10 - -2.21244646972901314638449288339980706745873859786886945838
// 7 - -1.77842818546092804768455058371873132502937251004530808642
// 3 - -0.11108452210542353055289939283888610598281021981638900849
// 2 - 1.739325373218505161962262119325724427587194470596153327660
// -1 - 65.32243119472846765617594295716528227171828909879361798362
// -3 - 4.229121015534647170235267416686908949224961573314789317288
// -10 - 6.631422271364938847539049419951029042869195789303523200360
// -100 - 0.032676475532107323521510341153799390478063137500473747578