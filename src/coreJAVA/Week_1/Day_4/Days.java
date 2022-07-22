package coreJAVA.Week_1.Day_4;
class Days_code{
    public void dayPrinter(String[] string){
        for (String day: string) {
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
        days_code.dayPrinter(week);
    }
}
