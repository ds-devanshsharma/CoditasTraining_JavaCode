package Practice.Comparator;
/**
 * Comparator Interface:
 * ---------------------
 * Here for comparing Object based on name We have created a separate class ComparePlayerOnName{}
 * which is implementing Comparator interface separately
 * This offer us to compare Objects as per our need ,provides more flexibility
 * for we need to only create a separate class which implement Comparator interface
 * along with compare() ove-ridden based on our requirement
 */

import Practice.Comparable.Player;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayerComparatorDriver {
    public static void main(String[] args) {
//        List<Player> list = Player.getDefaultList();
//        System.out.println("Before Sort :\n" +
//                "--------------------------------------------------------");
//        System.out.println(list);
//        System.out.println("After Sort :\n" +
//                "--------------------------------------------------------");
//        Collections.sort(list,new ComaparePlayerOnRating());
//        System.out.println(list);
        //Comparing based on Player Name
        List<Player> list = Player.getDefaultList();
//        System.out.println("Before SortByName:\n" +
//                "--------------------------------------------------------");
//        System.out.println(list);
//        System.out.println("After SortByName :\n" +
//                "--------------------------------------------------------");
//        Collections.sort(list,new ComaparePlayerOnName());
//        System.out.println(list);
        /*
         * we can do this by Annonymous class
         */
        System.out.println("Before sorting :");
        System.out.println(list);
        System.out.println("After Sorting :");
        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getHundreadCount()-o2.getHundreadCount();
            }
        });
        System.out.println(list);
        Collections.sort(list,

                Comparator.comparingInt(Player::getHundreadCount)

        );

    }
}
/*
Rating based Comparator class is invokes
Collections.sort(list,new ComparatorByRating())
Before Sort :
--------------------------------------------------------
[[id=101, name='Virat', score=10078.0, rating=5, hundreadCount=83, fiftyCount=98]
, [id=7, name='MSD', score=12078.0, rating=3, hundreadCount=63, fiftyCount=198]
, [id=11, name='Rohit', score=11978.0, rating=6, hundreadCount=80, fiftyCount=78]
]
After Sort :
--------------------------------------------------------
[[id=7, name='MSD', score=12078.0, rating=3, hundreadCount=63, fiftyCount=198]
, [id=101, name='Virat', score=10078.0, rating=5, hundreadCount=83, fiftyCount=98]
, [id=11, name='Rohit', score=11978.0, rating=6, hundreadCount=80, fiftyCount=78]
]
------------------------------------------------------------------------------------
Collections.sort(list,new ComparatorByName())
Here for comparing Object based on name We have created a separate class ComparePlayerOnName{}
which is implementing Comparator interface separately
This offer us to compare as per our need ,provides more flexibility

Before SortByName:
--------------------------------------------------------
[[id=101, name='Virat', score=10078.0, rating=5, hundreadCount=83, fiftyCount=98]
, [id=7, name='MSD', score=12078.0, rating=3, hundreadCount=63, fiftyCount=198]
, [id=11, name='Rohit', score=11978.0, rating=6, hundreadCount=80, fiftyCount=78]
]
After SortByName :
--------------------------------------------------------
[[id=7, name='MSD', score=12078.0, rating=3, hundreadCount=63, fiftyCount=198]
, [id=11, name='Rohit', score=11978.0, rating=6, hundreadCount=80, fiftyCount=78]
, [id=101, name='Virat', score=10078.0, rating=5, hundreadCount=83, fiftyCount=98]
]

 */
/*---------------------------------------------------------------------------------
 USING ANNONYMOUS CLASS
        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getHundreadCount()-o2.getHundreadCount();
            }
        });
----------------------------------------------------------------------------------
USING LAMBDA EXPRESSION
        Collections.sort(list, (o1,o2)-> o1.getHundredCount()-o2.getHundredCount());
----------------------------------------------------------------------------------
USING METHOD REFERENCES
        Collections.sort(list,Comparator.comparingInt(Player::getHundredCount)

 */