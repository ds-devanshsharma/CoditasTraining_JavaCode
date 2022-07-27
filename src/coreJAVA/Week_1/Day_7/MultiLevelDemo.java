package coreJAVA.Week_1.Day_7;
// learning Multi-level inhertitance
class RajKapoor{
    int pan_id = 1234;
    public void display(){
        System.out.println("Details pan_id : " + pan_id);
    }
}
class RandheerKapoor extends RajKapoor{
    String name = "Randheer";
    public void display(){
        super.display(); // firstLine recommendation
        System.out.println("Details pan_id : " + pan_id + " name : "+name);
    }
}
class KareenKapoor extends RandheerKapoor{
    String name = "Kareena" ;

    public void display(){
        super.pan_id = 4321; // re-initializaiton of parent using super
        System.out.println("Details pan_id : " + pan_id + "name : "+name);
    }
}
public class MultiLevelDemo {
    public static void main(String[] args) {
        KareenKapoor kareenKapoor = new KareenKapoor();
        kareenKapoor.display();
    }
}
