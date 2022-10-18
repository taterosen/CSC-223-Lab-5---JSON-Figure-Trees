package input.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;

import org.json.JSONObject;
import org.json.JSONWriter;
import org.junit.jupiter.api.Test;

import input.components.ComponentNode;
import input.components.FigureNode;
import input.visitor.ToJSONvisitor;
import parser.JSONParser;

class ToJSONvisitorTest
{
	// figure pictures in json files
	
	@Test
	void test_point()
	{
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/point.json");
		JSONObject fromFile = new JSONObject(figureStr);
		ComponentNode node = Parse.parse(figureStr);
		
		ToJSONvisitor visitor = new ToJSONvisitor();
		
		JSONObject obj = (JSONObject) visitor.visitFigureNode((FigureNode) node, new Object());
		
		assertEquals(fromFile.toString(0), obj.toString(0));
	}
	
	@Test
	void test_lineseg()
	{
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/lineseg.json");
		JSONObject fromFile = new JSONObject(figureStr);
		ComponentNode node = Parse.parse(figureStr);
	
		ToJSONvisitor visitor = new ToJSONvisitor();
	
		JSONObject obj = (JSONObject) visitor.visitFigureNode((FigureNode) node, new Object());
	
		assertEquals(fromFile.toString(0), obj.toString(0));
	}
	
	@Test
	void test_single_triangle()
	{
		
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/single_triangle.json");
		JSONObject fromFile = new JSONObject(figureStr);
		ComponentNode node = Parse.parse(figureStr);
	
		ToJSONvisitor visitor = new ToJSONvisitor();
	
		JSONObject obj = (JSONObject) visitor.visitFigureNode((FigureNode) node, new Object());

		assertEquals(fromFile.toString(0), obj.toString(0));
	}
	
	@Test
	void test_square()
	{
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/square.json");
		JSONObject fromFile = new JSONObject(figureStr);
		ComponentNode node = Parse.parse(figureStr);
	
		ToJSONvisitor visitor = new ToJSONvisitor();
	
		JSONObject obj = (JSONObject) visitor.visitFigureNode((FigureNode) node, new Object());

		assertEquals(fromFile.toString(0), obj.toString(0));
	}
	
	@Test
	void test_collinear_line_segments()
	{
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/collinear_line_segments.json");
		JSONObject fromFile = new JSONObject(figureStr);
		ComponentNode node = Parse.parse(figureStr);
	
		ToJSONvisitor visitor = new ToJSONvisitor();
	
		JSONObject obj = (JSONObject) visitor.visitFigureNode((FigureNode) node, new Object());
	
		assertEquals(fromFile.toString(0), obj.toString(0));
	}
	
	@Test
	void test_crossing_symmetric_triangle()
	{
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/crossing_symmetric_triangle.json");
		JSONObject fromFile = new JSONObject(figureStr);
		ComponentNode node = Parse.parse(figureStr);
	
		ToJSONvisitor visitor = new ToJSONvisitor();
	
		JSONObject obj = (JSONObject) visitor.visitFigureNode((FigureNode) node, new Object());
	
		assertEquals(fromFile.toString(0), obj.toString(0));
	}
	
	@Test
	void test_fully_connected_irregular_polygon()
	{
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/fully_connected_irregular_polygon.json");
		JSONObject fromFile = new JSONObject(figureStr);
		ComponentNode node = Parse.parse(figureStr);
	
		ToJSONvisitor visitor = new ToJSONvisitor();
	
		JSONObject obj = (JSONObject) visitor.visitFigureNode((FigureNode) node, new Object());
	
		assertEquals(fromFile.toString(0), obj.toString(0));
	}
	
	@Test
	void test_snake()
	{
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/snake.json");
		JSONObject fromFile = new JSONObject(figureStr);
		ComponentNode node = Parse.parse(figureStr);
	
		ToJSONvisitor visitor = new ToJSONvisitor();
	
		JSONObject obj = (JSONObject) visitor.visitFigureNode((FigureNode) node, new Object());
	
		assertEquals(fromFile.toString(0), obj.toString(0));
	}
	
	@Test
	void test_tri_quad()
	{
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/Tri_Quad.json");
		JSONObject fromFile = new JSONObject(figureStr);
		ComponentNode node = Parse.parse(figureStr);
	
		ToJSONvisitor visitor = new ToJSONvisitor();
	
		JSONObject obj = (JSONObject) visitor.visitFigureNode((FigureNode) node, new Object());
	
		assertEquals(fromFile.toString(0), obj.toString(0));
	}
}