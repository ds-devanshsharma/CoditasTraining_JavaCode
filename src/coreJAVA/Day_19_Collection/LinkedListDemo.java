package coreJAVA.Day_19_Collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        Integer[] array ={10,21,32,43,12,31};
        /*
         in linkedList order : insertion order
                        null : allowed
                        duplicacy : allowed
         */
        List<Integer> list = new LinkedList<>(Arrays.asList(array));
        System.out.println(list);
        list.add(100);
        System.out.println(list);
        list.add(3,300);

        //adding duplicacy
        list.add(10);
        System.out.println(list);
        list.sort(Comparator.comparingInt(Integer::intValue));
        System.out.println(list);

    }
}
