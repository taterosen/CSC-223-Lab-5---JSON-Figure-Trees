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
		
		sb.append(StringUtilities.indent(level) + "Figure \n");

		sb.append(StringUtilities.indent(level) + "{\n");

		AbstractMap.SimpleEntry<StringBuilder, Integer> newPair = new AbstractMap.SimpleEntry<>(sb, level +1);
		
        // unparse description
		sb.append(StringUtilities.indent(level +1));
		sb.append("Description : \"" + node.getDescription() + "\"");
		
		//unparse points
		node.getPointsDatabase().accept(this, newPair);
		
		//unparse segments
		node.getSegments().accept(this, newPair);
		
		sb.append(StringUtilities.indent(level) + "}\n");
		
		return null;
       
	}

	@Override
	public Object visitSegmentNodeDatabase(SegmentNodeDatabase node, Object o)
	{
		// Unpack the input object containing a Stringbuilder and an indentation level
		@SuppressWarnings("unchecked")
		AbstractMap.SimpleEntry<StringBuilder, Integer> pair = (AbstractMap.SimpleEntry<StringBuilder, Integer>)(o);
		StringBuilder sb = pair.getKey();
		int level = pair.getValue();
				
		sb.append(StringUtilities.indent(level) + "Segments:\n" + StringUtilities.indent(level) + "{\n");
		
		for(PointNode p : node.getAdjList().keySet()) {
			
				sb.append(StringUtilities.indent(level + 1) + p.getName() + " : ");
			
				for(PointNode val : node.getAdjList().get(p)) {
						sb.append(val.getName() + "  ");
				}
				
				sb.append("\n");
			}

		sb.append(StringUtilities.indent(level) + "}\n");
		
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
		// Unpack the input object containing a Stringbuilder and an indentation level
		@SuppressWarnings("unchecked")
		AbstractMap.SimpleEntry<StringBuilder, Integer> pair = (AbstractMap.SimpleEntry<StringBuilder, Integer>)(o);
		StringBuilder sb = pair.getKey();
		int level = pair.getValue();
		
		sb.append(StringUtilities.indent(level) + "Points:\n" + StringUtilities.indent(level) +  "{\n");
		
		for(PointNode p : node.getPoints()) {
			p.unparse(sb, level + 1);
		}
		
		sb.append(StringUtilities.indent(level) + "}\n");
		
        return null;
	}
	
	@Override
	public Object visitPointNode(PointNode node, Object o)
	{
		// Unpack the input object containing a Stringbuilder and an indentation level
				@SuppressWarnings("unchecked")
				AbstractMap.SimpleEntry<StringBuilder, Integer> pair = (AbstractMap.SimpleEntry<StringBuilder, Integer>)(o);
				StringBuilder sb = pair.getKey();
				int level = pair.getValue();
				
				sb.append(StringUtilities.indent(level) +"Point(" + node.getName() + ")(" + node.getX() + 
						", " + node.getY() + ")\n");
        
        return null;
	}
	
	
}