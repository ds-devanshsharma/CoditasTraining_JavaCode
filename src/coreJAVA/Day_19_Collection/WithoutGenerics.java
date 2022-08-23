package coreJAVA.Day_19_Collection;

import java.util.ArrayList;
import java.util.List;

public class WithoutGenerics {
    public static void main(String[] args) {
        List list = new ArrayList();
//        list.add("One");
        list.add(10);
        list.add(20);
        list.add(30);
        // now accessing list having different type of objects
   Object sum =0;
//    for(int i =0 ; i<list.size() ; i++){
//        //here we need to typeCast beacuse Operator '+' cannot be applied to 'int', 'java.lang.Object'
//        sum =sum + (int)list.get(i);
//    }
//        for(Object item : list)
//        System.out.println(sum);

    }
}
