package Practice.Comparable;

import java.util.Collections;
import java.util.List;

public class ComparePlayer {

    public static void main(String[] args) {
        List<Player> list = Player.getDefaultList();
        System.out.println("Before Sorting :");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("After Sorting : ");
        System.out.println(list);

    }
}
