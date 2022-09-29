package com.accountNumberGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomAccountNumberGenerator {
    public static long accountGenerator(){
        return ThreadLocalRandom.current().nextLong(10,1000000000)*1000;

    }
}
