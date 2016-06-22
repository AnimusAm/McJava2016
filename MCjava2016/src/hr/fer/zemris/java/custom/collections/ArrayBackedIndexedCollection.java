package hr.fer.zemris.java.custom.collections;

import java.util.Arrays;

/**
 * Class implements array backed index collection.
 * Duplicates are allowed, <code>NULLs</code> are not allowed.
 * Capacity determines max size of the collection, and collection data structure
 * is reallocated when size meats capacity.
 * @author Animus
 *
 */
public class ArrayBackedIndexedCollection {
	
	// initial capacity
	// if capacity is not given, initial capacity of allocated array is set to this value.
	private final int INITIAL_CAPACITY = 16;
	
	// current size of collection
	private int size;
	// current capacity of allocated array of object references
	private int capacity;
	
	// an array of object references which length is determined by capacity variable
	private Object[] elements;
	
	/**
	 * Initial constructor.
	 * Creates instance of collection, with initial capacity and zero size.
	 */
	public ArrayBackedIndexedCollection()
	{
		this.size = 0;
		this.capacity = this.INITIAL_CAPACITY;
		this.elements = new Object[this.capacity];
	}

	/**
	 * Creates instance of collection, with given capacity.
	 * Size is set to zero. 
	 * If invalid value of capacity is given (less than 1), <code>IllegalArgumentException</code> is thrown.
	 * @param initialCapacity - capacity allocated array of elements.
	 */
	public ArrayBackedIndexedCollection(int initialCapacity)
	{
		if (initialCapacity > 0)
		{
			this.size = 0;
			this.capacity = initialCapacity;
			this.elements = new Object[this.capacity];
		}
		else
		{
			throw new IllegalArgumentException("Can't create colection with capacity less than 1.");
		}
	}
	
	/**
	 * Checks if collection is empty.
	 * Check is made based on the size - size will be 0 if collection contains no elements.
	 * Class itself should seek to keep to this integrity.  
	 * @return true - if collection contains elements (size > 0), false - otherwise
	 */
	public boolean isEmpty()
	{
		return this.size > 0 ? false : true;
	}
	
	/**
	 * Returns the number of currently stored objects in collection.
	 * Returned number is real size of collection - internal variable that stores size of collection.
	 * Class itself should seek to maintain size accordingly .
	 * @return size of collection = number of elements currently stored in it. 
	 */
	public int size()
	{
		return this.size;
	}
	
	/**
	 * Adds element in the last place in the collection.
	 * If collection is full, storage structure is reallocated (by doubling capacity).
	 * Since <code>NULLs</code> are not permitted, on insertion of <code>NULL</code>, 
	 * 	<code>IllegalArgumentException</code> is thrown.
	 * @param value - new element to be inserted into end of the collection.
	 */
	void add(Object value)
	{
		if (value != null)
		{
			// reallocation is needed if by inserting new element, collection gets full
			if(this.size+1 > this.capacity)
			{
				// newly allocated capacity is doubled
				this.capacity = this.capacity * 2;
				this.elements = Arrays.copyOfRange(this.elements, 0, this.capacity);
				// size didn't change
			}
			this.elements[this.size] = value;
			this.size++;
		}
		else
		{
			throw new IllegalArgumentException("Attempt to add NULL element! "
					+ "NULL elements are not allowed in collection.");
		}
	}
		
	/**
	 * Returns element from position <code>i</code>. 
	 * In collection, element is not removed. (Size remains the same.)
	 * Allowed values for index are from 0 to size-1.
	 * If given index exceeds this limits, <code>IndexOutOfBoundsException</code> is thrown.
	 * @param index - position of the element that is fetched.
	 * @return element in given position.
	 */
	public Object get(int index)
	{
		if (index >= 0 && index < this.size)
		{
			return this.elements[index];
		}
		else
			throw new IndexOutOfBoundsException("Can't fetch element that is in position that exceeds boundaries of possible elements positions.");
			
	}
	
