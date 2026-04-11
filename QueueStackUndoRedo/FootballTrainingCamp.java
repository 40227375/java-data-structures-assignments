
/**
 * Write a description of class wd4fr here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FootballTrainingCamp {
    // Queue to manage players waiting for training
    private QueueAsMyLinkedList<Player> trainingQueue;
    // Stack to keep track of operations for undo/redo functionality
    private StackAsMyLinkedList<String> operationStack;

    // Constructor initializes the queue and stack
    public FootballTrainingCamp() {
        trainingQueue = new QueueAsMyLinkedList<>();
        operationStack = new StackAsMyLinkedList<>();
    }

    // Method to add a player to the training queue
    public void checkInPlayer(Player player) {
        trainingQueue.enqueue(player); // Add player to the end of the queue
        System.out.println(player + " checked in for training."); // Output the action
    }

    // Method to train the next player in the queue
    public void trainNextPlayer() {
        // Remove the player at the front of the queue
        Player player = trainingQueue.dequeue();
        
        if (player != null) {
            // If there's a player to train, process the training
            System.out.println(player + " is being trained.");
            // Record the training operation in the stack
            operationStack.push("Trained: " + player);
        } else {
            // If the queue is empty, inform the user
            System.out.println("No players to train.");
        }
    }

    // Method to undo the last training operation
    public void undoLastOperation() {
        // Remove the last operation from the stack
        String lastOperation = operationStack.pop();
        
        if (lastOperation != null) {
            // If there was an operation to undo, display it
            System.out.println("Undoing last operation: " + lastOperation);
            // Additional logic to undo the operation can be added here
        } else {
            // If the stack is empty, inform the user
            System.out.println("No operations to undo.");
        }
    }

    // Method to display the current state of the training queue and operation stack
    public void displayState() {
        // Display the contents of the training queue
        System.out.println("Current training queue: " + trainingQueue);
        // Display the history of operations stored in the stack
        System.out.println("Operation history: " + operationStack);
    }
}
