package coreJAVA.Day_13;

/**
 * Assertion in java
 */
public class AssertionConcept {
    public static void main(String[] args) {
        int age = 17;
        // This assert works only when assumption (conditions) went wrong
        // then it throws AssertionError With provided message
        assert age > 18 : "UnderAge ho tum !! ";

        //here is the bussiness logic we want to perform after assertion means bizLogic after some sort of
       System.out.println("Age is : "+ age);
    }
}
/*
 *Exception in thread "main" java.lang.AssertionError: UnderAge ho tum !!
	at coreJAVA.Week_1.Day_13.AssertionConcept.main(AssertionConcept.java:9)
 */