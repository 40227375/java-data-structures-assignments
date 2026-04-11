import java.io.*; // For reading files
import java.util.Random; // For selecting a random word
import java.util.Scanner; // For getting user input

// Main class for the Hangman game
public class HangmanGame {
    private MyArrayList<String> words = new MyArrayList<>(); // List to store words from file

    // Method to load words from a text file into the MyArrayList
    public void loadWordsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String word;
            while ((word = br.readLine()) != null) { // Read each line
                word = word.trim(); // Trim any leading/trailing spaces
                if (!word.isEmpty()) { // Check if the word is not empty
                    System.out.println("Adding word: " + word); // Debug: print each word
                    words.add(word); // Add trimmed word to list
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage()); // Handle errors
        }
    }

    // Method to get a random word from the list
    public String getRandomWord() {
        Random random = new Random(); // Create a Random object
        int index = random.nextInt(words.size()); // Get a random index
        return words.get(index); // Return word at random index
    }

    // Method to load a word into a list of CharWrapper objects
    public MyArrayList<CharWrapper> loadWord(String word) {
        MyArrayList<CharWrapper> charList = new MyArrayList<>();
        for (char c : word.toCharArray()) { // Convert word to character array
            charList.add(new CharWrapper(c)); // Add each character to the list
        }
        return charList;
    }

    // Main game loop
    public void play() {
        String randomWord = getRandomWord(); // Get a random word
        MyArrayList<CharWrapper> wordList = loadWord(randomWord); // Load it into CharWrapper list
        int attempts = 6; // Number of wrong guesses allowed
        Scanner scanner = new Scanner(System.in); // For user input

        // Game loop, continues while attempts are left
        while (attempts > 0) {
            System.out.println("\nWord: " + displayWord(wordList)); // Display the word with guessed characters
            System.out.println("Attempts remaining: " + attempts);
            System.out.print("Guess a letter: ");
            
            String input = scanner.nextLine(); // Read the user's guess
            if (input.isEmpty()) {
                System.out.println("Please enter a valid letter.");
                continue;
            }
            
            char guess = input.charAt(0); // Get the first character
            boolean correctGuess = false; // Track if the guess was correct

            // Check if the guessed letter is in the word
            for (int i = 0; i < wordList.size(); i++) {
                CharWrapper cw = wordList.get(i);
                if (cw.getCharacter() == guess && !cw.isGuessed()) {
                    cw.setGuessed(true); // Mark character as guessed
                    correctGuess = true; // Indicate a correct guess
                }
            }

            if (!correctGuess) {
                attempts--; // Decrease attempts if guess is incorrect
            }

            // Check if the word is fully guessed
            if (isWordGuessed(wordList)) {
                System.out.println("Congratulations! You've guessed the word: " + randomWord);
                return; // Exit the game if the word is guessed
            }
        }

        // If all attempts are used, the player loses
        System.out.println("Sorry, you've run out of attempts. The word was: " + randomWord);
    }

    // Helper method to check if the entire word has been guessed
    private boolean isWordGuessed(MyArrayList<CharWrapper> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (!wordList.get(i).isGuessed()) { // If any character is not guessed
                return false; // The word is not fully guessed
            }
        }
        return true; // All characters guessed
    }

    // Method to display the current state of the word
    private String displayWord(MyArrayList<CharWrapper> wordList) {
        StringBuilder displayedWord = new StringBuilder();
        for (int i = 0; i < wordList.size(); i++) {
            CharWrapper cw = wordList.get(i);
            displayedWord.append(cw.toString()); // Use CharWrapper's toString() method
            displayedWord.append(' '); // Add space between characters
        }
        return displayedWord.toString().trim(); // Trim trailing space
    }

    // Main method to run the game
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame(); // Create a game instance
        game.loadWordsFromFile("words.txt"); // Load words from file
        game.play(); // Start the game
    }
}
