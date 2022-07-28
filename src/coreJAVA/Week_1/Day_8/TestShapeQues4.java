package coreJAVA.Week_1.Day_8;

/**
 * 4). Create an abstract class shape with abstract method void area();
 * create 4 more classes circle, cylinder, square and rectangle
 * shape
 * circle || cylinder
 * square || rectangle
 * SHAPE is parent for circle and square, and circle is parent for cylinder,rectangle is
 * of square.
 * Override the area( ) in all the classes Create an array of references of type shape in
 * TestShape class and print the area of different types of shapes
 */
import java.util.*;
abstract class Shapes{
    abstract void area();
}
class Circles extends Shapes{

    int radius =10;
    void area() {
        System.out.println("Area of Circle : "+ Math.PI*radius*radius);
    }
}
class Cylinders extends Circles{

    public void area(){
        int height=10;
        System.out.println("Area of Cylinder : "+ 2* Math.PI*radius*height);
    }
}
class Squares extends Shapes{

    int First=10;
    void area() {
        System.out.println("Area of Square : "+ First*First);
    }
}
class Rectangles extends Squares{
    public void area(){
        int second=10;
        System.out.println("Area of Rectangle : "+First*second);
    }
}
public class TestShapeQues4 {
    public static void main(String[] args) {
        Shapes[] shapesArray = new Shapes[10];
        //using Random class
        Random random = new Random();

        for (int i=0;i<10;i++) {
            switch (random.nextInt(1,5)){
                case 1 :
                    shapesArray[i] = new Rectangles();
                    break;
                case 2:
                    shapesArray[i] = new Circles();
                    break;
                case 3:
                    shapesArray[i] = new Cylinders();
                    break;
                case 4:
                    shapesArray[i] = new Squares();
                    break;
                default:
                    System.out.println("Extra");
            }
        }
        for (Shapes s : shapesArray)
            s.area();
        /*
        Area of Circle : 314.1592653589793
        Area of Rectangle : 100
        Area of Circle : 314.1592653589793
        Area of Cylinder : 628.3185307179587
        Area of Rectangle : 100
        Area of Circle : 314.1592653589793
        Area of Rectangle : 100
        Area of Cylinder : 628.3185307179587
        Area of Circle : 314.1592653589793
        Area of Rectangle : 100

         */
    }
}
