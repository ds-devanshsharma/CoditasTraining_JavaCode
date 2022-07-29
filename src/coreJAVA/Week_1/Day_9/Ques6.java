package coreJAVA.Week_1.Day_9;
enum Signal{
    RED("STOP"),
    GREEN("GO"),
    YELLOW("GO SLOWLY") ;
    private String data;
    Signal(String s)
    {
        this.data=s;
    }
    public String print(){
         return data;
     }

}
public class Ques6 {
    public static void main(String[] args) {
        for(Signal s: Signal.values()) {
            System.out.print(s.name()+" ");
            System.out.println(s.print());
        }
    }
}
