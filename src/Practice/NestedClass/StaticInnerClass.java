package Practice.NestedClass;
class A{
    void showA(){
        System.out.println("showA() !");
    }
     class B{
        void showB(){
            System.out.println("showB() !!");
        }
        static void staticShowB(){
            System.out.println("staticShowB() !");
        }
    }
}
public class StaticInnerClass {
    public static void main(String[] args) {
//        new A().showA();
//        new A.B().showB();
        A a=new A();
//        A.B.staticShowB();
        A.B b = a.new B();
//        b.staticShowB();
    }
}
