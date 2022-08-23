package coreJAVA.Day_19_Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        Set<Integer> set = new HashSet<>();
        for(int i : array){
            set.add(i);
        }
        // 1-accessing using for-each
        // 2- accessing using array by converting into array
        // 3- using Iterator
        Iterator< Integer> i = set.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        Set<Integer> set1 = new LinkedHashSet<>();
        set1.addAll(set);

        /*Set method
            set.size()
         */

        /* Hashset -null -Yes
                    duplicate - nope
                    order -unOrdered
        * */


    }

}
