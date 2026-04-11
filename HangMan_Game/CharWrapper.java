
/**
 * Write a description of class ETRYTG here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharWrapper {
    private char character; // The character this object represents
    private boolean guessed; // Whether this character has been guessed

    // Constructor to initialize the character and set guessed to false
    public CharWrapper(char character) {
        this.character = character;
        this.guessed = false; // By default, a character is not guessed
    }

    // Getter for the character
    public char getCharacter() {
        return character;
    }

    // Getter for guessed status
    public boolean isGuessed() {
        return guessed;
    }

    // Setter for guessed status
    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    // Override toString to show character if guessed, or '_' if not guessed
    @Override
    public String toString() {
        return guessed ? String.valueOf(character) : "_";
    }
}
