package hr.fer.zemris.java.custom.collections;

public class TestStackCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjectStack test_stack = new ObjectStack();
		
		test_stack.push("jedan");
		test_stack.push(1);
		test_stack.push(1.11111);
		
		System.out.println("Stack has: " + test_stack.size() + " elements");
		System.out.println("Elements of the stack:");
		System.out.println("	on the top:		" + test_stack.peek());
		test_stack.pop();
		System.out.println("	after removing top, new top:		" + test_stack.peek());
		test_stack.pop();
		System.out.println("	after removing top, new top:		" + test_stack.peek());
		test_stack.pop();
		try
		{
			System.out.println("	after removing top, new top:		" + test_stack.peek());
		}
		catch (EmptyStackException exc)
		{
			System.out.println("	after removing last element, peek should cause exception: \n" +
					exc.getMessage());
		}


	}

}
