package coreJAVA.Day_12;
/**
 * Accept the strings(HARD CODE VALUES/USER ACCEPTED),as per their length and
 * reorder it.
 */
import java.util.Arrays;
import java.util.Comparator;

public class Ques1 {
    public static void main(String[] args) {
        String[] array = {"Devansh","Anuj","Abhishek","Zulfa","UsmanBurkati"};
        Arrays.sort(array, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(array));
    }
}
/*
[Anuj, Zulfa, Devansh, Abhishek, UsmanBurkati]
 */
