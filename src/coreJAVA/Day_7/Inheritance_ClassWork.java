package coreJAVA.Day_7;
class Shape{
    public void area(){
        System.out.println("This is Shape Area method ");
    }
}
class Circle extends Shape{
//    int radius;
//    float area;
//
//    public int getRadius() {
//        return radius;
//    }
//
//    public void setRadius(int radius) {
//        this.radius = radius;
//    }
    public void area(){
        int radius =10;
        float area =0.0f;
        area = (float)(Math.PI * radius*radius);
        System.out.println("Area of Circle is : "+ area);
    }
}
public class Inheritance_ClassWork {
    public static void main(String[] args) {
        //way1 parent class object
//        Shape shape =new Shape();
//        shape.area();

//        // child class object with parent ref
        Shape shape1 = new Circle();
        shape1.area();
//        // child ref child obj
//        Circle circle = new Circle();
//        circle.area();
    }
}

