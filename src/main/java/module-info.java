module manuel.carrizosa.pokemones {
    requires javafx.controls;
    requires javafx.fxml;


    opens manuel.carrizosa.pokemones to javafx.fxml;
    exports manuel.carrizosa.pokemones;
    exports controlador;
    opens controlador to javafx.fxml;
    opens modelo;
    opens enumerado;
    exports pruebas;
    opens pruebas to javafx.fxml;
    
}