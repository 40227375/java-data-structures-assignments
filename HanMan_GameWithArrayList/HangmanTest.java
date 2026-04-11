
/**
 * Write a description of class YTGUYHKJ here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HangmanTest {
    public static void main(String[] args) {
        MyArrayList<String> wordsList = new MyArrayList<>();

        // Step 1: Read words from a file and store them in the wordsList
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String word;
            while ((word = br.readLine()) != null) {
                wordsList.add(wordsList.size(), word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 3: Select a random word from wordsList
        Random random = new Random();
        String randomWord = wordsList.get(random.nextInt(wordsList.size()));

        // Step 3: Load the selected word into a MyArrayList of CharWrapper objects
        MyArrayList<CharWrapper> wordList = loadWord(randomWord);

        // Step 6: Game loop - Keep asking the user for guesses until they win or run out of attempts
        Scanner scanner = new Scanner(System.in);
        int attempts = 7; // Number of wrong attempts allowed

        while (attempts > 0) {
            // Display the current state of the word (with guessed and unguessed characters)
            System.out.println("Word: " + wordList);
            System.out.print("Enter your guess: ");
            char guess = scanner.nextLine().charAt(0); // Get the user's guess

            if (wordList.verifyGuess(guess)) {
                System.out.println("Correct guess!");
                if (wordList.verifyWinner()) {
                    System.out.println("Congratulations! You've guessed the word: " + randomWord);
                    break; // Exit the loop if the user has guessed the entire word
                }
            } else {
                attempts--; // Decrease the number of attempts if the guess was incorrect
                System.out.println("Incorrect guess! Attempts left: " + attempts);
            }
        }

        if (attempts == 0) {
            System.out.println("Game Over! The word was: " + randomWord); // Display the correct word if the user runs out of attempts
        }

        scanner.close(); // Close the scanner
    }

    // Step 3: Method to load a word into a MyArrayList of CharWrapper objects
    public static MyArrayList<CharWrapper> loadWord(String word) {
        MyArrayList<CharWrapper> wordList = new MyArrayList<>();
        for (char c : word.toCharArray()) {
            wordList.add(wordList.size(), new CharWrapper(c)); // Add each character of the word to the list
        }
        return wordList;
    }
}
