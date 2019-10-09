package lab2;

public class EquationTest extends MyFunc{
    @Override
    protected IMyMath getMath(){
        return new MyTestBaseMath();
    }
}
