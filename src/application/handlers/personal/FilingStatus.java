package application.handlers.personal;

import java.net.URL;
import java.util.List;

import application.controllers.MainController;
import application.handlers.IInterview;
import application.handlers.PersonalInfoHandler;
import application.json.SimpleJsonParser;

public class FilingStatus implements IInterview 
{
	private String status;
	private IInterview Next;
	
	public FilingStatus()
	{
		
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
		SimpleJsonParser parser = new SimpleJsonParser();
		parser.parseJson(json);
		List<String> filingStatusList = parser.getValue("filingStatus");
		if(filingStatusList != null)
		{
			String fillingStatus = filingStatusList.get(0);
			if(fillingStatus.equals("married joint") || fillingStatus.equals("married separate"))
			{
				PrimaryInfo primaryInfo = new PrimaryInfo();
				SpouseInfo spouseInfo = new SpouseInfo();
				primaryInfo.setSpouseInfoNext(spouseInfo);
				
				Next = primaryInfo;
			}
			else
			{
				Next = new PrimaryInfo();
			}
		}
	}

}
