package hr.fer.zemris.java.custom.collections;

public class TestIndexBackedCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// testingAdd();
		//testingGet();
		// testingRemove();
		// testingInsert();
		// testingIndexOf();
		// testingContains();
		// testingClear();
		
		ArrayBackedIndexedCollection col = new ArrayBackedIndexedCollection(2);
		col.add(new Integer(20));
		col.add("New York");
		col.add("San Francisco"); // here the internal array is reallocated
		System.out.println(col.contains("New York")); // writes: true
		col.remove(1); // removes "New York"; shifts "San Francisco" to position 1
		System.out.println(col.get(1)); // writes: "San Francisco"
		System.out.println(col.size()); // writes: 2

	}
	
	public static void testingAdd()
	{
		System.out.println("\nTESTING ADD");
		ArrayBackedIndexedCollection testAdd;
		
		try 
		{
			testAdd = new ArrayBackedIndexedCollection(0);
		}
		catch (IllegalArgumentException e)
		{
			testAdd = new ArrayBackedIndexedCollection(2);
			testAdd.add(1);
			testAdd.add("Ana");
			System.out.println("Current size: " + testAdd.size());
			System.out.println("FULL - Reallocation needed");
			testAdd.add(1.2);
			testAdd.add("Ivana");
			System.out.println("Current size: " + testAdd.size());
			System.out.println("FULL - Reallocation needed");
			testAdd.add(3);
			testAdd.add("Marko");
			testAdd.add(3.2);
			testAdd.add("Marin");
			System.out.println("Current size: " + testAdd.size());
			testAdd.printObject(0);
			testAdd.printObject(1);
			testAdd.printObject(2);
			testAdd.printObject(3);
			testAdd.printObject(4);
			testAdd.printObject(5);
			testAdd.printObject(6);
			testAdd.printObject(7);
					
		}
	}
	
	public static void testingGet()
	{
		System.out.println("\nTESTING GET");
		ArrayBackedIndexedCollection testGet = new ArrayBackedIndexedCollection(1);
		testGet.add(1);
		
		Object returned;
		
		System.out.println("Current size: " + testGet.size());
		System.out.println("Fetching element on position 0");
		returned = testGet.get(0);
		System.out.println("Fetched 0-th element: " + returned);
		
		try 
		{
			System.out.println("Fetching element on position -1. Expecting exception");
			returned = testGet.get(-1);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Fetching element on position -1. Exception occured");					
		}
		
		try 
		{
			System.out.println("Fetching element on position 1. Expecting exception");
			returned = testGet.get(1);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Fetching element on position 1. Exception occured");					
		}
	}
	
	public static void testingRemove()
	{
		System.out.println("\nTESTING REMOVE");
		ArrayBackedIndexedCollection testRemove = new ArrayBackedIndexedCollection(3);
		testRemove.add(0);
		testRemove.add(1);
		testRemove.add(2);
		
		System.out.println("Current size: " + testRemove.size());
		
		try 
		{
			System.out.println("Fetching element on position 3. Expecting exception");
			testRemove.remove(3);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Fetching element on position 3. Exception occured");					
		}
		
		testRemove.remove(0);
		System.out.println("Current size: " + testRemove.size());
		testRemove.printObject(0);
		testRemove.printObject(1);
		testRemove.printObject(2);
		
		testRemove.remove(1);
		System.out.println("Current size: " + testRemove.size());
		testRemove.printObject(0);
		testRemove.printObject(1);
		testRemove.printObject(2);
		
		testRemove.remove(0);
		System.out.println("Current size: " + testRemove.size());
		testRemove.printObject(0);
		testRemove.printObject(1);
		testRemove.printObject(2);
		
		try 
		{
			System.out.println("Removing element on position -1. Expecting exception");
			testRemove.remove(-1);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Removing element on position -1. Exception occured");					
		}
	}
	
	public static void testingInsert()
	{
		System.out.println("\nTESTING INSERT");
		ArrayBackedIndexedCollection testInsert = new ArrayBackedIndexedCollection(1);
		
		System.out.println("Current size: " + testInsert.size());
		
		try 
		{
			System.out.println("Inserting null element on position 0. Expecting exception");
			testInsert.insert(null, 3);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Inserting null element on position 0. Exception occured");					
		}
		
		try 
		{
			System.out.println("Inserting element on position 3. Expecting exception");
			testInsert.insert(3, 3);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Inserting element on position 3. Exception occured");					
		}
		
		testInsert.insert(0,0);
		System.out.println("Current size: " + testInsert.size());
		testInsert.printObject(0);
		
		testInsert.insert(1,1);
		System.out.println("Current size: " + testInsert.size());
		testInsert.printObject(0);
		testInsert.printObject(1);
		
		testInsert.insert(2,1);
		System.out.println("Current size: " + testInsert.size());
		testInsert.printObject(0);
		testInsert.printObject(1);
		testInsert.printObject(2);
		testInsert.printObject(3);

		System.out.println("Inserting existing on existing position");
		testInsert.insert(2,1);
		System.out.println("Current size: " + testInsert.size());
		testInsert.printObject(0);
		testInsert.printObject(1);
		testInsert.printObject(2);
		testInsert.printObject(3);
		
		
		System.out.println("Current size: " + testInsert.size());
		
		try 
		{
			System.out.println("Inserting element on position -1. Expecting exception");
			testInsert.remove(-1);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Inserting element on position -1. Exception occured");					
		}
	}
	
	public static void testingIndexOf()
	{
		System.out.println("\nTESTING INDEX OF");
		ArrayBackedIndexedCollection testIndexof = new ArrayBackedIndexedCollection(2);
		
		testIndexof.add(0);
		testIndexof.printObject(0);
		testIndexof.add(1);
		testIndexof.printObject(1);
		testIndexof.add(1);
		testIndexof.printObject(2);
		testIndexof.add(2);
		testIndexof.printObject(3);
		testIndexof.add(2);
		testIndexof.printObject(4);
		
		System.out.println("Current size: " + testIndexof.size());
		System.out.println("Index of 1 - expecting 1" );
		System.out.println("Got: " + testIndexof.indexOf(1));
		System.out.println("Index of 2 - expecting 3" );
		System.out.println("Got: " + testIndexof.indexOf(2));
		System.out.println("Index of 5 - expecting -1" );
		System.out.println("Got: " + testIndexof.indexOf(5));
		
	}
	
	public static void testingContains()
	{
		System.out.println("\nTESTING CONTAINS");
		ArrayBackedIndexedCollection testContian = new ArrayBackedIndexedCollection(2);
		
		testContian.add(0);
		testContian.printObject(0);
		testContian.add(1);
		testContian.printObject(1);
		testContian.add(1);
		testContian.printObject(2);
		testContian.add(2);
		testContian.printObject(3);
		testContian.add(2);
		testContian.printObject(4);
		
		System.out.println("Current size: " + testContian.size());
		System.out.println("Contains 1 - expecting true" );
		System.out.println("Got: " + testContian.contains(1));
		System.out.println("Contains 2 - expecting true" );
		System.out.println("Got: " + testContian.contains(2));
		System.out.println("Contains 5 - expecting false" );
		System.out.println("Got: " + testContian.contains(5));
		
	}
	
	public static void testingClear()
	{
		System.out.println("\nTESTING CONTAINS");
		ArrayBackedIndexedCollection testClear = new ArrayBackedIndexedCollection(2);
		
		testClear.add(0);
		testClear.printObject(0);
		testClear.add(1);
		testClear.printObject(1);
		testClear.add(1);
		testClear.printObject(2);
		testClear.add(2);
		testClear.printObject(3);
		testClear.add(2);
		testClear.printObject(4);
		
		System.out.println("Current size: " + testClear.size());
		
		System.out.println("Clearing nonempty list:" );
		testClear.clear();
		System.out.println("Current size: " + testClear.size());
		testClear.printObject(0);
		
		System.out.println("Clearing empty list:" );
		testClear.clear();
		System.out.println("Current size: " + testClear.size());
		testClear.printObject(0);
		
	}

}
