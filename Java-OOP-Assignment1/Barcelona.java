
/**
 * Write a description of class Barcelona here.
 *
 * @author (Thando Mavuso)
 * @version (a version number or a date)
 */
class Barcelona extends Football {
    // Instance variable
    private boolean isWinning;

    // Constructor
    public Barcelona(String team, boolean isWinning) {
        super(team); // Call superclass constructor with 'team'
        this.isWinning = isWinning;
    }

    // Overriding winTrophy method
    @Override
    public void winTrophy() {
        System.out.println("Visca!!!");
    }

    // Getter
    public boolean isWinning() {
        return isWinning;
    }

    // Setter
    public void setWinning(boolean isWinning) {
        this.isWinning = isWinning;
    }

    // toString method (explicitly overridden)
    @Override
    public String toString() {
        String winningStatus = isWinning ? "winning" : "not winning";
        return "Barcelona: " + getTeam() + " (" + winningStatus + ")";
    }
}
