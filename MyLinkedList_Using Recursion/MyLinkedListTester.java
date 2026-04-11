
/**
 * Write a description of class dgfhg here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyLinkedListTester {
    public static void main(String[] args) {
        // Create a new linked list
        MyLinkedList<Integer> list = new MyLinkedList<>();
        
        // Append some elements to the list
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        
        // Print the original list
        System.out.println("Original List: " + list);

        // Reverse the list using recursion
        list.recursiveReverse();
        
        // Print the reversed list
        System.out.println("Reversed List: " + list);
    }
}
