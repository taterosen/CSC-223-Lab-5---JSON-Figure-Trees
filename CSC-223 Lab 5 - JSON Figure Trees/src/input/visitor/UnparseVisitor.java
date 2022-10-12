package input.visitor;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

import input.components.*;
import input.components.point.*;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;
import utilities.io.StringUtilities;

//
// A JSON file may contain:
//
//     Figure:
//       Points
//       Segments
//
public class UnparseVisitor implements ComponentNodeVisitor
{
	@Override
	public Object visitFigureNode(FigureNode node, Object o)
	{
		// Unpack the input object containing a Stringbuilder and an indentation level
		@SuppressWarnings("unchecked")
		AbstractMap.SimpleEntry<StringBuilder, Integer> pair = (AbstractMap.SimpleEntry<StringBuilder, Integer>)(o);
		StringBuilder sb = pair.getKey();
		int level = pair.getValue();
		
		sb.append(StringUtilities.indent(level) + "Figure\n{\n");
		
        // unparse description
		sb.append(StringUtilities.indent(level + 1) + "Description : \"" + node.getDescription() + "\"\n");
		
		//unparse points
		node.getPointsDatabase().unparse(sb, level + 1);
		
		//unparse segments
		node.getSegments().unparse(sb, level + 1);
		
		sb.append(StringUtilities.indent(level) + "}\n");
		
		return null;
       
	}

	@Override
	public Object visitSegmentNodeDatabase(SegmentNodeDatabase node, Object o)
	{
        // TODO
		
        return null;
	}

	/**
	 * This method should NOT be called since the segment database
	 * uses the Adjacency list representation
	 */
	@Override
	public Object visitSegmentNode(SegmentNode node, Object o)
	{
		return null;
	}

	@Override
	public Object visitPointNodeDatabase(PointNodeDatabase node, Object o)
	{
        // TODO
		
        return null;
	}
	
	@Override
	public Object visitPointNode(PointNode node, Object o)
	{
        // TODO
        
        return null;
	}
}