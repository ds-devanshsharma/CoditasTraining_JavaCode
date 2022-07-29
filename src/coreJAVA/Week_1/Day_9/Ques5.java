package coreJAVA.Week_1.Day_9;

/**
 * program for Addition of multiple numbers
 */
 class Addition{
    int additionCalculator(int number1,int number2) {
        return number1 + number2;
    }
    float additionCalculator(float number1 ,int number2){
        return number1 + number2;
    }
}
class VarArgAddition {
    int additionCalculator(int... numbers){
        int sum = 0;
        for(int number : numbers)
            sum += number;
        return sum;
    }
}
public class Ques5 {
    public static void main(String[] args) {

        Addition addition1 = new Addition();
        System.out.println("This is from Addition class : "+addition1.additionCalculator(10,15));
        System.out.println("This is from Addition class :"+addition1.additionCalculator(10.5f,15));

        VarArgAddition addition2= new VarArgAddition();
        System.out.println("Sum from VarArgClass : " + addition2.additionCalculator(1, 2, 3, 4));
        System.out.println("Sum from VarArgClass : " + addition2.additionCalculator(10, 20));
    }
}
        /*
        Sum 10
        Sum 30

         */
