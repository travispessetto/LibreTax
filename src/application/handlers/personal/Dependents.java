package application.handlers.personal;

import java.net.URL;

import application.controllers.MainController;
import application.handlers.IInterview;

public class Dependents implements IInterview  {

	@Override
	public IInterview Next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IInterview Prev() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ShowView() {
		URL url = MainController.class.getResource("/html/personal/dependents.html");
		String external = url.toExternalForm();
		return external;
	}

	@Override
	public void AcceptJSON(String json) {
		// TODO Auto-generated method stub
		
	}

}
