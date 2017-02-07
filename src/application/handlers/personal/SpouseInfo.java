package application.handlers.personal;

import java.net.URL;

import application.controllers.MainController;
import application.handlers.IInterview;

public class SpouseInfo implements IInterview
{
	private PrimaryInfo primaryInfo;
	
	IInterview next;
	public SpouseInfo()
	{
		next = new Dependents();
	}

	@Override
	public IInterview Next() {
		return next;
	}

	@Override
	public IInterview Prev() {
		return primaryInfo;
	}

	@Override
	public String ShowView() {
		URL url = MainController.class.getResource("/html/personal/spouseInfo.html");
		String external = url.toExternalForm();
		return external;
	}

	@Override
	public void AcceptJSON(String json) {
		
	}

}
