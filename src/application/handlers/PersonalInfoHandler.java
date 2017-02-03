package application.handlers;

import java.net.URL;

import application.controllers.MainController;
import application.handlers.personal.FilingStatus;

public class PersonalInfoHandler implements IHandler{

	private IInterview _interview;
	
	public PersonalInfoHandler()
	{
		_interview = new FilingStatus();
	}
	
	@Override
	public void Next() {
		_interview = _interview.Next();
	}

	@Override
	public IHandler NextModule() {
		return null;
	}

	@Override
	public void Prev() {
	}

	@Override
	public IHandler PrevModule() {
		// Leave as null because this module has no previous
		return null;
	}

	@Override
	public String Start() {
		return _interview.ShowView();
	}
	
	@Override
	public void AcceptJSON(String json)
	{
		_interview.AcceptJSON(json);
	}

}
