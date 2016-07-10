package hr.fer.zemris.java.custom.parser;

import hr.fer.zemris.java.custom.statemachne.State;

/**
 * Class implements state in a general sense. 
 * Each state has it's:
 * 	- identificator - that distinguishes states among them selves
 *  - property	- determines if this state is acceptable, or unacceptable 
 *  		(there fore - is it final state, on transitive state)
 * @author Animus
 *
 */
public class ParserState extends State<StateId, StateProperty> {

}
