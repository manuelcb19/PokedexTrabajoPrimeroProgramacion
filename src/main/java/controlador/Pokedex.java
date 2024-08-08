package controlador;

import enumerado.Tipos_Pokemon;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manuel.carrizosa.pokemones.Main;
import modelo.Pokemon;
import pokemonRepositorio.RepositorioPokemones;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.scene.input.MouseEvent;

public class Pokedex {


    @FXML
    private ImageView imagenPokedex;

    @FXML
    private TableColumn<Pokemon, Integer> columCodigo;

    @FXML
    private TableColumn<Pokemon, Integer> columDefensa;

    @FXML
    private TableColumn<Pokemon, Integer> columFuerza;

    @FXML
    private TableColumn<Pokemon, Integer> columNivel;

    @FXML
    private TableColumn<Pokemon, String> columNombre;

   @FXML
    private TableColumn<Pokemon, String> columTipo;

    @FXML
    private TableColumn<Pokemon, Integer> columVida;

    @FXML
    private TableView<Pokemon> tablePokemon;

    @FXML
    private RadioButton radioAgua;

    @FXML
    private RadioButton radioElectrico;

    @FXML
    private ComboBox<Tipos_Pokemon> comboBoxTipo;

    @FXML
    private RadioButton radioReset;


    @FXML
    private void initialize()
    {

        Image imagenPokemones = new Image(getClass().getResourceAsStream("/imagenes/cabeceraPokedex.png"));
        imagenPokedex.setImage(imagenPokemones);

        tablePokemon.setItems(FXCollections.observableList(RepositorioPokemones.conseguirPokemonesFicheros()));


        this.columCodigo.setCellValueFactory(new PropertyValueFactory("Codigo"));
        this.columNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.columNivel.setCellValueFactory(new PropertyValueFactory("Nivel"));

        this.columTipo.setCellValueFactory(pokemon -> new SimpleStringProperty(pokemon.getValue().devolverTipo()));
        this.columFuerza.setCellValueFactory(pokemon -> new SimpleIntegerProperty(pokemon.getValue().calcularFuerza()).asObject());
        this.columDefensa.setCellValueFactory(pokemon -> new SimpleIntegerProperty(pokemon.getValue().calcularDefensa()).asObject());
        this.columVida.setCellValueFactory(pokemon -> new SimpleIntegerProperty(pokemon.getValue().calcularVidaBase()).asObject());

        this.columCodigo.setComparator((p1,p2) -> p2.compareTo(p1));
        //Comparator<Persona> comparadorFechaNacimiento =
        //
        //(p1, p2) -> p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());

        comboBoxTipo.setItems(FXCollections.observableList(RepositorioPokemones.conseguirTiposPokemon()));
        comboBoxTipo.setValue(Tipos_Pokemon.NINGUNO);

        ToggleGroup tbn = new ToggleGroup();
        radioAgua.setToggleGroup(tbn);
        radioElectrico.setToggleGroup(tbn);
        radioReset.setToggleGroup(tbn);

    }

    @FXML
    void AnadirPokemones(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("creaccionPokemon-view.fxml"));
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
        tablePokemon.refresh();
    }
        @FXML
        void eliminarPokemon(MouseEvent event)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Seguro que quieres borrar el pokemon??.\n");
            alert.showAndWait();

            if(!alert.isResizable())
            {
                Pokemon pokemon = this.tablePokemon.getSelectionModel().getSelectedItem();
                RepositorioPokemones.listaPokemon.remove(pokemon);
            }
            tablePokemon.refresh();

        }

    @FXML
    void modificarPokemon(MouseEvent event) {

        try {

            Pokemon pokemon = this.tablePokemon.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("modificacionPokemon-view.fxml"));

            Modificarpokemon claseQueControlaLaModificacionPokemon = new Modificarpokemon(pokemon);
           // controller.setPokemon(pokemon);
            loader.setController(claseQueControlaLaModificacionPokemon);

            //new Modificarpokemon(this.tablePokemon.getSelectionModel().getSelectedItem());

            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Pokedex");
            stage.setScene(scene);
            stage.showAndWait();
        }
        catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Has pulsado en un campo que no contiene ningun pokemon, por favor, seleccione un lugar valido \n");
            alert.showAndWait();
        }

        tablePokemon.refresh();

    }

    @FXML
    void btnFiltrar(MouseEvent event) {

       if(radioAgua.isSelected())
       {
           tablePokemon.setItems(FXCollections.observableList(RepositorioPokemones.conseguirPokemonesFicheros().stream().filter(p->p.getTipoPokemon() == Tipos_Pokemon.AGUA).toList()));

       }

        if(radioElectrico.isSelected())
        {
            tablePokemon.setItems(FXCollections.observableList(RepositorioPokemones.conseguirPokemonesFicheros().stream().filter(p->p.getTipoPokemon() == Tipos_Pokemon.ELECTRICO).toList()));

        }

        if(radioReset.isSelected())
        {
            tablePokemon.setItems(FXCollections.observableList(RepositorioPokemones.conseguirPokemonesFicheros()));
        }

        if(comboBoxTipo.getValue() != Tipos_Pokemon.NINGUNO)
        {
            tablePokemon.setItems(FXCollections.observableList(RepositorioPokemones.conseguirPokemonesFicheros().stream().filter(p->p.getTipoPokemon().equals(comboBoxTipo.getValue())).toList()));
        }



    }







}