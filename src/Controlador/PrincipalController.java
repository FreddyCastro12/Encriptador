package Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Encriptador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrincipalController implements Initializable {
	@FXML
	private Button btnEncriptar;

	@FXML
	private Button btnLimpiar;

	@FXML
	private TextArea txtCadena;

	@FXML
	private Label lblMensaje;
	
	@FXML
	private Label lblCadenaDesencriptada;
	
	@FXML
	private Button btnDesencriptar;
	
	@FXML
	private TextField txtCadenaEncriptada;
	
	@FXML
	private TextField txtArchivo;

	private Encriptador encriptador;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void encriptarCadena(ActionEvent e) {
		String cadena = txtCadena.getText();
		if (!cadena.isEmpty()) {
			if (cadena.length() > 14) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!!!!!!!");
				alert.setHeaderText(null);
				alert.setContentText("La cadena no debe sobrepasar los 14 caracteres");

				alert.showAndWait();
			}
			encriptador = new Encriptador(cadena);
			
			try {
				encriptador.encriptarCadena(cadena);
				lblMensaje.setText("La cadena se ha encriptado correctamente");
			} catch (Exception e1) {
				lblMensaje.setText("Ha ocurrido un error al momento de encriptar la cadena");
				e1.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Debe ingresar una cadena a encriptar");

			alert.showAndWait();
		}
	}
	
	@FXML
	public void desencriptarCadena(ActionEvent e) {
		String cadenaEncriptada = txtCadenaEncriptada.getText();
		String archivo = txtArchivo.getText();
		
		if(!cadenaEncriptada.isEmpty() && !archivo.isEmpty()) {
			encriptador = new Encriptador(cadenaEncriptada, archivo);
			String cadenaDesencriptada = encriptador.desencriptarCadena(cadenaEncriptada, archivo);
			lblCadenaDesencriptada.setText(cadenaDesencriptada);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Debe llenar todos los campos");

			alert.showAndWait();
		}
	}
	
	@FXML
	public void limpiarCampo(ActionEvent e) {
		
	}
}
