package coreJAVA.Day_19_Collection;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        Integer[] array ={10,12,14,15,8,5};
        //direct array to Arraylist : Arrays.asList("put your array here");
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        // if we are trying to add element in between then element get added and shifting of others happens
        list.add(1,100);
        System.out.println("Printing ArrayList : "+list);
        /*
        ListIterator hasNext() ,next() ,hasPrevious() ,previous() ,nextIndex() ,previousIndex()
         */
        ListIterator iterator = list.listIterator();

        // traversing list in forward direction
        System.out.println("List elements on forward traverse :");
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ,");
            // iterator.remove();
        }
        System.out.println("\n_________________________________");
        //  now iterator is at last index we
        // traversing list in backward direction
//        System.out.println(iterator.nextIndex()); // index : 6
        System.out.println("List elements on Backward traverse :");
        while(iterator.hasPrevious()){
            System.out.print(iterator.previous()+" ,");
        }
        System.out.println("contains 15  or not : "+list.contains(15));

    }
}
