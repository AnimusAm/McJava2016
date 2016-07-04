package hr.fer.zemris.java.custom.collections;

/**
 * Class implements stack collection.
 * Class is "adapter design pattern" representation,
 * wrapping <code>ArrayBackedIndexedCollection</code> as "adaptee" 
 * @author Animus
 *
 */
public class ObjectStack {
	
	private ArrayBackedIndexedCollection stack;
	
	public ObjectStack()
	{
		this.stack = new ArrayBackedIndexedCollection();
	}
	
	/**
	 * Method checks if stack collection is empty.
	 * Wrapper for <code>ArrayBackedIndexedCollection</code> <code>isEmpty</code> method
	 * @return - true - if collection is empty, false - otherwise
	 */
	boolean isEmpty()
	{
		return this.stack.isEmpty();
	}
	
	/**
	 * Method gives size of the stack collection.
	 * Wrapper for <code>ArrayBackedIndexedCollection</code> <code>size</code> method
	 * @return - number of elements stored on the stack.
	 */
	int size()
	{
		return this.stack.size();
	}

	/**
	 * Method pushes element on the top of the stack.
	 * Since <code>NULLs</code> are not permitted, on pushing of <code>NULL</code>, 
	 * 	<code>IllegalArgumentException</code> is thrown.
	 * @param value - element to be pushed.
	 */
	void push(Object value)
	{
		
		try
		{
			this.stack.add(value);
		} 
		catch (IllegalArgumentException exc)
		{
			throw new IllegalArgumentException("Attempt to add NULL element on the stack! "
				+ "NULL elements are not allowed in collection.");
		}
	}
	
	/**
	 * Method returns and removes last (the top one) element from the stack.
	 * 
	 * Could throw:
	 * 	<code>IndexOutOfBoundsException</code> if wrong index of element to be popped,
	 * 			in internal action of element popping.
	 *  <code>EmptyStackException</code> if popping is tried while the stack is already empty.
	 * @return - returns element that was removed from the top of the stack.
	 */
	Object pop()
	{
		if (! this.isEmpty())
		{
			Object return_value;
			try
			{
				return_value = this.stack.get(this.size()-1);
				this.stack.remove(this.size()-1);
				return return_value;
			}
			catch (IndexOutOfBoundsException exc)
			{
				throw exc;
			}
			
		}
		else
			throw new EmptyStackException("Stack is EMPTY! Can't pop from an empty stack.");
	}
	
	/**
	 * Method returns but doesn't remove last (the top one) element from the stack.
	 * 
	 * Could throw:
	 * 	<code>IndexOutOfBoundsException</code> if wrong index of element to be peeked,
	 * 			in internal action of element peeking.
	 *  <code>EmptyStackException</code> if peeking is tried while the stack is already empty.
	 * @return - returns element that was returned from the top of the stack.
	 */
	Object peek()
	{
		if (! this.isEmpty())
		{
			
			try
			{
				return this.stack.get(this.size()-1);
			}
			catch (IndexOutOfBoundsException exc)
			{
				throw exc;
			}
			
		}
		else
			throw new EmptyStackException("Stack is EMPTY! Can't peek on an empty stack.");
	}
	
	/**
	 * Method removes all elements from the stack.
	 */
	void clear()
	{
		this.stack.clear();
	}
}
