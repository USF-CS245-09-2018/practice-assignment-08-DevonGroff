public class LinkedList implements List
{
	// Data Members
	private Node head;

	// Default Constructor 
	public LinkedList()
	{
		head = null;
	}

	// A method to add an item to the end of the linked list. 
	public void add(Object obj) throws Exception
	{
		// Creates a new node to be added to the linked list.
		Node node = new Node(obj, head);

		// Adds the node to the head of the linked list.
		head = node;
	}
	
	// A method to add an item to a specific position in the linked list.
	public void add(int pos, Object obj) throws Exception
	{
		// Conditional for if the index position is less than the linked list head.
       if (pos < 0)
       {
            throw new IndexOutOfBoundsException();
       }

       // Conditional to add to head if the index position is 0.
        if (pos == 0) 
        {
        	// Adds object to head.
             add(obj);
        }

        else
        {
        	// Creates a new node at the head.
	        Node previous = head;
	        int i = 0;

	        // Loops through as long as the previous position isn't empty and i is less than the position before the index.
	        while (previous != null && i < pos - 1) 
	        {
	        	// Sets the previous node value to the next node value.
	            previous = previous.next;
	            i++;
	        }

	        // Conditional for if the previous points to null.
	        if (previous == null)
	        {
	            throw new NullPointerException();
	        }

	        // Sets the value after the previous to a new node with the value/object to be added.
	        previous.next = new Node(obj, previous.next);
	    }
	}
	
	// A method to get a value from a given position in the linked list.
	public Object get(int pos) throws Exception
	{
		// Conditional for if the index position is less than the linked list head.
		if (pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}

		// Creates a new node at the head.
		Node current = head;
		int i = 0;

		// Loops through as long as the preivous position isn't empty and i is less than the position.
		while (current != null && i < pos)
		{
			// Sets the current node value to the next node value.
			current = current.next;
			i++;
		}

		// Conditional to return the value as long as it's not null.
		if (current != null)
		{
			return current.value;
		}

		// Throws exception if value is null.
		else
		{
			throw new NullPointerException();
		}
	}
	
	// A method to remove an item from a given position in the linked list.
	public Object remove(int pos) throws Exception
	{
		// Conditional if the list is empty.
		if (head == null)
		{
			return null;
		}

		// Creates a new object for the node to be removed.
		Object removedNode = null;

		// Conditional if the position is at the head.
		if (pos == 0)
		{
			removedNode = head.value;
			head = head.next;
			return removedNode;
		}

		// Sets the previous value to the head.
		Node previous = head;
		int i = 0;
		
		// Loops through as long as the previous position isn't empty and i is less than the position before the index.
		while (previous != null && i < pos - 1)
		{
			// Sets the previous node value to the next node value.
			previous = previous.next;
			i++;
		}

		// Conditional for if the previous value is empty or the value after previous is empty.
		if (previous == null || previous.next == null)
		{
			throw new IndexOutOfBoundsException();
		}

		// Removes the value and sends the pointer to the value after.
		removedNode = previous.next.value;
		previous.next = previous.next.next;

		// Returns the node that was removed.
		return removedNode;
	}
	
	// A method to retrieve the size of the linked list.
	public int size()
	{
		// Creates a new node at the head.
		Node current = head;
		int counter = 0;

		// Loops until we reach the end of the linked list.
		while (current != null)
		{
			// Increments and counts value.
			current = current.next;
			counter++;
		}

		// Returns the size of the linked list.
		return counter;
	}

	// Internal class Node for storing and linking.
	private class Node 
    { 
    	// Data Members.
    	Object value;
    	Node next;

    	// Default constructor for the node.
    	Node()
    	{
    		this.value = null;
    		this.next = null;
    	}

    	// Constructor that creates a new node.
    	Node(Object value, Node next)
    	{
    		this.value = value;
    		this.next = next;
    	}

    	// Gets the next node.
    	Node next()
    	{
    		return next;
    	}

    	// Returns the value inside of the node.
    	Object value()
    	{
    		return value;
    	}
    }
}