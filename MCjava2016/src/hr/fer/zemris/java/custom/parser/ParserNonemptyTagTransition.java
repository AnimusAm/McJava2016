package hr.fer.zemris.java.custom.parser;

import java.util.regex.Pattern;

import hr.fer.zemris.java.custom.statemachne.State;

/**
 * Class implements transition for a non-empty tag.
 * Non-empty tags are special:
 * 		- they contain two parts to be parsed: definition and content of a non-empty tag
 * 		- they can be nested
 * Because of their specialty, transitions on non-empty tags is handled diversely.
 * They are special cases of general transitions.
 * Instances of this class are immutable: once transition is determined, it's can't be changed.
 * 	- reason: special way of handling transition - if it's changed, it won't follow specific rules that apply for it.
 * @author Animus
 *
 */
public final class ParserNonemptyTagTransition extends ParserTransition {
		
	/**
	 * Basic constructor for non-empty tag transition receives only one parameter:
	 * 		- pattern which defines it
	 * ID of the transition is known - it is some kind of non-empty tag
	 * @param tr_pattern
	 */
	public ParserNonemptyTagTransition(TransitionPatterns tr_pattern)
	{
		this.id = TransitionId.NON_EMPTY_TAG;
		this.pattern = Pattern.compile(tr_pattern.getTranisitionPattern(), Pattern.CASE_INSENSITIVE);
	}
		
	/**
	 * Method analyzes input, parses it, based on special rules applying for non-empty transition,
	 * 		and determines next state.
	 * Transition handles all of it's specialties internally:
	 * 	- differently handles content, a differently definition of an non-empty tag.
	 *  - nested non-empty tags are not handled to the deepest level all at once
	 *  		- they are rather recognized, and matching state is created that is to be 
	 *  			subjected to recursive resolution of nesting
	 * @param input - input string that is parsed
	 */
	@Override
	public State<TransitionId, Pattern> make_transition(String input) {
		// TODO Auto-generated method stub
		return null;
	}
}
