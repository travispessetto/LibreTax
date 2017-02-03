package application.controllers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import javafx.beans.value.*;
import javafx.concurrent.Worker.State;
import java.lang.*;
import java.net.URL;
import javafx.scene.control.Button;
import application.Bridges.Bridge;
import application.handlers.IHandler;
import application.handlers.PersonalInfoHandler;


public class MainController {
		@FXML
		private WebView sideMenu;
		@FXML
		private WebView mainView;
		@FXML
		private Button nextBtn;
		
		private boolean displayWarning = true;
		private IHandler currentHandler = new PersonalInfoHandler();
		private WebEngine mainEngine;
		
		@FXML
		private void initialize() throws InterruptedException
		{
			mainEngine = mainView.getEngine();
			Bridge bridge = new Bridge(this);
			mainEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>(){
				public void changed(ObservableValue ov, State oldState, State newState)
				{
					if(newState == State.SUCCEEDED)
					{
						JSObject win = (JSObject) mainEngine.executeScript("window");
		                win.setMember("app", bridge);
						if(displayWarning)
						{
							URL warning = MainController.class.getResource("/html/warnings/warning.html");
							mainEngine.executeScript("$.get({url: '"+warning.toExternalForm()+"', success: function(data){$('body').html(data);}});");
						}
					}
					else
					{
						JSObject win = (JSObject) mainEngine.executeScript("window");
		                win.setMember("app", bridge);
					}
				}
			});
			URL mainResource = MainController.class.getResource("/html/layouts/layout.html");
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
			
			nextBtn.setOnAction(new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent e)
				{
					if(displayWarning)
					{
						mainEngine.executeScript("$.get({url: '"+currentHandler.Start()+"', success: function(data){$('body').html(data);}});");
						displayWarning = false;
					}
					else
					{
						System.out.println("Parse Data");
						mainEngine.executeScript("$(\"form\").submit()");
						mainEngine.executeScript("$.get({url: '"+currentHandler.Start()+"', success: function(data){$('body').html(data);}});");
					}
					
			    }
			});
		}
		
		public void AcceptJSON(String json)
		{
			currentHandler.AcceptJSON(json);
		}
		
		public void NextInterview()
		{
			currentHandler.Next();
		}
		
}
