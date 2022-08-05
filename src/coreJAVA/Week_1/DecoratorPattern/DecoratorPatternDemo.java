package coreJAVA.Week_1.DecoratorPattern;
interface Shape{
    void draw();
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape :: Circle ");
    }
}
class Rectangle implements  Shape{
    @Override
    public void draw() {
        System.out.println("Shape :: Rectangle ");
    }
}
abstract class  ShapeDecorator implements Shape{
    Shape decorateShape;
    public ShapeDecorator(Shape decorateShape){
        this.decorateShape = decorateShape;
    }
    public void draw(){
        decorateShape.draw();
    }
}
class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decorateShape) {
        super(decorateShape);
    }
    public void draw(){
        decorateShape.draw();
        setRedBorder(decorateShape);
    }
    public void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color : RED");
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with no color :");
        circle.draw();
        System.out.println("\nCircle with RED border : ");
        redCircle.draw();
        System.out.println("\nRectangle with RED border :");
        redRectangle.draw();
    }
}
/*
Circle with no color :
Shape :: Circle

Circle with RED border :
Shape :: Circle
Border Color : RED

Rectangle with RED border :
Shape :: Rectangle
Border Color : RED
 */
