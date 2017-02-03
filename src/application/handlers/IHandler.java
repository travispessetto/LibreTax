package application.handlers;

public interface IHandler 
{
	
	public void Next();
	public IHandler NextModule();
	public void Prev();
	public IHandler PrevModule();
	public String Start();
	public void AcceptJSON(String json);

}
