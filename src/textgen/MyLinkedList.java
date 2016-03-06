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

		LLNode<E> newNode = new LLNode<E>(element);
		
		newNode.next = tail;
		newNode.prev = tail.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		
		size++;
		
		return true;
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	
	public LLNode<E> get(int index) 
	{
		
		LLNode<E> curr = null;
		
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
		
		return curr;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		LLNode<E> newNode = new LLNode<E>(element);
		
		// inserting into an empty list
		if ( isEmpty() ){
			head = newNode;
			tail = newNode;
		}
		
		// inserting at the beg of a non-empty list
		else if (index == 0){
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			
		}
		
		// inserting at the end of a non-empty list
		else if ( index == size() ){
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		
		// inserting somewhere else
		
		else {
			
			LLNode before = (LLNode) get(index-1);
			
		}
		
		
		
		
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
		
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		else {
			
			E returnData;
			
			if (index == 0){
				returnData = head.data;
				head = head.next;
				if (head == null)
				{
					tail = null;
				}
			}
			
			else {
				
			
				LLNode before = (LLNode) get(index - 1);
				LLNode remove = before.next;
				LLNode after = remove;
				
				before.next = after;
				if 
				
			}
			
			
		}
		
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
		LLNode<E> temp = get(index);
		E oldVal = temp.data;
		temp.data = element;
		return oldVal;
		
	} 
	
	
	/**
	 * Returns true if the linked list is empty
	 * 
	 */
	
	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This method reverses the list by walking through the list, swapping
     * the next and prev pointers of every node. It then swaps the head and
     * tail.
	 * 
	 */
	
	public void reverse(){
		
		LLNode<E> curr = head;
		
		while (curr != null){
			LLNode<E> nextNode = curr.next;
			curr.next = curr.prev;
			curr.prev = nextNode;
			
			if(nextNode != null)
			{
				nextNode.next = curr;
				
			}
			
			curr = curr.next;
		}
		
		LLNode<E> oldHead = head;
		head = tail;
		tail = oldHead;
		
	}
	
	/// For output
	public String toString(){
		
		StringBuilder sb = new StringBuilder("[");
		LLNode<E> curr = head;
		
		while (curr != null){
			
			sb.append(curr.data);
			if (curr.next != null){
			
				sb.append(", ");
			}
			
			curr = curr.next;
			
		}
		
		sb.append("]");
		return sb.toString();
		
	}
		
} // close double linked list class

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
	
	public String toString(){
		return data.toString();
	}

}
