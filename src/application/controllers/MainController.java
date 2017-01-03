package application.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.lang.*;
import java.net.URL;


public class MainController {

		@FXML
		private WebView sideMenu;
		@FXML
		private WebView mainView;
		
		@FXML
		private void initialize()
		{
			WebEngine mainEngine = mainView.getEngine();
			URL resource = MainController.class.getResource("/html/warnings/warning.html");
			String externalForm = resource.toExternalForm();
			if(externalForm == null)
			{
				mainEngine.load("https://google.com");
			}
			else
			{
				mainEngine.load(externalForm);
			}
		}
}
