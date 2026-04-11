
/**
 * Write a description of class frgtb here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class StackAsMyLinkedList<E> 
{   
	MyLinkedList<E> theStack;
    public StackAsMyLinkedList()
    {  theStack = new MyLinkedList<E>();       
    }
	
    public void push(E newElement) //insert at head
    {  
		   theStack.prepend(newElement);
    }
	
	public E pop() //remove from head
    {  
		E temp = null;
		boolean isDone = false;
		
		temp = theStack.getFirst();
		if (temp != null)
		{
			isDone=theStack.delete(temp);
		}
		if (isDone)
			return temp;
		else
			return null;
    }
	public String toString()
	{
		return theStack.toString();
	}
  
}//end class

