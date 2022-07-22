package coreJAVA.Week_1.Day_4;

 class ClassWork_Things {
    int num1 ,num2 ,num3 ;
    public void if_else_demo() {

        if (num1 < num2)
            System.out.println("num2 is greater");
        else
            System.out.println(" num1 is greater");
    }

    public void if_else_ladder() {
        if(num1>num2){
            if(num2>num3)
                System.out.println("num2 is greater");
            else
                System.out.println("num3 is greater");
        }
        //else if()
    }
    public void switchDemo(int num){
        switch (num){
            case 1 :
                System.out.println("You are first");
                break;
            case 2:
                System.out.println("you are second");
                break;
            case 3:
                System.out.println("You are third");
                break;
            default:
                System.out.println("tum bs pass ho gya bhai");
        }
    }
}
public class ClassWork{
    public static void main(String[] args) {
        ClassWork_Things classWork_things=new ClassWork_Things();
        classWork_things.switchDemo(5);
    }
}