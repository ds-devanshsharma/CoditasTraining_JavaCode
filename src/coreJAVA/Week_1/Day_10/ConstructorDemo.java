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
        t_id = tid;
        // if using same name as argument then this is manadatory
        //or take different name like t_id || tid no need of this here but best practice is to use this
        name = name;
        city = city;
        salary = salary;
    }
}
class AssistantProfessor{
    private  int exp;
    private String position;
}
public class ConstructorDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        System.out.println("******************");
        Teacher teacher1 = new Teacher(101,"Devansh","Kanpur",45000);
        System.out.println(teacher1);

    }
}
