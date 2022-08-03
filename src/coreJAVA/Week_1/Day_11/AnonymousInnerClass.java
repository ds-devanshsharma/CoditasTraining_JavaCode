package coreJAVA.Week_1.Day_11;
/** Whenever we don't want to extends abstract class or implement interface
 *  but we want to use their functionalities so in that case
 *  we need to create a anonymous class to give body to their methods()
  */

interface Animal{
    void eat();
    void sleep();
}
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("Anonymous inner eat() method : ");
            }

            @Override
            public void sleep() {
                System.out.println("Anonymous inner sleep() method : ");
            }
        };
        animal.eat();
        animal.sleep();

    }
}
/*
Anonymous inner eat() method :
Anonymous inner sleep() method :

 */