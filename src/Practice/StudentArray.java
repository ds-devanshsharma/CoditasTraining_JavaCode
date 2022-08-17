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

    @Override
    public String toString() {
        return  "id=" + id +
                " name='" + name ;
    }
}
public class StudentArray {
    public static void main(String[] args) {
        Student[] array = new Student[5];
        Scanner scanner = new Scanner(System.in);
        int id ;
        String name;
        for(int i=0; i<5 ; i++){
            System.out.println("Enter id  : ");
            id = scanner.nextInt();
            System.out.println("Enter name : ");
            name = scanner.next();
            array[i] = new Student(id , name);
        }
        System.out.println(Arrays.toString(array));
        for(int i=0 ; i< 5; i++ ){
            for(int j= i+1; j< 5 ; j++){
                if(array[i].id > array[j].id ){
                    Student temp = array[i];
                    array[i] = array [j];
                    array[j] = temp ;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
/*
[id=11 name='dd, id=32 name='gg, id=245 name='hhj, id=54 name='ttt, id=789 name='tyty]
[id=11 name='dd, id=32 name='gg, id=54 name='ttt, id=245 name='hhj, id=789 name='tyty]
 */