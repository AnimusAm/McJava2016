package hr.fer.zemris.java.custom.parser;

/**
 * Enum represent identificators for states of a SM based parser. 
 * @author Animus
 *
 */
enum StateId {
	
	START, END, TEXT, EMPTY_TAG, NON_EMPTY_TAG, NON_EMPTY_TAG_NESTED, VARIABLE, FUNCTION, STRING, OPERATOR

}
