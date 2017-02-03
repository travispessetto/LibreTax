package application.Bridges;
import application.controllers.MainController;
import javafx.scene.web.WebEngine;

public class Bridge{

	private MainController _mainController;
	public Bridge(MainController mainController)
	{
		_mainController = mainController;
	}
	
	public void switchScreen(String action)
	{
		System.out.println("Switch Screens");
	}
	
	public void AcceptJSON(String data)
	{
		System.out.println("Accept JSON");
		_mainController.AcceptJSON(data);
		// Check For Values
		_mainController.NextInterview();
	}
	
	public void Log(String value)
	{
		System.out.println("JavaScript Log: " + value);
	}
}
