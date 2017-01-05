package application.Bridges;
import javafx.scene.web.WebEngine;

public class Bridge{

	private WebEngine _mainView;
	public Bridge(WebEngine mainView)
	{
		_mainView = mainView;
	}
	
	public void switchScreen() {
		// TODO Auto-generated method stub
		System.out.println("Switch Screen");
		_mainView.load("https://google.com");
	}
}
