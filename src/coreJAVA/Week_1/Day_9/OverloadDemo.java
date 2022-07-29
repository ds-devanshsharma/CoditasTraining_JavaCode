package coreJAVA.Week_1.Day_9;
class OverloadDemo_Code{
    public int sum(int x,int y){
        return x+y;
    }
    public int sum(int x,int y,int z){
        return x+y+z;
    }
    public float sum(float x,int y){
        return x+y;
    }
}
class VarArgsDemo{
    //Var-Arg is a feature of JDK 1.5
    public static int  add(String name,int... a){
        int sum=0;
        for(int num : a)// jdk 1.5
            sum+=num;

        return sum;
    }
}
public class OverloadDemo {
    public static void main(String[] args) {
        OverloadDemo_Code overloadDemo_code = new OverloadDemo_Code();
        System.out.println("This from int int : "+ overloadDemo_code.sum(10,15));
        System.out.println("This from int int int : "+overloadDemo_code.sum(10,15,20));
        System.out.println("This from Float int : "+overloadDemo_code.sum(15.5f,10));

        System.out.println("**********************************************************");
        System.out.println("Sum using VarArg Method : "+ VarArgsDemo.add("Sum Method with One Argument",10));
        System.out.println("Sum using VarArg Method : "+ VarArgsDemo.add("Sum Method",10,20,30));
    }
}
