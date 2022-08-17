package Practice;

/**
 *      *
 *      * *
 *      * * *
 *      * * * *
 *      * * *
 *      * *
 *      *
 */
public class Pattern2 {
    public static void main(String[] args) {
        int k =1 ;
        for(int i = 1 ; i <= 7 ; i++ ){
            if(i<5){
                int stars = i ;
                while(stars > 0 ){
                    System.out.print("* ");
                    stars --;
                }
                System.out.println();
            }else{
                int stars = i-2*k;
                while(stars> 0){
                    System.out.print("* ");
                    stars--;
                }
                System.out.println();
                k++;
            }
        }
    }
}
