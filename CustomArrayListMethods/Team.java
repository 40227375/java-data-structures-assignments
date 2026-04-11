// Class to represent a team in a league
public class Team implements Comparable<Team> {
    // Fields to store team information
    private String name;
    private int points;
    private int goalsScored;

    // Constructor to initialize a team object
    public Team(String name, int points, int goalsScored) {
        this.name = name;
        this.points = points;
        this.goalsScored = goalsScored;
    }

    // Getter for team name
    public String getName() {
        return name;
    }

    // Setter for team name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for points
    public int getPoints() {
        return points;
    }

    // Setter for points
    public void setPoints(int points) {
        this.points = points;
    }

    // Getter for goals scored
    public int getGoalsScored() {
        return goalsScored;
    }

    // Setter for goals scored
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    // Override toString() method to display team information
    @Override
    public String toString() {
        return name + " (Points: " + points + ", Goals Scored: " + goalsScored + ")";
    }

    // Override equals() method to compare teams based on name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return name.equals(team.name);
    }

    // Implement compareTo method to compare teams based on points
    @Override
    public int compareTo(Team other) {
        return Integer.compare(this.points, other.points);
    }
}