	/**
	 * Removes element from the collection.
	 * Since collection can't hold <code>NULLs</code> rest of the elements,
	 * behind the one that is removed, are shifted one position down.
	 * Capacity is not changed.
	 * Allowed values for index are from 0 to size-1.
	 * If given index exceeds this limits, <code>IndexOutOfBoundsException</code> is thrown.
	 * @param index - position of the element that is removed.
	 */
	public void remove(int index)
	{
		if (index >= 0 && index < this.size)
		{
			Object[] elements_copy = new Object[this.capacity];
			// copy of elements is made, so that it contains part of the elements before index that is removed
			// and other part behind index that is removed
			System.arraycopy(this.elements, 0, elements_copy, 0, index);
			System.arraycopy(this.elements, index+1, elements_copy, index, this.size-index-1);
			this.elements = elements_copy;
			this.size--;
		}
		else
			throw new IndexOutOfBoundsException("Can't remove element that is in position that exceeds boundaries of possible elements positions.");
	}
	
	/**
	 * Inserts new element in the given position.
	 * Valid positions are 0 to size-1.
	 * If index out of this range is given, <code>IndexOutOfBoundsException</code> is thrown. 
	 * Since <code>NULLs</code> are not allowed, if value is <code>NULL</code>, <code>IllegalArgumentException</code> is thrown. 
	 * If by adding new element size exceeds capacity, capacity i doubled before adding new element.
	 * @param value
	 * @param position
	 */
	public void insert(Object value, int position)
	{
		if (value != null)
		{			
			if (position >= 0 && position <= this.size)
			{
				
				// reallocation is needed if by inserting new element, collection gets full
				if(this.size+1 > this.capacity)
				{
					// newly allocated capacity is doubled
					this.capacity = this.capacity * 2;
				}
				Object[] elements_copy = new Object[this.capacity];
				
				// copy of elements is made, so that it contains part of the elements before index that is inserted
				System.arraycopy(this.elements, 0, elements_copy, 0, position);
				// then, new element is inserted
				elements_copy[position] = value;
				// end the rest of array is copied into elements copy
				if(position+2 < this.capacity)
				{
					System.arraycopy(this.elements, position, elements_copy, position+1, this.size-position);
				}
				this.elements = elements_copy;
				this.size++;
				
			}
			else
				throw new IndexOutOfBoundsException("Can't insert element on position that exceeds boundaries of possible elements positions.");
		}
		else
		{
			throw new IllegalArgumentException("Attempt to insert NULL element! "
					+ "NULL elements are not allowed in collection.");
		}
	}
	
	/**
	 * Returns index of first occurrence of the searched value in elements.
	 * @param value - value to be searched in elements.
	 * @return - value if found, -1 otherwise
	 */
	public int indexOf(Object value)
	{
		for (int i = 0; i < this.size; i++)
		{
			if (this.elements[i].equals(value))
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Checks if elements contain given value.
	 * @param value - value to be searched in elements.
	 * @return - true - if contained, false oterwise.
	 */
	public boolean contains(Object value)
	{
		for (int i = 0; i < this.size; i++)
		{
			if (this.elements[i].equals(value))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Removes all elements from collection.
	 * Size is set to zero.
	 * Capacity is set to initial capacity. 
	 */
	public void clear()
	{
		if (!this.isEmpty())
		{
			this.elements = new Object[this.INITIAL_CAPACITY];
			this.size = 0;
			this.capacity = this.INITIAL_CAPACITY;
		}
	}
	
	/**
	 * Prints element on given position.
	 * Valid position is any index in range 0 to capacity -1.
	 * @param index - position to be printed
	 */
	public void printObject(int index)
	{
		if (index >= 0 && index < this.capacity)
		{
			System.out.println( (index+1) + ". object: " + this.elements[index]);
		}
		else
			throw new IndexOutOfBoundsException("Can't print element that is in position that exceeds boundaries of possible elements positions.");

	}

}
