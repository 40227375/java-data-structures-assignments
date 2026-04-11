// Custom ArrayList class to manage a list of Team objects
public class MyArrayList<E> {
    private int size; // Number of elements in the list
    private E[] data; // Array to store list elements

    // Constructor to create an empty list
    public MyArrayList() {
        data = (E[]) new Object[100]; // Array of generics can't be created directly
        size = 0; // Initialize size to 0
    }

    // Method to add an element at a specific index
    public void add(int index, E e) {
        // Check if the index is valid
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        // Move elements to the right to make space for the new element
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        // Insert new element
        data[index] = e;
        size++; // Increase size
    }

    // Method to check if the list contains a specific element
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++)
            if (e.equals(data[i])) return true; // Use equals() to compare elements
        return false;
    }

    // Method to get an element at a specific index
    public E get(int index) {
        // Check if the index is valid
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return data[index]; // Return the element
    }

    // Method to remove an element at a specific index
    public E remove(int index) {
        // Check if the index is valid
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        E e = data[index]; // Store the element to be removed
        // Shift elements to the left to fill the gap
        for (int j = index; j < size - 1; j++)
            data[j] = data[j + 1];

        data[size - 1] = null; // Clear the last element
        size--; // Decrease size
        return e; // Return the removed element
    }

    // Method to convert the list to a string representation
    public String toString() {
        String result = " ";
        for (int i = 0; i < size; i++) {
            result += data[i];
            if (i < size - 1) result += ", ";
        }
        return result.toString() + "]";
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Method to sort the list using bubble sort
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

    // Method to get the maximum value in the list
    public E getMax() {
        if (size == 0) return null;
        E max = data[0];
        for (int i = 1; i < size; i++) {
            if (((Comparable) data[i]).compareTo(max) > 0) {
                max = data[i];
            }
        }
        return max;
    }

    // Method to get the minimum value in the list
    public E getMin() {
        if (size == 0) return null;
        E min = data[0];
        for (int i = 1; i < size; i++) {
            if (((Comparable) data[i]).compareTo(min) < 0) {
                min = data[i];
            }
        }
        return min;
    }

    // Method to get unique elements from the list
    public MyArrayList<E> getUnique() {
        MyArrayList<E> uniqueList = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            if (!uniqueList.contains(data[i])) {
                uniqueList.add(uniqueList.size(), data[i]);
            }
        }
        return uniqueList;
    }

    // Method to check if the list is a palindrome
    public boolean isPalindrome() {
        for (int i = 0; i < size / 2; i++) {
            if (!data[i].equals(data[size - 1 - i])) {
                return false;
            }
        }
        return true;
    }

    // Method to get elements larger than a specified value
    public MyArrayList<E> getFiltered(E e) {
        MyArrayList<E> filteredList = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            if (((Comparable) data[i]).compareTo(e) > 0) {
                filteredList.add(filteredList.size(), data[i]);
            }
        }
        return filteredList;
    }
}
