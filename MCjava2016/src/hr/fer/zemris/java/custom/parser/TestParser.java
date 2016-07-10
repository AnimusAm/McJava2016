package hr.fer.zemris.java.custom.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "si   n({$=i$}^2) = {$FOR i 0   10 2 $}si {$FOR i 0   10 2 $}si {$= i i * @  sin \"0.000\" @decfmt $} bla bal{$END$} {$= i i * @  sin \"0.000\" @decfmt $} bla bal";

		Matcher for_patten = Pattern.compile("\\{\\$\\s*FOR\\s*.*?\\$\\}",  Pattern.CASE_INSENSITIVE).matcher(input);
		Matcher end_pattern = Pattern.compile("\\{\\$\\s*END\\s*\\$\\}",  Pattern.CASE_INSENSITIVE).matcher(input);
		
		int start = 0;
		int start_for = 0;
		while (for_patten.find(start)) { 
			start = for_patten.start() + 1;
			start_for++;
		}
		
		
		int start_end = 0;

		start = 0;
		while (end_pattern.find(start)) { 
			start = end_pattern.start() + 1;
			start_end++;
		}	
		
		System.out.println("start_for: " + start_for);
		System.out.println("start_end: " + start_end);
	}

}
