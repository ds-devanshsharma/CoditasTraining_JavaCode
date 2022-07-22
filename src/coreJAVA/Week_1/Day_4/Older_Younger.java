package coreJAVA.Week_1.Day_4;

import java.util.Scanner;

class Older_YoungerCode {
    public static void age_Determiner(int age1, int age2, int age3) {
        if (age1 > age2)
            {
                if (age1 > age3) {
                    System.out.println("Older " + age1);
                    if (age2 < age3)
                        System.out.println("Younger " + age2);
                    else
                        System.out.println("Younger " + age3);
                } else {
                    System.out.println("Older " + age3);

                    if (age1 > age2)
                        System.out.println("Younger " + age2);
                    else
                        System.out.println("Older " + age1);
                }
            }
            else
            {
                if (age2 > age3) {
                    System.out.println("Older" + age2);
                    if (age1 > age3)
                        System.out.println("Younger" + age3);
                    else
                        System.out.println("Younger" + age1);
                } else {
                    System.out.println("Older" + age3);
                    if (age1 > age2)
                        System.out.println("Younger" + age2);
                    else
                        System.out.println("Younger" + age1);
                }
            }
    }
}
public class Older_Younger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age1 =scanner.nextInt();
        int age2 =scanner.nextInt();
        int age3 =scanner.nextInt();
        Older_YoungerCode.age_Determiner(age1,age2,age3);
    }
}
/*
12
9
13
Older13
Younger9
 */