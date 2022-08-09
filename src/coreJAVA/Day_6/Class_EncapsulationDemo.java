package coreJAVA.Day_6;
class Class_EncapsulationDemoCode{
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //extra OverHead printMethod to print
    void printer(){
        System.out.println("Student id is : "+ id);
        System.out.println("Student name is : "+ name);
    }
}
public class Class_EncapsulationDemo {
    Class_EncapsulationDemoCode class_encapsulationDemoCode = new Class_EncapsulationDemoCode();


}
