package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manuel.carrizosa.pokemones.Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InicioSesion {

    public static Map<String, String> diccionarioContrasenya = new HashMap<String, String>();

    @FXML
    private Button idbtnButtonRegistro;

    @FXML
    private Button idbtninicioSesion;

    @FXML
    private TextField txtContrasenya;

    @FXML
    private TextField txtCorreo;

    @FXML
    private void initialize()
    {
        diccionarioContrasenya.put("manuel1234","manuel1234@gmail.com");

    }


    @FXML
    void btnIniciarSesion(ActionEvent event) throws IOException {


        if((diccionarioContrasenya.containsKey(txtContrasenya.getText()) && diccionarioContrasenya.containsValue(txtCorreo.getText())))
        try
        {

                FXMLLoader loader = new FXMLLoader(Main.class.getResource("menu-view.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Inicio Sesion");
                stage.setScene(scene);
                stage.show();
                ((Stage) idbtninicioSesion.getScene().getWindow()).close();


        }

        catch (IOException EX)
        {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Incidencia");
                alert.setContentText("La contraseña o el usuario son incorrectos.\n" );
                alert.showAndWait();

        }

        else  {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Usuario no encontrado, por favor, registrese\n" );
            alert.showAndWait();

        }
        ((Stage) idbtninicioSesion.getScene().getWindow()).close();



    }

    @FXML
    void btnRegistrarse(ActionEvent event) {

        try
        {

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("registro-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Inicio Sesion");
            stage.setScene(scene);
            stage.show();
            ((Stage) idbtninicioSesion.getScene().getWindow()).close();


        }

        catch (IOException EX)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("La contraseña o el usuario son incorrectos.\n" );
            alert.showAndWait();

        }

    }

}