package StringPractice;
/**
 * Index of Coincidence
 * If two strings of equal length are superimposed on one another, then some letters
 * may match.
 * For example consider the strings “wonderwhowrot ethebookonlov e” and “weallliveinay ellowsubmarin e”.
 * Notice that there are three positions that contain the same letter: the 1 st (w) , 14 th (e), and 27 th (e).
 * Of 27 possible positions, matches occur in three positions (11.1%).
 * This percentage is called the index of coincidence for two strings, and
 * it is used to decrypt ciphers like those used by the Germans in World War II.
 * Write a program that accepts two strings of the same length and determines their
 * index of coincidence.
 */
public class IndexofCoincidence {
    static float indexOfCoincidenceCalculator(String input1 , String input2){
        float result = 0;
        float matchCount = 0;
        float length = input1.length();
        for(int i=0; i< input1.length(); i++){
            if(input1.charAt(i) == input2.charAt(i) && input1.charAt(i)!=' ')
                matchCount++;
        }
        System.out.println(matchCount);
        result = (matchCount / length) * 100;
        return result;
    }
    public static void main(String[] args) {
        String input1 = "wonderwhowrot ethebookonlov e";
        String input2 = "weallliveinay ellowsubmarin e";
        System.out.println("percentage of coincidence :: "+indexOfCoincidenceCalculator(input1,input2)+"%");
    }

}
