package Practice.Comparable;

import java.util.ArrayList;
import java.util.List;

/**
 * ->Comparable Interface is functional interface with compareTo()
 *       if it return >0 Descending Order
 *       else Natural Order
 * -------------------------------------------------------------
 * ->Comparable interface is used to compare object type entities based on thier fields,
 *      lets take ex, you need to sort a list of student based on marks ,
 *      you can not apply  Collections.sort() on it directly ----->
 *      for that You can implement Functional interface in Same class and overRide its compareTo()
 *      based on need.
 * ->But the drawBack of using Comparable interface is you can compare object based on Single
 *      parameter with it
 * -> if you want to compare on multiple parameter then you should go for comparator Interface
 */

public class Player  implements Comparable<Player>{
    int id ;
    String name;
    float score;
    int rating ;
    int hundreadCount;
    int fiftyCount;

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", rating=" + rating +
                ", hundreadCount=" + hundreadCount +
                ", fiftyCount=" + fiftyCount +
                ']'+"\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getHundreadCount() {
        return hundreadCount;
    }

    public void setHundreadCount(int hundreadCount) {
        this.hundreadCount = hundreadCount;
    }

    public int getFiftyCount() {
        return fiftyCount;
    }

    public void setFiftyCount(int fiftyCount) {
        this.fiftyCount = fiftyCount;
    }

    public Player() {
    }

    public Player(int id, String name, float score, int rating, int hundreadCount, int fiftyCount) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.rating = rating;
        this.hundreadCount = hundreadCount;
        this.fiftyCount = fiftyCount;
    }
    public static List<Player> getDefaultList(){
        List<Player> list = new  ArrayList<>();
        list.add(new Player(101,"Virat",10078,5,83,98));
        list.add(new Player(7,"MSD",12078,3,63,198));
        list.add(new Player(11,"Rohit",11978,6,80,78));
    return list;
    }

    @Override
    public int compareTo(Player o) {
        return -(o.id-id);
    }
}
/*
Comparable Interface :
---------------------
o.id-id
if return > 0 descending
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
------------------------------------------------------------------------------------
if return  < 0
Ascending Order
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