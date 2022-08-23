package coreJAVA.Day_19_Collection;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {
    public static void main(String[] args) {
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println("Set "+set);
        System.out.println("Reverse Set " +set.descendingSet() );
        System.out.println("First element :" + set.first());
        System.out.println("Last element :" + set.last());
        System.out.println("removing first element : "+ set.pollFirst());
        System.out.println("after removing first element : "+set );
        System.out.println("removing last element : "+ set.pollLast());
        System.out.println("after removing last element : "+set );
    }
}
/*
Set [1, 2, 3, 4, 5]
Reverse Set [5, 4, 3, 2, 1]
First element :1
Last element :5
removing first element : 1
after removing first element : [2, 3, 4, 5]
removing last element : 5
after removing last element : [2, 3, 4]

 */