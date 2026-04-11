
/**
 * Write a description of class dfgh here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// Test class to simulate the operations of the FootballTrainingCamp
public class FootballTrainingCampTest {
    public static void main(String[] args) {
        // Create an instance of the FootballTrainingCamp
        FootballTrainingCamp camp = new FootballTrainingCamp();

        // Create some players with names and positions
        Player player1 = new Player("Lionel Messi", "Forward");
        Player player2 = new Player("Cristiano Ronaldo", "Forward");
        Player player3 = new Player("Virgil van Dijk", "Defender");

        // Simulate checking in players for training
        camp.checkInPlayer(player1);
        camp.checkInPlayer(player2);
        camp.checkInPlayer(player3);

        // Display the current state of the camp
        camp.displayState();

        // Simulate training the next players in the queue
        camp.trainNextPlayer();
        camp.trainNextPlayer();

        // Display the state after training some players
        camp.displayState();

        // Simulate undoing the last training operation
        camp.undoLastOperation();
        // Display the state after undoing the last operation
        camp.displayState();
    }
}