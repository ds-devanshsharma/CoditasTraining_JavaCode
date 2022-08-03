package coreJAVA.Week_1.Day_11;
class OuterClass{
    class InnerClass{
        void show(){
            System.out.println("Innner show method ");
        }
    }
    public void display(){
        System.out.println("Outer InnerClass Method ");
    }
}
public class MemberInnerClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.display();
        OuterClass.InnerClass oi =outerClass.new InnerClass();
        oi.show();
    }
}
/*
Outer InnerClass Method
Innner show method
 */
