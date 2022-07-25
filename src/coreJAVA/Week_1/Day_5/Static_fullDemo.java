package coreJAVA.Week_1.Day_5;
class Static_fullDemo_Code{
    static int id;
    // here i am using static block to initialise the static variable
    static{
        id=101;
    }
    static void printMessage(){
        System.out.println("Your Employee id :" + id );
        id++;
    }
    static class Static_ClassDemo{
        static  void printMessageFromStaticClass(){
            System.out.println("This from static inner class :");
        }
    }
}
public class Static_fullDemo {
    public static void main(String[] args) {

        //Static_fullDemo_Code.printMessage();
        //Static_fullDemo_Code.printMessage();
        /*  Output
            Your Employee id :101
            Your Employee id :102
         */
        Static_fullDemo_Code.Static_ClassDemo.printMessageFromStaticClass();
        /* output
        This from static inner class :
         */
    }
}
