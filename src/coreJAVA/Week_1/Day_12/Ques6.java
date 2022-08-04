package coreJAVA.Week_1.Day_12;

import java.util.Arrays;

/**
 * 6)Convert String data into array and present it
 */
public class Ques6 {
    public static void main(String[] args) {
        String str= "CoditasItSolutions";
        char[] charArray = str.toCharArray();
        System.out.println("CharactorArray is :: \n"+ Arrays.toString(charArray));
    }
}
/*
CharactorArray is ::
[C, o, d, i, t, a, s, I, t, S, o, l, u, t, i, o, n, s]
 */
