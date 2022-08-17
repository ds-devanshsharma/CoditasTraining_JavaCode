package Practice;
abstract class Inner
{
    abstract void show();
}
class Outer1 {
    void display() {
        System.out.println("Outer Class");
         new Inner() {
           public void show()
           {
               System.out.println("Inner Class");
           }
        }.show();

    }

}

public class Anonymous_Class {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        outer1.display();

    }
}
