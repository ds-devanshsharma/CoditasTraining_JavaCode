package coreJAVA.Week_1.Day_5;
class Ques_3_Code{
    static void overloadChecker(int a){
        System.out.println("This is from method having Arguments :"+ a);
    }
    static void overloadChecker(){
        System.out.println("This is from NO argument method : ");
    }
}

public class Ques_3 {
    public static void main(String[] args) {
        Ques_3_Code.overloadChecker();
        Ques_3_Code.overloadChecker(101);

        /*
           Output 3.1
           This is from NO argument method :
           This is from method having Arguments :101
         */

    }
}
