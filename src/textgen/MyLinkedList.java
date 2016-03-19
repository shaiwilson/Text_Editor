package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author Shai Wilson
 *
 * @param <E> The type of the elements stored in the list
 */


public class MyLinkedList<E> extends AbstractList<E> {
	
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	
	/** Create a new empty LinkedList */
	public MyLinkedList() {
		
		size = 0;
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next = this.tail;
		this.tail.prev = this.head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	
	public boolean add(E element ) 
	{
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		

		LLNode<E> nodeToAdd = new LLNode<E>(element);
		LLNode<E> prev = tail.prev;
		prev.next = nodeToAdd;
		nodeToAdd.prev = prev;
		nodeToAdd.next = tail;
		tail.prev = nodeToAdd;
		size++;
		return true;
			
			
//			option 2			
//			newNode.next = tail;
//			newNode.prev = tail.prev;
//			newNode.next.prev = newNode;
//			newNode.prev.next = newNode;
			
		
	
	}
	

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	
	public E get(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index >= size()) {
		      throw new IndexOutOfBoundsException("Invalid BasicArrayList index");
		 }
		
		LLNode<E> target = head;
		
		for (int i = 0; i <= index; i++) {
			
			target = target.next;
		}
		
		return target.data;
			
	}
	
	/** Get the node at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	
	public LLNode<E> goTo(int index){
		
		if (index < 0 || index >= size()) {
		      throw new IndexOutOfBoundsException("Invalid BasicArrayList index");
		 }
		
		LLNode<E> curr = head;
		for (int i = 0; i < index && curr.next != null; i++){
			curr = curr.next;
		}
		
		return curr;	
	}
	
	/** Optimization: Get the node at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	
	public LLNode<E> getNode(int index){
		
		LLNode<E> curr = new LLNode<E>();
		
		// begin from the side of the list closest to the index
		
		
		if (index <= 0 || index > size) 
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
		
		
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		if ((index < 0 || index > size - 1) && (index != 0 || size != 0)) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
		
		// inserting at the end of a non-empty list
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> curr = head;
		
		for (int i = 0; i <= index; i++) {
			curr = curr.next;
		}
		
		LLNode<E> prev = curr.prev;
		prev.next = newNode;
		newNode.prev = prev;
		newNode.next = curr;
		curr.prev = newNode;
		size++;
		
		
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
		
		if (index < 0 || index > size - 1)
		{
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> nodeToRemove = head;
		
		for (int i = 0; i <= index; i++) {
			
			nodeToRemove = nodeToRemove.next;
			
		}
		
		// System.out.println(nodeToRemove.data);
		
		LLNode<E> prev = nodeToRemove.prev;
		LLNode<E> next = nodeToRemove.next;
		
		//System.out.println(prev.data);
		
		prev.next = next;
		next.prev = prev;
		size--;
		E value = nodeToRemove.data;
		return value;
			
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
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		
		LLNode<E> nodeToSet = head;
		for (int i = 0; i <= index; i++) {
			nodeToSet = nodeToSet.next;
		}
		nodeToSet.data = element;
		return element;
	
		// option 2
//		LLNode<E> llNode = getNode(index);
//		LLNode<E> temp = llNode;
//		E oldVal = temp.data;
//		temp.data = element;
//		return oldVal;
	
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
