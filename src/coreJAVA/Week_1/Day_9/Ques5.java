package coreJAVA.Week_1.Day_9;

/**
 * program for Addition of multiple numbers
 */
abstract class Addition{
    abstract int additionCalculator(int... numbers);
}
class VarArgAddition extends Addition{
    int additionCalculator(int... numbers){
        int sum = 0;
        for(int number : numbers)
            sum += number;
        return sum;
    }
}
public class Ques5 {
    public static void main(String[] args) {
        VarArgAddition addition = new VarArgAddition();
        System.out.println("Sum : " + addition.additionCalculator(1, 2, 3, 4));
        System.out.println("Sum : " + addition.additionCalculator(10, 20));
    }
}
        /*
        Sum 10
        Sum 30

         */
