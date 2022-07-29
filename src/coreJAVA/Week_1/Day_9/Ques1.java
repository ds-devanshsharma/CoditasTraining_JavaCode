package coreJAVA.Week_1.Day_9;
/**
 * 1)CREATE A CLASS NAMED SHAPE,WHICH CONTAINS ONLY SINGLE
 * METHOD,calculate Area0. THIS METHOD SHOULD HAVE "N" NUMBER OF
 * PARAMETERS FOR DIFFERENT SHAPES LIKE FOR
 * CIRCLE.RECTANGLE. TRIANGLE,
 */
abstract class Shape{
    abstract void calculateArea(int... sides);
}
class Rectangle extends Shape{
    @Override
    void calculateArea(int... sides) {
        System.out.println("Area of Rectangle is : "+ sides[0]*sides[1]);
    }
}
class Circle extends Shape{
    @Override
    void calculateArea(int... sides) {
        System.out.println("Area of Circle is : "+ Math.PI* sides[0] * sides[0]);
    }
}
class Triangle extends Shape{
    @Override
    void calculateArea(int... sides) {
        System.out.println("Area of Triangle : "+ 0.5 * sides[0] * sides[1]);
    }
}
public class Ques1 {
    public static void main(String[] args) {
        Shape shape ;
        shape = new Circle();
        shape.calculateArea(10);

        //reinitialising the polymorphic variable with Rectangle object
        shape = new Rectangle();
        shape.calculateArea(10,20);
        //reinitialising the polymorphic variable with Rectangle object
        shape = new Triangle();
        shape.calculateArea(4,5);

    }
}
/*
Area of Circle is : 314.1592653589793
Area of Rectangle is : 200
Area of Triangle : 10.0

 */