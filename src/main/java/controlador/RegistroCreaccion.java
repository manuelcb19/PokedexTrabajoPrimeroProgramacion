package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manuel.carrizosa.pokemones.Main;

import java.io.IOException;

public class RegistroCreaccion {

    @FXML
    private Button buttonRegistro;

    @FXML
    private TextField txtContrasenya;

    @FXML
    private TextField txtCorreo;

    private boolean validacionString(String correo)
    {
        boolean esCierto = true;

       if(!correo.contains("@"))
        {
           esCierto = false;
        }
        if(!correo.endsWith(".com"))
        {
            esCierto = false;
        }
        if(!correo.endsWith(".es")) {

        }
        return esCierto;
    }


    @FXML
    void accionRegistrar(ActionEvent event) throws IOException {

        boolean esCierto = validacionString(txtCorreo.getText());
        if(esCierto)
        {
            InicioSesion.diccionarioContrasenya.put(txtContrasenya.getText(),txtCorreo.getText());

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("login-viwe.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Inicio Sesion");
            stage.setScene(scene);
            stage.show();
            ((Stage) buttonRegistro.getScene().getWindow()).close();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Todo ha ido bien \n" );
            alert.showAndWait();
        }

        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("La correo tiene que ser valido\n" );
            alert.showAndWait();

        }




    }

}
