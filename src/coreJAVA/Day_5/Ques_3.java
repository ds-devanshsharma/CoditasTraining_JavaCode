package coreJAVA.Day_5;
class Ques_3_Code{
/**Static methods can be overLoaded */

    static void overloadChecker(){
        System.out.println("This is from NO argument method : ");
    }
//    static void overloadChecker( int a){
//        System.out.println("This is from NO argument method : ");
//    }
}
class Ques_child extends Ques_3_Code{
    static void overloadChecker(){
        System.out.println("This is from child class NO argument method : ");
    }
}
public class Ques_3 {
    public static void main(String[] args) {
//        Ques_3_Code.overloadChecker();
//        Ques_3_Code.overloadChecker(101);
//          Ques_child.overloadChecker();
//          Ques_3_Code.overloadChecker();
        Ques_3_Code ques_3 = new Ques_child();
        //This is method Hiding
        ques_3.overloadChecker();

    //Ques_3_Code.overloadChecker(102);
//        static void overloadChecker(int a){
//            System.out.println("This is from Parent method having Arguments :"+ a);
//        }
//        static void overloadChecker(int a){
//            System.out.println(" This is from child class overridden method :"+a);
//        }
//        overloadChecker(109);
    }
}
/*
           Output 3.1
           This is from NO argument method :
           This is from method having Arguments :101
         */