package coreJAVA.Day_13;
//
class ExceptionCode{
    public void divide(){
        int a = 10, b =0;
        System.out.println(" Line 3");
        float div = a/ b;
        System.out.println(" Line 4");
        System.out.println("Division  :: "+div );
    }
}
public class ExceptionHandingDemo {
    public static void main(String[] args) {
        System.out.println(" Line1");
        ExceptionCode exceptionCode = new ExceptionCode();
        System.out.println("Line 2 ");
        exceptionCode.divide();
    }
}
/*
1->2->3-----> ArithmaticException
 */