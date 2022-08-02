package Anirudh_AssignmentCode.Oops;
class Student{
    int id;
    String  name;
    float marks;
    //default constructor
    //this is calling another constructor for
    // those item who haven't passed any argument
    Student (){

        this(00,"defaultName",00.0f);
    }
    //parameterized Constructor
    Student(int roll,String studentName,float marks){
//        this.id = id;
//        this.name = name;
//        this.marks = marks; but this is recommended to put same name as instance variable
        this.id = roll;
        this.name = studentName;
        this.marks = marks;
    }
    //Constructor with object type of Parameter
    Student(Student other){
        this.id = other.id;
        this.name = other.name;
        this.marks = other.marks;
    }
    void detailsPrinter(){
        System.out.println(" Roll no : "+ id+"\n Name : "+name+"\n Marks : "+marks+"\n ************");
    }
}
public class OopsBasics {
    public static void main(String[] args) {
        Student devanshRef = new Student(101,"Devansh",7.75f);
        Student copyOfdevanshRef = new Student(devanshRef);
        devanshRef.detailsPrinter();
        copyOfdevanshRef.detailsPrinter();
    }
}
