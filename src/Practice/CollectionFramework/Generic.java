package Practice.CollectionFramework;

import java.util.ArrayList;

public class Generic {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(10);

        list.add("Ten");
        list.add(10.0);
        list.add("Devansh Sharma ");
        list.add(true);
        list.add(new Temp());

        // Iterating  over list
        for(Object o : list)
            System.out.println(o);
    }
}
class Temp{
    Temp(){
        System.out.println("This is from Temp class : ");
    }
}
