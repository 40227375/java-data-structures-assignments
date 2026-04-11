
/**
 * Write a description of class rtfyjhg here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// The Player class represents a football player with a name and position
public class Player implements Comparable<Player> {
    private String name;
    private String position;

    public Player(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Implement the compareTo method to compare players by name
    @Override
    public int compareTo(Player other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + position + ")";
    }
}
