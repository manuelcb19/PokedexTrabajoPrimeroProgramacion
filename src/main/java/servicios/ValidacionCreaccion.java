package servicios;

public class ValidacionCreaccion {

    //Valores para fuerza, defensa, vida base y nivel
    private static final int VALOR_MINIMO = 1;

    // valor para fuerza, defensa y vida Base
    private static final int VALOR_MAXIMO = 15;

    // valor para nivel maximo

    private static final int VALOR_MAXIMO_NIVEL = 100;


    public static Boolean valor_1_15( int numero)
    {

        return numero>=VALOR_MINIMO && numero<=VALOR_MAXIMO;

    }

    public static Boolean valor_1_100( int numero)
    {

        return numero>=VALOR_MINIMO && numero<=VALOR_MAXIMO_NIVEL;

    }







}
