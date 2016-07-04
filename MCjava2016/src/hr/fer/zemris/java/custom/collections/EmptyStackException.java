package hr.fer.zemris.java.custom.collections;

/**
 * Class implements Exception that is caused by poping from an empty stack
 * @author Animus
 *
 */
public class EmptyStackException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6391723199464533314L;
	String message = new String();
	
	public EmptyStackException(String string) {
		this.message = string;
	}
	
	public String getMessage()
	{
		return this.message;
	}
	
	
}
