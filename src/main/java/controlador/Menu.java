package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manuel.carrizosa.pokemones.Main;

import java.io.IOException;

public class Menu {

    @FXML
    private Button ButtonBatalla;

    @FXML
    private Button ButtonGestPokem;

    @FXML
    private ImageView imagenInicial;

    @FXML
    private void initialize()
    {
        Image imagenPokemones = new Image(getClass().getResourceAsStream("/imagenes/logotipo.png"));
        imagenInicial.setImage(imagenPokemones);
    }
    @FXML
    void goToBatalla(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("batalla-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Pokedex");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Se ha producido el siguiente error.\n" + ex);
            alert.showAndWait();
        }



    }
    @FXML
    void goToPokedex(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("pokedex-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Pokedex");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Se ha producido el siguiente error.\n" + ex);
            alert.showAndWait();
        }

        }
}
