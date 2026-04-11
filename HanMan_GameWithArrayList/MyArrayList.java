
/**
 * Write a description of class ETRGH here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyArrayList<E> {
    private int size; // Number of elements in the list
    private E[] data;

    /** Create an empty list */
    public MyArrayList() {
        data = (E[]) new Object[100]; // cannot create array of generics
        size = 0; // Number of elements in the list
    }

    public void add(int index, E e) {
        // Ensure the index is in the right range
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        // Move the elements to the right after the specified index
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        // Insert new element to data[index]
        data[index] = e;
        // Increase size by 1
        size++;
    }

    public boolean contains(Object e) {
        for (int i = 0; i < size; i++)
            if (e.equals(data[i]))
                return true;
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return data[index];
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        E e = data[index];
        // Shift data to the left
        for (int j = index; j < size - 1; j++)
            data[j] = data[j + 1];
        data[size - 1] = null; // This element is now null
        // Decrement size
        size--;
        return e;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += data[i];
            if (i < size - 1)
                result += ", ";
        }
        return result + "]";
    }

    public int size() {
        return size;
    }

    public boolean sortList() {
        E hold;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (((Comparable) data[j]).compareTo(data[j + 1]) > 0) {
                    hold = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = hold;
                }
            }
        }
        return true;
    }

    // Method to verify if a guessed character is in the word
    public boolean verifyGuess(char guess) {
        boolean found = false; // Flag to indicate if the guess was correct
        // Loop through the list to check each character
        for (int i = 0; i < this.size; i++) {
            CharWrapper wrapper = (CharWrapper) this.get(i);
            if (wrapper.getCharacter() == guess) {
                wrapper.setGuessed(true); // Mark the character as guessed
                found = true; // Set the flag to true
            }
        }
        return found; // Return whether the guess was correct
    }

    // Method to check if all characters in the word have been guessed
    public boolean verifyWinner() {
        // Loop through the list to check each character
        for (int i = 0; i < this.size; i++) {
            CharWrapper wrapper = (CharWrapper) this.get(i);
            if (!wrapper.isGuessed()) {
                return false; // Return false if any character is not guessed
            }
        }
        return true; // Return true if all characters are guessed
    }
}

