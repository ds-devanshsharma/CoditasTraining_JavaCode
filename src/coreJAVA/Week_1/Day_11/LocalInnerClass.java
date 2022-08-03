package coreJAVA.Week_1.Day_11;
class Outer{
    public void show(){
        System.out.println("This is show() from OuterClass");
        class LocalInner{
            void localInnerDisplay(){
                System.out.println("This is localInnerDisplay() from LocalInnerClass");
            }
        }
        /*
         this is answer of question Can we create object outside main() method ??
         Yes we can do this in case of LocalInnerClass
         */
        LocalInner localInner = new LocalInner();
        localInner.localInnerDisplay();
    }
}
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();
    }
}
/*
This is show() from OuterClass
This is localInnerDisplay() from LocalInnerClass
 */