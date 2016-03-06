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
		
		if ( isEmpty() ) {
			head = newNode;
		}
		else {
			newNode.prev = tail;
			tail.next = newNode;
		}
		
		tail = newNode;
		size++;
		return true;
		
		
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	
	public E get(int index) throws IndexOutOfBoundsException
	{
		LLNode<E> curr = new LLNode<E>();
		
		if (index <= 0 || index > size()) {
			   throw new IndexOutOfBoundsException();
		}
		else {
			
			curr = goTo(index);
			
		}

		return curr.data;
	}
	
	public LLNode<E> goTo(int index){
		
		LLNode<E> curr = head;
		for (int i = 0; i < index; i++){
			curr = curr.next;
		}
		
		return curr;	
	}
	
	
	public LLNode<E> getNode(int index){
		
		LLNode<E> curr = new LLNode<E>();
		
		// begin from the side of the list closest to the index
		
		
		if (index <= 0 || index > size()) 
		{
//			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		else 
		{
			int mid = size / 2;
			if (index <= mid)
			{
				curr = head;
				for (int i = 0; i <= index; i++)
				{
					curr = curr.next;
				}
			}
			else {
				curr = tail;
				for (int i = size-1; i >= index; i--){
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
		LLNode<E> before;
		
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
			
			before = getNode(index-1);
			
		}
		
		
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		int count = 0;
		LLNode<E> curr = head;
		while (curr != null){
			curr = curr.next;
			count++;
		}
		
		return count;
		
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
			
			E returnData = null;
			
			if (index == 0){
				returnData = head.data;
				head = head.next;
				if (head == null)
				{
					tail = null;
				}
			}
			
			else {
				
			
				LLNode<E> before = getNode(index - 1);
				LLNode<E> remove = before.next;
				LLNode<E> after = remove;
				
				before.next = after;
			 
				
			}
			
			return returnData;
			
		}
		
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
		
		LLNode<E> llNode = getNode(index);
		LLNode<E> temp = llNode;
		E oldVal = temp.data;
		temp.data = element;
		return oldVal;
	
	} 
	
	
	/**
	 * Returns true if the linked list is empty
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
	public String toString() {
		if (head == null) {
			
			return "[]";
			
		} else {
			
			String result = "[" + head.data;
			LLNode<E> current = head.next;
			
			while (current != null) {
				
				result += ", " + current.data;
				current = current.next;
				
			}
			
			result += "]";
			return result;
		}
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
