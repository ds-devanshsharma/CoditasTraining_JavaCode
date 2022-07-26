package coreJAVA.Week_1.Day_6;

import java.util.Arrays;

class Ques4Code{
    static int count;
    static void duplicateInArrayPrinter(String[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].equals(arr[j])) {
                    System.out.println(arr[i]);
                    count++;
                }
            }
        }
    }
    static void duplicateInArrayRemover(String[] arr){
        String[] newString =new String[arr.length-count];
        int index=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(!(arr[i].equals(arr[j]))){
                    newString[index]=arr[i];
                }
                index++;
            }
        }
        for(String str : newString)
            System.out.println(str+" ");
}
}
public class Ques4 {
    public static void main(String[] args) {
    String[] arr ={"hi","Devansh","hi","Sharma"};
        System.out.print("Repeated : ");
        Ques4Code.duplicateInArrayPrinter(arr);
        /*
        Repeated :
        hi
         */
        Ques4Code.duplicateInArrayRemover(arr);
    }
}
