package coreJAVA.Day_16_UserInput;

public class CMDInput {
    public static void main(String[] args) {
        int sum =0;
        for(String s : args){
            sum += Integer.parseInt(s);
        }
        System.out.println("Sum of the arguments from CMD :: "+sum);
    }
}
