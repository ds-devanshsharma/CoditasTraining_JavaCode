package coreJAVA.Week_1.Day_4;

import java.util.Scanner;

class PrintDate_TillToday_code{
    public static void date_printer(int today){
        for(int i=1;i<=31;i++){
            if(i==today)
                break;
            System.out.println("July " + i + " 2022" );
        }
    }
}
public class PrintDate_TillToday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int today=scanner.nextInt();
        PrintDate_TillToday_code.date_printer(today);
    }
}
/*
5
July 1 2022
July 2 2022
July 3 2022
July 4 2022
 */