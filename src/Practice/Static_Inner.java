package Practice;

class Outer_Static {
    static class Inner {
        void display() {
            System.out.println("Inner class non static method");
        }
        static void print() {
            int a;
            System.out.println("Inner class static method");
        }
    }
}

public class Static_Inner {
    public static void main(String[] args) {
        Outer_Static.Inner.print();
        Outer_Static.Inner inner = new Outer_Static.Inner();
        inner.display();
//        inner.print();
    }
}