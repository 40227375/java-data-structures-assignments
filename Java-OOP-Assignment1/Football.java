
/**
 * Write a description of class Footballl here.
 *
 * @author (Thando Mavuso)
 * @version (a version number or a date)
 */
abstract class Football {
    // Instance variables
    private String team;

    // Constructor
    public Football(String team) {
        this.team = team;
    }

    // Abstract method
    public abstract void winTrophy();

    // Getter (Accessor)
    public String getTeam() {
        return team;
    }

    // Setter (Mutator)
    public void setTeam(String team) {
        this.team = team;
    }

    // toString method (implicitly overridden)
    public String toString() {
        return "Football: " + team;
    }
}
