package Vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Encriptador/Principal.fxml"));
		
		Parent p = loader.load();
		Scene s = new Scene(p);
		
		primaryStage.setTitle("Encriptador");
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String args[]) {
		launch(args);
	}

}