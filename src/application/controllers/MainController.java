package application.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import javafx.beans.value.*;
import javafx.concurrent.Worker.State;
import java.lang.*;
import java.net.URL;

import application.Bridges.Bridge;


public class MainController {

		@FXML
		private WebView sideMenu;
		@FXML
		private WebView mainView;
		@FXML
		private void initialize() throws InterruptedException
		{
			Bridge bridge = new Bridge();
			WebEngine mainEngine = mainView.getEngine();
			URL mainResource = MainController.class.getResource("/html/warnings/warning.html");
			String mainExternalForm = mainResource.toExternalForm();
			mainEngine.load(mainExternalForm);
		
			WebEngine sideEngine = sideMenu.getEngine();
			 sideEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
			        public void changed(ObservableValue ov, State oldState, State newState) {
			            if (newState == State.SUCCEEDED) {
			                JSObject win = (JSObject) sideEngine.executeScript("window");
			                win.setMember("app", bridge);
			            }
			        }
			    });
			URL sideResource = MainController.class.getResource("/html/menus/side.html");
			String sideMenuExternalForm = sideResource.toExternalForm();
			sideEngine.load(sideMenuExternalForm);
		}
		
}
