package controlador;

import enumerado.Tipos_Pokemon;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Pokemon;
import pokemonRepositorio.RepositorioPokemones;
import servicios.ValidacionCreaccion;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Creaccion {
    private StringBuffer sb = new StringBuffer();


    @FXML
    private Button btnagregar;

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
    private void initialize()
    {
        comboTipos.setItems(FXCollections.observableList(RepositorioPokemones.conseguirTiposPokemon()));
        comboTipos.setValue(Tipos_Pokemon.NINGUNO);
        txtCodigo.setText(String.valueOf(RepositorioPokemones.devolverCodigo()+1));

    }

    private void mostrarAlerta(StringBuffer sb)
    {
        if(!sb.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Has cometido un error");
            alert.setContentText(sb.toString());
            alert.showAndWait();
            sb.replace(0,sb.length(),"");
        }
        else {

            String nombre = txtNombre.getText();
        int codigo = Integer.parseInt(txtCodigo.getText());
        int defensa = Integer.parseInt(txtDefensa.getText());
        int fuerza = Integer.parseInt(txtFuerza.getText());
        int vida = Integer.parseInt(txtVida.getText());
        int nivel = Integer.parseInt(txtNivel.getText());
        Tipos_Pokemon tipo = comboTipos.getValue();

        if(!RepositorioPokemones.comprobarExistenciaPokemon(codigo))
            {
                RepositorioPokemones.anadirPokemon(new Pokemon(codigo, nombre,tipo,nivel, fuerza, defensa,vida));
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Felicidades");
                alert.setContentText("El pokemon ha sido creado correctamente");
                alert.showAndWait();
                ((Stage) btnagregar.getScene().getWindow()).close();



            }

        else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("fallo");
            alert.setContentText("Ese codigo ya existe, por favor, introduzca un pokemon con un codigo distinto");
            alert.showAndWait();

        }


       // RepositorioPokemones.anyadirPokemon(Pokemon pokemon);

        }
    }

    @FXML
    void buttonAgergarPokemon(ActionEvent event)
    {
        try
        {

            if(!ValidacionCreaccion.valor_1_15(Integer.parseInt(txtVida.getText()))) {

                sb.append("el valor de la vida tiene que estar entre 1 o 15 \n");
            }

            if(!ValidacionCreaccion.valor_1_15(Integer.parseInt(txtDefensa.getText()))) {

                sb.append("el valor de la defensa tiene que estatr entre 1 o 15 \n");
            }

            if(!ValidacionCreaccion.valor_1_15(Integer.parseInt(txtFuerza.getText()))) {

                sb.append("el valor de la fuerza tiene que estar entre 1 o 15 \n");
            }

            if(!ValidacionCreaccion.valor_1_100(Integer.parseInt(txtNivel.getText()))) {

                sb.append("el valor del nivel tiene que estar entre 1 o 100 \n");
            }

            if(comboTipos.getValue().equals(Tipos_Pokemon.NINGUNO))
            {
                sb.append("hay que meter un tipo de pokemon");
            }

            mostrarAlerta(sb);
        }
            catch (NumberFormatException ex){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Has cometido un error");
                alert.setContentText("Has introducido un campo vacio y/o un valor no valido en un campo");
                alert.showAndWait();
                sb.replace(0,sb.length(),"");
        }
                catch (Exception ex){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Has cometido un error");
                alert.setContentText("Se ha producido un error");
                alert.showAndWait();
                sb.replace(0,sb.length(),"");
        }
    }
}