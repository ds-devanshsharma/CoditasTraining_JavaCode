package Practice.Comparator;

import Practice.Comparable.Player;

import java.util.Comparator;

/**
 * Player class is defined in Comparator package
 */
class ComaparePlayerOnRating implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return o1.getRating()- o2.getRating();
    }
}
class ComaparePlayerOnName implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

