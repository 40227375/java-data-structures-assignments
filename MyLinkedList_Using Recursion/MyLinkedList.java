
/**
 * Write a description of class sdfgh here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyLinkedList<E extends Comparable<E>> {
    private Node<E> head, tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (head == null) {
            return null;
        } else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (head == null) {
            return null;
        } else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void prepend(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // Link the new node with the head
        head = newNode; // Head points to the new node

        if (tail == null) { // The new node is the only node in the list
            tail = head;
        }
    }

    /** Add an element to the end of the list */
    public void append(E item) {
        Node<E> newNode = new Node<>(item); // Create a new node

        if (head == null) {
            head = tail = newNode; // The new node is the only node in the list
        } else {
            tail.next = newNode; // Link the new node with the last node
            tail = newNode; // Tail now points to the last node
        }
    }

    /** Remove the head node and return the object that is contained in the removed node */
    public E removeFirst() {
        if (head == null) {
            return null;
        } else {
            E temp = head.element;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return temp;
        }
    }

    public boolean delete(E item) {
        Node<E> ptr = head;
        Node<E> prvPtr = null;
        while (ptr != null && ptr.element.compareTo(item) != 0) {
            prvPtr = ptr;
            ptr = ptr.next;
        }
        if (ptr == null) { // Item not found
            return false;
        }
        if (ptr == head) { // Item is the first element
            head = head.next;
        } else { // General case
            prvPtr.next = ptr.next;
        }
        if (ptr == tail) { // Last element
            tail = prvPtr;
        }
        return true;
    }

    /** 
 * Recursively reverse the linked list.
 * This method initializes the reversal process and adjusts the tail reference.
 */
public void recursiveReverse() {
    head = recursiveReverseHelper(head); // Start recursion from the head node.
    
    // After reversing, update the tail to point to the new last node.
    if (head != null) {
        Node<E> ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next; // Traverse to the end of the list to find the new tail.
        }
        tail = ptr; // Assign the last node as the new tail.
    }
}

/** 
 * Helper method to reverse the list recursively.
 * This method performs the core recursive logic to reverse the list.
 * @param node the current node being processed in the recursion
 * @return the new head node of the reversed segment
 */
private Node<E> recursiveReverseHelper(Node<E> node) {
    // Base case: if the node is null or the last node, it becomes the new head.
    if (node == null || node.next == null) {
        return node; // Return the current node as the new head of the reversed list.
    }

    // Recursively reverse the rest of the list starting from the next node.
    Node<E> newHead = recursiveReverseHelper(node.next);
    
    // Reverse the direction of the current node's link.
    node.next.next = node; // The next node points back to the current node.
    
    // Break the original forward link to prevent cycles in the reversed list.
    node.next = null;

    // Return the new head of the reversed list to the previous recursive call.
    return newHead;
}

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> ptr = head;
        while (ptr != null) {
            result.append(ptr.element.toString());
            if (ptr.next != null) {
                result.append(",");
            }
            ptr = ptr.next;
        }
        result.append("]");
        return result.toString();
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }
}
