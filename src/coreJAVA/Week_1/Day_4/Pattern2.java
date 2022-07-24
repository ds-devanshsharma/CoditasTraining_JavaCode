package coreJAVA.Week_1.Day_4;

import java.sql.SQLOutput;

class Pattern2_code{
    static char charactor;
    public static void patternMaker(){
        for(int i=0;i<6;i++){
            int counter =0;
            while(counter<=i){
                charactor= (char) (counter+65);
                System.out.print(charactor+" ");
                counter++;
            }
            counter=counter-2;
            while(counter>=0){
                charactor=(char) (counter+65);
                System.out.print(charactor+" ");
                counter--;
            }
            System.out.println();

        }
    }
}
public class Pattern2 {
    public static void main(String[] args) {

        Pattern2_code.patternMaker();
     /* A
        A B A
        A B C B A
        A B C D C B A
        A B C D E D C B A
        A B C D E F E D C B A

        Process finished with exit code 0 */

    }
}
