package Practice.CollectionFramework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Student student;
    static int flag =1;
    static int count=0;
    public static void main(String[] args) throws IOException {
        HashMap<Integer,String > map = new HashMap<>();
        map.put(101,"Devansh");
        System.out.println(map.keySet().stream().findFirst().get());
        System.out.println(map.entrySet().iterator().next().getKey());


//        while(flag!= 0) {
//            student = new Student();
//            System.out.println("Enter Id : ");student.setId(Integer.parseInt(reader.readLine()));
//            System.out.println("Enter Name");student.setName(reader.readLine());
//            map.put(student,count++);
//            System.out.println("Add more \n" +
//                    "1-Yes \n" +
//                    "0- No");flag=Integer.parseInt(reader.readLine());
//        }
//        for(Map.Entry<Student,Integer> entry : map.entrySet())
//            System.out.println("ID "+entry.getKey().getId()+"\nname :  "+entry.getKey().getName()+"\n" +
//                    " "+entry.getValue());

    }

}
