/**
 * A visitor that will convert the AST of a geometry figure back into a JSONObject.
 * implements ComponentNodeVisitor
 * 
 * @author Hanna King
 * @date 10/16
 */

package input.visitor;

import java.util.HashMap;
import java.util.LinkedHashSet;

import org.json.JSONArray;
import org.json.JSONObject;

import input.components.ComponentNode;
import input.components.FigureNode;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;
import parser.JSON_Constants;

public class ToJSONvisitor implements ComponentNodeVisitor
{
	/**
	 * visit the figure node, converting it and the entire figure (description, points, and segments)
	 * into a JSONObject
	 * @return Object JSONObject representing the entire figure
	 * @param node FigureNode
	 * @param o
	 */
	@Override
	public Object visitFigureNode(FigureNode node, Object o)
	{
		JSONObject figure = new JSONObject();
		
		JSONObject desc = new JSONObject();
		desc.put(JSON_Constants.JSON_DESCRIPTION, node.getDescription());
		
		JSONObject points = (JSONObject) visitPointNodeDatabase(node.getPointsDatabase(), o);
		
		JSONObject segments = (JSONObject) visitSegmentNodeDatabase(node.getSegments(), o);
		
		LinkedHashSet<JSONObject> figureArray = new LinkedHashSet<JSONObject>();
		figureArray.add(desc);
		figureArray.add(points);
		figureArray.add(segments);
		JSONArray jsonFigureArray = new JSONArray(figureArray);
		
		figure.put(JSON_Constants.JSON_FIGURE, jsonFigureArray);
		
		return figure;
	}

	/**
	 * visit the SegmentNodeDatabase node, converting it into a JSON object
	 * The JSON object contains a label and JSONArray of data from the node
	 * @return Object JSONObject representing the data in the SegmentNodeDatabase
	 * @param node SegmentNodeDatabase to convert to JSONObject
	 * @param o
	 */
	@Override
	public Object visitSegmentNodeDatabase(SegmentNodeDatabase node, Object o) {
		JSONObject snd = new JSONObject();
		
		HashMap<PointNode, LinkedHashSet<String>> adjacency = new HashMap<PointNode, LinkedHashSet<String>>();
		for (PointNode keyPoint : node.getAdjList().keySet())
		{
			LinkedHashSet<String> valuePoints = new LinkedHashSet<String>();
			for (PointNode valuePoint : node.getAdjList().get(keyPoint))
			{
				valuePoints.add(valuePoint.getName());
			}
			adjacency.put(keyPoint, valuePoints);
		}
		
		JSONArray jsonAdjLists = new JSONArray(adjacency);
		
		snd.put(JSON_Constants.JSON_SEGMENTS, jsonAdjLists);
		
		return snd;
	}

	/**
	 * should NOT be visited, as segment data is handled in visitSegmentNodeDatabase
	 * @return null Object
	 */
	@Override
	public Object visitSegmentNode(SegmentNode node, Object o) {
		return null;
	}

	/**
	 * visit the PointNode node, converting it into a JSON object
	 * The JSON object contains a label and the three data in a PointNode: name, x, and y values
	 * @return Object JSONObject representing the data in the PointNode
	 * @param node PointNode to convert to JSONObject
	 * @param o
	 */
	@Override
	public Object visitPointNode(PointNode node, Object o)
	{
		JSONObject point = new JSONObject();
		
		point.put(JSON_Constants.JSON_NAME, node.getName());
		point.put(JSON_Constants.JSON_X, node.getName());
		point.put(JSON_Constants.JSON_Y, node.getName());
		
		return point;
	}

	/**
	 * visit the PointNodeDatabase node, converting it into a JSON object
	 * The JSON object contains a label and JSONArray of data from the node
	 * @return Object JSONObject representing the data in the PointNodeDatabase
	 * @param node PointNodeDatabase to convert to JSONObject
	 * @param o
	 */
	@Override
	public Object visitPointNodeDatabase(PointNodeDatabase node, Object o)
	{
		JSONObject pnd = new JSONObject();
		
		LinkedHashSet<JSONObject> setOfPoints = new LinkedHashSet<JSONObject>();
		for (PointNode point : node.getPoints())
		{
			setOfPoints.add((JSONObject) visitPointNode(point, o));                      
		}
		
		JSONArray jsonPoints = new JSONArray(setOfPoints);
		
		pnd.put(JSON_Constants.JSON_POINT_S, jsonPoints);
		
		return pnd;
	}

}