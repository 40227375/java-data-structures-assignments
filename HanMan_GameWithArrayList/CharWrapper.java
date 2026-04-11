
/**
 * Write a description of class REDFGHGJH here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharWrapper {
    private char character; // The character being wrapped
    private boolean guessed; // Flag to indicate if the character has been guessed

    // Constructor to initialize the character and set guessed to false
    public CharWrapper(char character) {
        this.character = character;
        this.guessed = false;
    }

    // Getter method to retrieve the character
    public char getCharacter() {
        return character;
    }

    // Getter method to check if the character has been guessed
    public boolean isGuessed() {
        return guessed;
    }

    // Setter method to mark the character as guessed
    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    // Override toString method to return the character if guessed, or "_" if not guessed
    @Override
    public String toString() {
        return guessed ? String.valueOf(character) : "_";
    }
}
