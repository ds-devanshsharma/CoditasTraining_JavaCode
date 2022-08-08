package Practice;

public class GfgElementInRange {
    static boolean check_elements(int arr[], int n, int A, int B){
        if(arr.length < B-A+1)return false;

        int sumA = (A*(A+1))/2;
        int sumB = (B*(B+1))/2;
        int sumOfRange = sumB- sumA;
        System.out.println("Sum"+sumOfRange);
        for(int i : arr){
            sumOfRange = sumOfRange-i;
//            System.out.println(sumOfRange);
            if(sumOfRange == 0)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] =  {1 ,9,1, 1, 5, 8, 9, 4, 3, 8, 10, 9, 4, 1, 8, 2, 6, 5, 1 ,8 ,5 ,2 ,6, 8, 2, 8, 9, 5, 103};
        int n=29;
        int a=3;
        int b=4;
        System.out.println(check_elements(arr,n,a,b));
    }
}
