package coreJAVA.Week_1.Day_8;
/* Ques : Can any interface contains concrete() ?
            Yes ,if its static / default => its is an enhancements from JDK 1.8
 */
//you can implements multiple interfaces by using , comma
//
interface ShapeInterface{
   void area();
   static  void draw(){
    System.out.println("This is static method ");
   }
   default  void display(){
       System.out.println("This is form default display");
   }
}
class Rectangle implements ShapeInterface {
  public void area(){

      ShapeInterface.super.display();
       int length =10 , width =2 ;
       System.out.println("Area of Rectangle : "+ (length * width) );
 }
}
public class ShapeInterfaceDemo{
    public static void main(String[] args) {
        ShapeInterface shapeInterface =new Rectangle();
        shapeInterface.area();
        ShapeInterface.draw();
    }
}