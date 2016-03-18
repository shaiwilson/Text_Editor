/**
 * 
 */
package spelling;

import java.util.List;

/**
 * @author Shai Wilson
 *
 */
public interface AutoComplete {
	public List<String> predictCompletions(String prefix, int numCompletions);
}
