
/**
 * Write a description of class BubbleSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BubbleSort
{
    

    // Method to perform Bubble Sort and display each step
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // Display the initial array
        System.out.println("Initial array:");
        displayArray(arr);

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\n--- Pass " + (i + 1) + " ---");
            boolean swapped = false;

            // Last i elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {
                // Show comparison
                System.out.println("Comparing " + arr[j] + " and " + arr[j + 1]);

                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    System.out.println("Swapping " + arr[j] + " and " + arr[j + 1]);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }

                // Display the array after each comparison
                displayArray(arr);
            }

            // If no elements were swapped, the array is already sorted
            if (!swapped) {
                System.out.println("\nNo swaps done, the array is sorted.");
                break;
            }
        }

        // Final sorted array
        System.out.println("\nSorted array:");
        displayArray(arr);
    }

    // Method to display the current state of the array
    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        // Call the bubbleSort method
        bubbleSort(arr);
    }
}



