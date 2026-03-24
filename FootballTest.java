
/**
 * Write a description of class FootballTest here.
 *
 * @author (Thando Mavuso)
 * @version (a version number or a date)
 */
public class FootballTest {
    public static void main(String[] args) {
        Football mancity = new Mancity("Manchester City", "Premier League");
        Football barcelona = new Barcelona("FC Barcelona", true);
        
        // Polymorphism in action
        teamMakesWin(mancity);
        teamMakesWin(barcelona);
        
        // Implicit and explicit toString method calls
        System.out.println(mancity); // Implicit call
        System.out.println(barcelona.toString()); // Explicit call
    }
    
    // Method demonstrating polymorphism
    public static void teamMakesWin(Football football) {
        football.winTrophy();
    }
}

