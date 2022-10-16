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
	void test() {
		
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
		//System.out.print(sb.toString());
	}
}

