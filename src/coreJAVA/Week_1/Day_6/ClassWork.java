package coreJAVA.Week_1.Day_6;
class ClassWorkCode{
    void display_1D_Array(int[] arr){
        // For-each
        for(int number : arr)
            System.out.println(number);
    }
    void display_2D_Array(){
        int[][] matrix ={{1,2,3,},{1,2,3},{1,2,3,}};
    }
    void displayJaggedArray(){
        int[][] jaggedMatrix={{1,2,3,4},{1,2},{1,2,3,4,5}};
        for(int[] row : jaggedMatrix){
            for(int data : row){
                System.out.print(data);
            }
            System.out.println();
        }
    }
}
public class ClassWork {
    public static void main(String[] args) {
        //declaration & initialization
        int[] arr = {110,111,112,113,114,115};
        ClassWorkCode classWorkCode = new ClassWorkCode();
       // classWorkCode.display_1D_Array(arr);
        classWorkCode.displayJaggedArray();
    }
}
