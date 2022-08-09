package coreJAVA.Day_13;

/**
 *      IndexIndexOutOfBoundsException
 */
public class Ques3 {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        int sum =0;
        int condition1 = 10, condition2 = 11;

        for(int i =0 ; i<condition1;i++) // Everything fine
            sum+=array[i];
        System.out.println("Sum Of Array :: " + sum);

        try{
            for(int i =0 ; i<condition2;i++)
                sum+=array[i];
        }catch(IndexOutOfBoundsException e){
            // here it is must to write { } braces even for oneLine code
            System.out.println(e.toString());
        }
    }
}
/*
Sum Of Array :: 55
with handlerCode
java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
 */