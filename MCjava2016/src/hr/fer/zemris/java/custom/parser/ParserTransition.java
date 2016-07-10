package hr.fer.zemris.java.custom.parser;

import java.util.regex.Pattern;

import hr.fer.zemris.java.custom.statemachne.State;
import hr.fer.zemris.java.custom.statemachne.Transition;

/**
 * Class implements general transition between SM states.
 * @author Animus
 *
 */
public class ParserTransition extends Transition<TransitionId, Pattern, String> {

	protected ParserTransition()
	{
		this.id = null;
		this.pattern = null;
	}
	
	public ParserTransition(TransitionId tr_id, TransitionPatterns tr_pattern)
	{
		this.id = tr_id;
		this.pattern = Pattern.compile(tr_pattern.getTranisitionPattern(), Pattern.CASE_INSENSITIVE);
	}

	@Override
	public State<TransitionId, Pattern> make_transition(String input) {
		// TODO Auto-generated method stub
		return null;
	}
}
