package coreJAVA.Week_1.Day_13;

/**
 * Assertion in java
 */
public class AssertionConcept {
    public static void main(String[] args) {
        int age = 17;
        assert age > 18 : "UnderAge ho tum !! ";
       System.out.println("Age is : "+ age);
    }
}
/*
 *Exception in thread "main" java.lang.AssertionError: UnderAge ho tum !!
	at coreJAVA.Week_1.Day_13.AssertionConcept.main(AssertionConcept.java:9)
 */