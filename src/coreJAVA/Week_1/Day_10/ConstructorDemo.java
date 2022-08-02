package coreJAVA.Week_1.Day_10;
// this Keyword => it point
class Teacher{
    private int t_id;
    private String name,city;
    private float salary;
    //getter setter toString
    //default Constuctor
       Teacher(){
         System.out.println("This is Default Constructor " + t_id+ " "+ name + " "+city);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id=" + t_id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Teacher(int tid, String name, String city, float salary) {
//           this();
        t_id = tid;
        // if using same name as argument then this is manadatory
        //or take different name like t_id || tid no need of this here but best practice is to use this
        this.name = name;
        this.city = city;
        this.salary = salary;
    }
}
class AssistantProfessor extends  Teacher{
    private  int exp;
    private String position;

    @Override
    public String toString() {
        return "AssistantProfessor{" +
                "exp=" + exp +
                ", position='" + position + '\'' +
                '}';
    }

    AssistantProfessor(int exp, String position) {
        this.exp = exp;
        this.position = position;
    }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        Teacher teacher1 ;
        teacher1 = new Teacher(101,"Devansh","Kanpur",45000);
        System.out.println(teacher1);
        System.out.println("******************");
        teacher1 = new AssistantProfessor(3,"Trainee Teacher");
        System.out.println(teacher1);

    }
}
