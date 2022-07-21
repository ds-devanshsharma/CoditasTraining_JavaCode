package coreJAVA.Week_1.Day_2;

public class Type_of_variablesDemo {
    int num1  ,num2  ,result;
    String name;
    public  int add(int num1, int num2){
        result = num1 + num2 ;
        return result;
    }


    public static void main(String[] args) {

        //className referenceVariable = new keyword className();
        //new => will help in creating DYNAMIC memory;
        //right to left initialization
        Type_of_variablesDemo type_of_variablesDemo =new Type_of_variablesDemo();
        System.out.println(type_of_variablesDemo.add(10,20));
    }
}
