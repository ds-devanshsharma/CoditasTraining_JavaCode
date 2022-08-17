package Practice;

import java.util.Arrays;
import java.util.Scanner;

class Student {
    int id ;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
public class StudentArray {
    public static void main(String[] args) {
        Student[] array = new Student[5];
        Scanner scanner = new Scanner(System.in);

        for(int i=0; i<5 ; i++){
            System.out.println("Enter id  & Name : ");
            array[i] = new Student(scanner.nextInt() , scanner.nextLine() );

        }
        System.out.println(Arrays.toString(array));
    }
}
