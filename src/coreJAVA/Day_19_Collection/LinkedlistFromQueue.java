package coreJAVA.Day_19_Collection;

import java.util.*;

//Linkedlist implementation of Queue
public class LinkedlistFromQueue {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5};
        System.out.println("Array items : "+Arrays.toString(array));
        Deque<Integer> list = new ArrayDeque<>();
        for(Integer item : array )
            list.add(item);
        System.out.println("List items : ");
        System.out.println(list);
        System.out.println(list.element());
        System.out.println("List Items : ");
        System.out.println(list);
        System.out.println(list.offer(10));
        System.out.println("List Items : ");
        System.out.println(list);
        System.out.println(list.peek());
        System.out.println("List Items : ");
        System.out.println(list);
        System.out.println(list.poll());
        System.out.println("List Items : ");
        System.out.println(list);
        //There are many methods needed to be checked as per requirement

    }
}
