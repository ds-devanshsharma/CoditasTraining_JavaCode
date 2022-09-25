package Practice.NestedClass;

class Outer{
    void showOuter(){
        System.out.println("showOuter() !");
    }
    static void staticShowOuter(){
        System.out.println("staticShowOuter() !");
    }
    class inner{
        void showInner(){
            System.out.println("showInner() !");
        }
        static void staticShowInner(){
            System.out.println("staticShowInner() !");
        }
    }
}
public class MemberInnerClass {
    public static void main(String[] args) {
        Outer.staticShowOuter();
        new Outer().showOuter();
        //static inner
        Outer.inner.staticShowInner();
        //non static inner
        new Outer().new inner().showInner();
    }
}
/*
staticShowOuter() !
showOuter() !
staticShowInner() !
showInner() !
 */