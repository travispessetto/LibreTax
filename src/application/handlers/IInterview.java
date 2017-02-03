package application.handlers;

public interface IInterview 
{
	public IInterview Next();
	public IInterview Prev();
	public String ShowView();
	public void AcceptJSON(String json);
}
