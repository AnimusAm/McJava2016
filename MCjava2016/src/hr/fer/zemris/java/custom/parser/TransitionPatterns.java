package hr.fer.zemris.java.custom.parser;

public enum TransitionPatterns {

	TAG_FOR_BASIC(
				TagPatterns.TAG_FOR.getTagPattern() + ".*?" + 
				TagPatterns.TAG_END.getTagPattern()),
	TAG_ECHO_EQUALS("=");
	
	String regex_string;
	
	TransitionPatterns(String pattern)
	{
		this.regex_string = pattern;
	}
	
	public String getTranisitionPattern()
	{
		return this.regex_string;
	}
	
	public enum TagPatterns {
		TAG_FOR("\\{\\$\\s*[Ff][Oo][Rr]\\s*.*?\\$\\}"),
		TAG_END("\\{\\$\\s*[Ee][Nn][Dd]\\s*\\$\\}");
		
		String tag_string;
		
		TagPatterns(String pattern)
		{
			this.tag_string = pattern;
		}
		
		public String getTagPattern()
		{
			return this.tag_string;
		}
	
	}
	
}
