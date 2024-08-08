package controlador;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import modelo.Pokemon;
import pokemonRepositorio.RepositorioPokemones;

public class BatallaControlador {

    @FXML
    private ComboBox<String> comboPokemon1;

    @FXML
    private ComboBox<String> comboPokemon2;

    @FXML
    private TextArea textoBatalla;

    @FXML
    private void initialize()
    {
        comboPokemon1.setItems(FXCollections.observableList(RepositorioPokemones.conseguirPokemones().stream().map(p -> p.getNombre()).toList()));
        //RepositorioPokemones.listaPokemon.stream().filter(p -> !p.getNombre().equals(comboPokemon1.getValue())).map(p->p.getNombre()).toList();

        //comboPokemon2.setItems(FXCollections.observableList(RepositorioPokemones.conseguirPokemones().stream().map(p->p.getNombre()).toList()));
        comboPokemon2.setItems(FXCollections.observableList(RepositorioPokemones.listaPokemon.stream().filter(p -> !p.getNombre().equals(comboPokemon1.getValue())).map(p->p.getNombre()).toList()));

    }

    @FXML
    void elegirPokemon(ActionEvent event) {



        comboPokemon1.setItems(FXCollections.observableList(RepositorioPokemones.listaPokemon.stream().filter(p -> !p.getNombre().equals(comboPokemon2.getValue())).map(p->p.getNombre()).toList()));

    }

    @FXML
    void elegirPokemon2(ActionEvent event) {

        comboPokemon2.setItems(FXCollections.observableList(RepositorioPokemones.listaPokemon.stream().filter(p -> !p.getNombre().equals(comboPokemon1.getValue())).map(p->p.getNombre()).toList()));

    }

    @FXML
    void iniciarBatalla(ActionEvent event) {

        comboPokemon2.setItems(FXCollections.observableList(RepositorioPokemones.listaPokemon.stream().filter(p -> !p.getNombre().equals(comboPokemon1.getValue())).map(p->p.getNombre()).toList()));

    }


}