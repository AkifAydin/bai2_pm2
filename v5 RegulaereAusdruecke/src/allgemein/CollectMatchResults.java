package allgemein;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static util.Printer.*;

public class CollectMatchResults {

	public static void main(String[] args) {
		String str = "<b> Moin </b> Folks <b> Wake Up </b>";

		for (MatchResult mr : findMatches("<b>.*?</b>", str)) {
			p( mr.group() + " von " + mr.start() + " bis " +mr.end() );
		}
	}

	private static Iterable<MatchResult> findMatches( String pattern, CharSequence s ) 
	{ 
	  List<MatchResult> results = new ArrayList<MatchResult>(); 
	 
	  for ( Matcher m = Pattern.compile(pattern).matcher(s); m.find(); ) 
	    results.add( m.toMatchResult() ); 
	 
	  return results; 
	}

}
