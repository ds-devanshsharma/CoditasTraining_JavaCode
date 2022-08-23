package coreJAVA.Day_19_Collection;
/**
 *  key-value pair-> Entry
 *  Many Entries -> EntrySet
 *  Dictionary -> subInterface
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer ,String  > map = new HashMap();
        map.put(12,"B");
        map.put(14,"D");
        map.put(16,"F");
        map.put(20,"G");
        Map<Integer ,String  > map1 = new HashMap();
        //map1.putAll(map);

        // access it
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
