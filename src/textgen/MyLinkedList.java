package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author Shai Wilson
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	private LLNode<E> head;
	private LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		// create new node
		LLNode<E> newNode = new LLNode<E>(element);
		
		newNode.next = tail;
		newNode.prev = tail.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		
		size++;
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		
		LLNode<E> curr = new LLNode<E>();
		
		// begin from the side of the list closest to the index
		
		int mid = size / 2;
		
		if (index < 0 || index > size - 1) 
			throw new IndexOutOfBoundsException();
		else 
		{
			if (index <= mid)
			{
				curr = head;
				for (int i = 0; i < index; i++)
				{
					curr = curr.next;
				}
			}
			else {
				
				curr = tail;
				for (int i = size-1; i > index; i--){
					curr = curr.prev;
				}
			}
		}
		
		
		return curr.data;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode()
	{
		this.next = null;
		this.prev = null;
		this.data = null;
	}

	public LLNode(E theData) 
	{
		this.data = theData;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E theData, LLNode<E> prevNode)
	{
		
		this(theData);
		this.next = prevNode.next;
		prevNode.next = this;
		
	}

}
