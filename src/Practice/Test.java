package Practice;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
//    public int uniqueMorseRepresentations(String[] words) {
//        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
//
//
//        HashSet<String> set = new HashSet<>();
//        for (String item : words) {
//            String ans="";
//            for (int i = 0; i < item.length(); i++) {
//                ans += morse[item.charAt(i) -'a'];
//            }
//            set.add(ans);
//        }
//        System.out.println(set);
//        return set.size();
//    }
//public static int[][] createHourGlassSum(List<List<Integer>> arr){
//    // int eachSum =0 ;
//        int[][] hourGlassSum = new int[arr.size()-2][arr.size()-2];
//
//        for(int i=1; i< arr.size()-1 ;i++){
//            for(int j =1 ;j<arr.size()-1 ;j++){
//                hourGlassSum[i-1][j-1] = sumProvider(arr,i, j);
//            }
//        }
//        for(int[] row : hourGlassSum){
//            for(int item : row)
//                System.out.print(item);
//            System.out.println();
//        }
//        return hourGlassSum;
//}
//        public static int sumProvider(List<List<Integer>> arr ,int i,int j){
//            return ((arr.get(i).get(j))+(arr.get(i-1).get(j))+(arr.get(i+1).get(j))+
//                    (arr.get(i-1).get(j-1))+(arr.get(i-1).get(j+1))+(arr.get(i+1).get(j-1))+
//                    (arr.get(i+1).get(j+1)));
//        }
    public static void listCheck(List<List<Integer>> Integer){
        int[] arr = new int[3];
        int i=0;
        for(List<Integer> row : Integer){
            arr[i++] = row.get(0);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        Long[] resArray = new Long[n+1];
        resArray[0] = -1L;
        System.out.println(Arrays.toString(resArray));
        for(List<Integer> row : queries){
            int beginIndex = row.get(0);
            int endIndex = row.get(1);
            int insertNumber = row.get(2);
            while(beginIndex<= endIndex){
                resArray[beginIndex] += insertNumber;
                beginIndex++;
            }

        }
        System.out.println(Arrays.toString(resArray));
        return 0;
    }
    public static int binarySearch(List<Integer> list ,int find){
        int low =0;
        int high = list.size()-1;
        int rank =1;
        while(low < high){
            int mid = (low+high)/2;
            if(find < list.get(mid)){
                low = mid + 1 ;
                rank = low ;
            }
            else{
                high = mid -1 ;
            }
        }
        return rank ;
    }
}
public class Test {
    public static void main(String[] args) throws IOException {
        int a =9;
        double b =9.0;
        System.out.println(a==b);
    }
}
