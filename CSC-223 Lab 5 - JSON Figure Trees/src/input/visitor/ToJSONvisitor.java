package input.visitor;

import org.json.JSONObject;

public class ToJSONvisitor
{
	
	JSONObject _json;
	
	//convert the AST of a	geometry figure back into a JSONObject
	public JSONObject ASTToJSON()
	{
		
	}
	
	public String toString()
	{
		return _json.toString();
	}
}