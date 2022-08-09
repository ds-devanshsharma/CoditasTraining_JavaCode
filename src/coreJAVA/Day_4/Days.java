package coreJAVA.Day_4;

import java.util.Scanner;

class Days_code{
    public void dayPrinter(String[] string ,String today){
        for (String day: string) {
            if(day.equalsIgnoreCase(today))
                continue;
            System.out.println(day);
        }
    }
}
public class Days {
    public static void main(String[] args) {
        String[] week =new String[]{
                "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"
        };
        Days_code days_code = new Days_code();
//        days_code.dayPrinter(week);
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter today's name : ");
        String today= scanner.next();
        days_code.dayPrinter(week,today);
    }
}
