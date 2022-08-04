package coreJAVA.Week_1.Day_12;
import java.util.StringTokenizer;
/** 7)  Separate the tokens(operands and operators) from below statement:
         3+(20%2) (20/2)
         Case 1)Print separated tokens
         Case 2)Print Operators and Operand separatel
 */
public class Ques7 {
    public static void main(String[] args) {
        String statement ="3+(20%2)*(20/2)";
        StringTokenizer tokenizer ;
        tokenizer = new StringTokenizer(statement,"+*%/()");
        System.out.println("Case1 : Printing Seperate tokens ::");
        while(tokenizer.hasMoreElements()){
            System.out.print(tokenizer.nextToken()+ "  ");
        }

        System.out.println("\nCase2 : printing Separate operand  : ");
        tokenizer = new StringTokenizer(statement,"+*%/()");
        while(tokenizer.hasMoreElements()){
            System.out.print(tokenizer.nextToken()+"  ");
        }
        System.out.println("\n : printing Separate operators  : ");
        tokenizer = new StringTokenizer(statement,"[0123456789]");
        while(tokenizer.hasMoreElements()){
            System.out.print(tokenizer.nextToken()+"  ");
        }
    }
}
/*
Case1 : Printing Seperate tokens ::
3  20  2  20  2
Case2 : printing Separate operand  :
3  20  2  20  2
 : printing Separate operators  :
+(  %  )*(  /  )
 */