package hr.fer.zemris.java.custom.statemachne;

/**
 * Class implements state in state machine.
 * @author Animus
 *
 */
abstract public class State <I, P> {
	
	/**
	 * Identificator that distinguishes states between them selves.
	 */
	private I id;
	/**
	 * Significant property of the state.
	 */
	private P property;
	
	public void set_id(I state_id)
	{
		this.id = state_id;
	}
	
	public void set_property(P state_property)
	{
		this.property = state_property;
	}
	
	public I get_id()
	{
		return this.id;
	}
	
	public P get_property()
	{
		return this.property;
	}
}
