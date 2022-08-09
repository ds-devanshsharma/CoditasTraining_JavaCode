package coreJAVA.Day_11;
class Outer1{
    public void outerShow(){
        System.out.println("This is outerShow() from Outer1 class !!");
    }
    static class Inner1{
        public void innerShow(){
            System.out.println("This is innerShow() from Inner1 Class !!");
        }
        public static void innerStaticShow(){
            System.out.println("This is innerStaticShow() from Inner1 Class !!");

        }
    }
}
public class StaticNestedClassDemo {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        outer1.outerShow();
        // calling innerShow
       Outer1.Inner1 oInner1 = new Outer1.Inner1();
        oInner1.innerShow();
        // calling innerStaticShow
        Outer1.Inner1.innerStaticShow();
    }
}
/*
This is outerShow() from Outer1 class !!
This is innerShow() from Inner1 Class !!
This is innerStaticShow() from Inner1 Class !!
 */