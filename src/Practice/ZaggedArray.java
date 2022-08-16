package Practice;

public class ZaggedArray {


    public static void main(String[] args) {
        int[][] zaggedArray ={
                {1,2,3,4},{1,2,3},{1,2,3,4,5,6}
        };
//        for(int i=0 ; i<zaggedArray.length; i++){
//            for(int j = 0; j<zaggedArray[i].length;j++){
//                System.out.print(zaggedArray[i][j] +" ");
//            }
//            System.out.println();
//        }
        /*
        1 2 3 4
        1 2 3
        1 2 3 4 5 6
         */
        for(int[] i : zaggedArray){
            for(int j : i){
                System.out.print( j + " ");
            }
            System.out.println();
        }
        /*
        1 2 3 4
        1 2 3
        1 2 3 4 5 6
         */
    }
}
