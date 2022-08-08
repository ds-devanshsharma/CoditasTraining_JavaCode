package Practice;

public class Pattern1 {
    public static void main(String[] args) {
        int count = 4;
        for(int i=0;i< count ; i++){
            int spaces = 4-i-1;
            while(spaces > 0) {
                System.out.print(" ");
                spaces--;
            }
            int extra = 2*i+1;
            int j=0;
            while(j < extra){
                if(j>=1 && j<=(2*i-1)){
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
                j++;
            }
            System.out.println();
        }
        for(int i=0;i< count-1 ; i++){
            int spaces = i+1;
            while(spaces > 0) {
                System.out.print(" ");
                spaces--;
            }
            int extra = 5-2*i;
            int j=0;
            while(j < extra){

                if(j>=1 && j<=(3-2*i)){
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
                j++;
            }
            System.out.println();
        }
    }
}
/*

 */