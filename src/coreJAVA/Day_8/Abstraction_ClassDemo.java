package coreJAVA.Day_8;
// Abstraction class Demo || class Work
//Rule 1: method abstract
//Rule 2: class abstract
//Rule 3: class abstract
//Rule 4: if you extends a abstract class then child class must define body to Parent abstract method

abstract class Shape{
    // just declaration with no body
    public abstract void area();

    // normal / concrete method
    public void display(){
        System.out.println("This is Shape display method !!");
    }

}
class Circle extends Shape{

    @Override
    public void area() {
        int radius = 2;
        float area = (float) Math.PI * radius *radius;
        System.out.println("Circle area : "+ area);
    }
}
public class Abstraction_ClassDemo {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.area();
        circle.display();

        // Anonymous Class
//        Shape shape = new Shape() {
//            @Override
//            public void area() {
//
//            }
//        }

    }
}
