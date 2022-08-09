package coreJAVA.Day_6;
class Encapsulation_Ques2Code{
    private int length;
    private int breath;


    public void setLength(int length )
     {
        this.length = length;
    }
    public void setBreath(int breath ) {
        this.breath = breath;
    }
    public int getArea() {
        int area =  length * breath;
        return area;
    }

}
public class Encapsulation_Ques2 {
    public static void main(String[] args) {
    Encapsulation_Ques2Code encapsulation_ques2Code =new Encapsulation_Ques2Code();
    encapsulation_ques2Code.setLength(10);
    encapsulation_ques2Code.setBreath(10);
        System.out.println("Area : "+encapsulation_ques2Code.getArea());
    }
}
