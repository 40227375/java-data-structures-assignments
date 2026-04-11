
/**
 * Write a description of class vdf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class QueueAsMyLinkedList<E>
{   
	private MyLinkedList<E> theQueue;  // list header
	
	
    public QueueAsMyLinkedList()
    {  theQueue = new MyLinkedList<E>();       
    }
	
    public void enqueue(E newElement) //insert at tail
    {  
		   theQueue.append(newElement);
    }
	
	public  E dequeue() //remove from head
    {  
		E temp = null;
		boolean isDone = false;
		
		temp = theQueue.getFirst();
		if (temp != null)
		{
			isDone=theQueue.delete(temp);
		}
		if (isDone)
			return temp;
		else
			return null;
    }
	public String toString()
	{
		return theQueue.toString();
	}
   
}//end class

