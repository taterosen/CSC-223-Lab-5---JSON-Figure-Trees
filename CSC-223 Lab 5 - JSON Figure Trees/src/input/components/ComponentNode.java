package input.components;

import input.visitor.ComponentNodeVisitor;

public interface ComponentNode
{
	/**
	 * General unparse method to be overridden.
	 * @param sb
	 * @param level
	 */
	void unparse(StringBuilder sb, int level);
	
	Object accept(ComponentNodeVisitor visitor, Object o);
	
	/**
	 * Indents the number of times specified by a given int.
	 * @param level
	 * @return
	 */
	default String indent(int level) {
		String indents = "";
		for(int i = 0; i < level; i++) 
			indents = indents + "\t";
		
		return indents;
	}
}
