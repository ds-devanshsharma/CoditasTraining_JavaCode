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
/*
Before Sorting :
[[id=101, name='Virat', score=10078.0, rating=5, hundreadCount=83, fiftyCount=98]
, [id=7, name='MSD', score=12078.0, rating=3, hundreadCount=63, fiftyCount=198]
, [id=11, name='Rohit', score=11978.0, rating=6, hundreadCount=80, fiftyCount=78]
]
After Sorting :
[[id=101, name='Virat', score=10078.0, rating=5, hundreadCount=83, fiftyCount=98]
, [id=11, name='Rohit', score=11978.0, rating=6, hundreadCount=80, fiftyCount=78]
, [id=7, name='MSD', score=12078.0, rating=3, hundreadCount=63, fiftyCount=198]
]
 */
/*

 */
