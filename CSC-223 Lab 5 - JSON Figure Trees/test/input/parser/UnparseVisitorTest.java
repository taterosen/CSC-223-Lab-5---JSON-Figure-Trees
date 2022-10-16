package input.parser;
import input.visitor.UnparseVisitor;
import input.components.*;
import input.components.FigureNode;
import utilities.io.*;
import parser.JSONParser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;

import org.junit.jupiter.api.Test;

class UnparseVisitorTest {

	
	@Test
	void SingleLineSegmentTest() {
		
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/lineseg.json");
		ComponentNode node = Parse.parse(figureStr);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"One line segment consisting of two points on y-axis.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(0.0, 1.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        B : A  \n"
				+ "        A : B  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void TriangleSegmentTest() {
		
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/single_triangle.json");
		ComponentNode node = Parse.parse(figureStr);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"Right Triangle in the first quadrant.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(1.0, 1.0)\n"
				+ "        Point(C)(1.0, 0.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        C : A  B  \n"
				+ "        B : A  C  \n"
				+ "        A : B  C  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void SquareSegmentTest() {
		
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/square.json");
		ComponentNode node = Parse.parse(figureStr);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"Square.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(0.0, 6.0)\n"
				+ "        Point(C)(6.0, 0.0)\n"
				+ "        Point(D)(6.0, 6.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        B : A  D  \n"
				+ "        C : A  D  \n"
				+ "        D : B  C  \n"
				+ "        A : C  B  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void Collinear_line_segmentTest() {
		
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/collinear_line_segments.json");
		ComponentNode node = Parse.parse(figureStr);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"A seqeunce of collinear line segments mimicking one line with 6 points.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(4.0, 0.0)\n"
				+ "        Point(C)(9.0, 0.0)\n"
				+ "        Point(D)(11.0, 0.0)\n"
				+ "        Point(E)(16.0, 0.0)\n"
				+ "        Point(F)(26.0, 0.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        C : D  B  \n"
				+ "        D : C  E  \n"
				+ "        E : D  F  \n"
				+ "        B : C  A  \n"
				+ "        A : B  \n"
				+ "        F : E  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void crossing_symmetric_triangleTest() {
		
		JSONParser Parse = new JSONParser();
		String figureStr = utilities.io.FileUtilities.readFileFilterComments("jsonfiles/crossing_symmetric_triangle.json");
		ComponentNode node = Parse.parse(figureStr);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"Crossing symmetric triangle construction.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(D)(0.0, 0.0)\n"
				+ "        Point(E)(6.0, 0.0)\n"
				+ "        Point(B)(2.0, 4.0)\n"
				+ "        Point(C)(4.0, 4.0)\n"
				+ "        Point(A)(3.0, 6.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        E : B  C  D  \n"
				+ "        D : E  B  C  \n"
				+ "        C : E  A  B  D  \n"
				+ "        B : E  A  C  D  \n"
				+ "        A : B  C  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
}

