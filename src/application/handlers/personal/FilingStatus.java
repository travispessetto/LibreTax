package application.handlers.personal;

import java.net.URL;

import application.controllers.MainController;
import application.handlers.IInterview;
import application.handlers.PersonalInfoHandler;

public class FilingStatus implements IInterview 
{
	private String status;
	private IInterview Next;
	
	public FilingStatus()
	{
		Next = new Dependents();
	}
	
	public IInterview Next()
	{
		return Next;
	}
	
	public IInterview Prev()
	{
		return null;
	}
	
	public String ShowView()
	{
		URL url = MainController.class.getResource("/html/personal/filingStatus.html");
		String external = url.toExternalForm();
		return external;
	}
	
	@Override
	public void AcceptJSON(String json)
	{
		System.out.println(json);
	}

}
