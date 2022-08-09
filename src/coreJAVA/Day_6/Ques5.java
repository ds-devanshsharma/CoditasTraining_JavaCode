package coreJAVA.Day_6;
//Sum of two Jagged Array
class Ques5Code{
    static void sumOfTwoJaggedArray(int[][] arr1,int[][] arr2){
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                arr1[i][j]+=arr2[i][j];
            }
        }
        //for printing sumOfTwoJaggedArray
        for(int[] row : arr1){
            for(int cellValue : row){
                System.out.print(cellValue+" ");
            }
            System.out.println();
        }
    }
}
public class Ques5 {
    public static void main(String[] args) {
        int[][] arr1 ={{1,2,3},{1,2},{1,2,3,4}};
        Ques5Code.sumOfTwoJaggedArray(arr1,arr1);
    }
}
