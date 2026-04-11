/**
 * Write a description of class ManU here.
 *
 * @author (Thando Mavuso)
 * @version (a version number or a date)
 */
class Mancity extends Football {
    // Instance variable
    private String league;

    // Constructor
    public Mancity(String team, String league) {
        super(team); // Call superclass constructor with 'team'
        this.league = league;
    }

    // Overriding winTrophy method
    @Override
    public void winTrophy() {
        System.out.println("Vamos!!!!");
    }

    // Getter
    public String getLeague() {
        return league;
    }

    // Setter
    public void setLeague(String league) {
        this.league = league;
    }

    // toString method (explicitly overridden)
    @Override
    public String toString() {
        return "Mancity: " + getTeam() + " (" + league + ")";
    }
}