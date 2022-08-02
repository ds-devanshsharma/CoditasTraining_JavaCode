package coreJAVA.Week_1.Day_10;
class FirstClass{
    //class1
    int id;
    @Override
    public String toString() {
        return "FirstClass{" +
                "id=" + id +
                '}';
    }
    public FirstClass(){
        System.out.println("This is  NO-argument Constructor from Base class : ");
    }
    public FirstClass(int id) {
        this();
        this.id = id;
        System.out.println("This is  parameterized Constructor from Base Class : ");
    }
}
class SecondClass extends FirstClass{
    SecondClass(int id){
        super(id);
        System.out.println("This is parameterized from Derived Class ");

    }
}
public class Ques1 {
    public static void main(String[] args) {
         //FirstClass firstClass = new FirstClass(110);
        SecondClass second = new SecondClass(101);
        System.out.println(second);
    }
}
