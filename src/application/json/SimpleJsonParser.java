// http://rubular.com/r/gYPOsIts6x
// http://rubular.com/r/WwmQrptCEL
package application.json;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleJsonParser
{
	private HashMap<String,List<String>> values;
	
	public SimpleJsonParser()
	{
		values = new HashMap<String,List<String>>();
	}
	
	public List<String> getValue(String key)
	{
		if(values.containsKey(key))
		{
			return values.get(key);
		}
		else
		{
			return null;
		}
	}
	
	public void parseJson(String json)
	{
		Pattern outsideJson = Pattern.compile("(\\{.*(?=\\})\\})");
		Pattern insideJson = Pattern.compile("\\{\"name\":\"(.*(?=\"))\",\"value\":\"(.*(?=\"))\"\\}");
		Matcher outsideMatcher = outsideJson.matcher(json);
		if(outsideMatcher.find())
		{
			System.out.println("Group count: " + outsideMatcher.groupCount());
			for(int i = 0; i < outsideMatcher.groupCount(); ++i)
			{
				System.out.println("Found: " + outsideMatcher.group(i));
				Matcher insideMatcher = insideJson.matcher(outsideMatcher.group(0));
				if(insideMatcher.find())
				{
					System.out.println("Group Count: " + insideMatcher.groupCount());
					String name = insideMatcher.group(1);
					String value = insideMatcher.group(2);
					System.out.println("Name: " + name);
					System.out.println("Value: " + value);
					if(!values.containsKey(name))
					{
						values.put(name, new LinkedList<String>());
					}
					values.get(name).add(value);
					
				}
			}
		}
		else
		{
			System.out.println("Parser no match found");
		}
		
	}

}
