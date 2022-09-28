package Practice.CollectionFramework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InteratorDemo {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Student student;
    static int flag =1;
    public static void main(String[] args) throws IOException {
        List<Student> list = new ArrayList<>();
        do {
            student = new Student();
            System.out.println("Enter Id : ");student.setId(Integer.parseInt(reader.readLine()));
            System.out.println("Enter Name");student.setName(reader.readLine());
            list.add(student);
            System.out.println("Add more \n" +
                    "1-Yes \n" +
                    "0- No");flag=Integer.parseInt(reader.readLine());
        }while(flag!= 0);

        //printing
        Iterator<Student> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getId()==10)iterator.remove();
            System.out.println(iterator.next());
        }
    }
}
