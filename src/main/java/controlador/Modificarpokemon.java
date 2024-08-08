package controlador;

import enumerado.Tipos_Pokemon;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Pokemon;
import pokemonRepositorio.RepositorioPokemones;
import servicios.ValidacionCreaccion;

import java.io.IOException;

public class Modificarpokemon {

    private Pokemon pokemon;

    @FXML
    private ComboBox<Tipos_Pokemon> comboTipos;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDefensa;

    @FXML
    private TextField txtFuerza;

    @FXML
    private TextField txtNivel;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtVida;

    @FXML
    private ImageView imagenPikachu;


    @FXML
    private void initialize()
    {

        txtCodigo.setText(String.valueOf(pokemon.getCodigo()));
        txtNombre.setText(pokemon.getNombre());
        txtVida.setText(String.valueOf(pokemon.getVidaBase()));
        txtDefensa.setText(String.valueOf(pokemon.getCodigo()));
        txtFuerza.setText(String.valueOf(pokemon.getFuerza()));
        txtNivel.setText(String.valueOf(pokemon.getNivel()));
        comboTipos.setValue(pokemon.getTipoPokemon());

        Image imagen = new Image(getClass().getResourceAsStream("/imagenes/pikachu.png"));

        if(pokemon.getNombre().equalsIgnoreCase("Pikachu"))
        {
            imagenPikachu.setImage(imagen);
        }
    }

    public Modificarpokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @FXML
    void buttonModificarPokemon(ActionEvent event) throws IOException {

        if (!ValidacionCreaccion.valor_1_100(Integer.parseInt(txtNivel.getText())))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Has cometido un error");
            alert.setContentText("El nivel tiene que estar entre 1 y 100");
            alert.showAndWait();
        }
        else {

            pokemon.setNivel(Integer.parseInt(txtNivel.getText()));
            RepositorioPokemones.modificarPokemonFichero(pokemon.getCodigo(),Integer.parseInt(txtNivel.getText()));
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Felicidades");
            alert.setContentText("El pokemon ha sido modificado correctamente");
            alert.showAndWait();
        }


    }



}
