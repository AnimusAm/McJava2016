package hr.fer.zemris.java.custom.statemachne;

/**
 * Class implements transition entity in state machine.
 * @author Animus
 *
 */
abstract public class Transition <I, P, S>{
	protected I id;
	protected P pattern;
	
	abstract public State<I, P> make_transition(S input);
}
