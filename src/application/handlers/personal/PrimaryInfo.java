package application.handlers.personal;

import java.net.URL;

import application.controllers.MainController;
import application.handlers.IInterview;
import application.json.SimpleJsonParser;

public class PrimaryInfo implements IInterview
{

	private String firstName, initial, lastName, streetaddress, city, state, zip;
	private IInterview Next;
	
	public PrimaryInfo()
	{
		Next = new Dependents();
	}
	
	@Override
	public IInterview Next() 
	{
		return Next;
	}

	@Override
	public IInterview Prev() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ShowView() {
		URL url = MainController.class.getResource("/html/personal/primaryInfo.html");
		String external = url.toExternalForm();
		return external;
	}

	@Override
	public void AcceptJSON(String json) 
	{
		SimpleJsonParser parser = new SimpleJsonParser();
		parser.parseJson(json);
	}
	
	public void setSpouseInfoNext(SpouseInfo spouseInfo)
	{
		Next = spouseInfo;
	}

}
