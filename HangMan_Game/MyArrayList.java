
/**
 * Write a description of class dfgh here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 
public class MyArrayList<E> {
    private int size; // Number of elements in the list
    private E[] data; // Array to store the elements

    /** Create an empty list with an initial capacity of 100 */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        data = (E[]) new Object[100]; // Initial capacity of 100
        size = 0; // Start with zero elements
    }

    // Add an element to the end of the list
    public void add(E e) {
        if (size == data.length) {
            resize(); // Resize the array if it's full
        }
        data[size++] = e; // Add element and increment size
    }

    // Resize the array to double its current length
    private void resize() {
        @SuppressWarnings("unchecked")
        E[] newData = (E[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    // Check if the list contains a specific element
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++)
            if (e.equals(data[i])) return true;
        return false;
    }

    // Get the element at a specific index
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return data[index];
    }

    // Return the number of elements in the list
    public int size() {
        return size;
    }

    // Return a string representation of the list
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
}
