package Practice;

public class CoinFlippingMaxHeads {
    static int countMaxHead(int times){
        int result = 0;
        int headCount =0;
        int maxHeadCount =0 ;
        for(int i=1; i<=100 ;i++){
            result =(int)(Math.random()+ 0.5);
            if(result == 0) headCount++ ;
            else{
                 maxHeadCount = Math.max(maxHeadCount,headCount);
                headCount = 0 ;
            }
        }
        return maxHeadCount ;
    }

    public static void main(String[] args) {
        System.out.println("MaxHeads in row : "+ countMaxHead(100000));
    }
}
