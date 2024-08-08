package pokemonRepositorio;

import enumerado.Tipos_Pokemon;
import modelo.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class RepositorioPokemones {

    public static List<Pokemon> listaPokemon;

    public static void agregarPokemonLista(String linea)
    {
        String [] lista = linea.trim().split(",");
        int codigo = Integer.parseInt(lista[0]);
        String nombre = lista[1];
        Tipos_Pokemon pokemon = Tipos_Pokemon.valueOf(lista[2]);
        int nivel = Integer.parseInt(lista[3]);
        int fuerza = Integer.parseInt(lista[4]);
        int defensa = Integer.parseInt(lista[5]);
        int vidaBase = Integer.parseInt(lista[6]);

       listaPokemon.add(new Pokemon(codigo,nombre,pokemon,nivel,fuerza,defensa,vidaBase));

    }
    public static List<Pokemon> conseguirPokemonesFicheros(){

        String ruta = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"ficheros"+File.separator+"Pokemon.txt";
        listaPokemon = new ArrayList<Pokemon>();


        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea  = br.readLine();
            while (linea != null)
            {
                agregarPokemonLista(linea);
                linea = br.readLine();
            }
        }

          catch (Exception ex){
        }
        return listaPokemon;
    }

    public static List<Pokemon> conseguirPokemones() {

        if (listaPokemon == null) {
            listaPokemon = new ArrayList<Pokemon>();

            listaPokemon.add(new Pokemon(1, "Pikachu", Tipos_Pokemon.ELECTRICO, 2, 5, 5, 15));
            listaPokemon.add(new Pokemon(2, "Chikorita", Tipos_Pokemon.PLANTA, 1, 3, 7, 15));
            listaPokemon.add(new Pokemon(3, "Totodile", Tipos_Pokemon.AGUA, 1, 2, 4, 15));
            listaPokemon.add(new Pokemon(4, "Charmander", Tipos_Pokemon.FUEGO, 2, 5, 5, 15));
        }

        return listaPokemon;
    }
    public static boolean comprobarExistenciaPokemon(int codigo) {

       return listaPokemon.stream().anyMatch(p -> p.getCodigo() == codigo);
    }
    public static void modificarPokemonFichero(int codigo, int nivel) throws IOException {

        String ruta = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "ficheros" + File.separator + "Pokemon.txt";
        File ficheroinicial = new File(ruta);
        File fichero = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "ficheros"+File.separator+"temp.txt");
        fichero.createNewFile();
        String ruta2 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "ficheros" + File.separator + "temp.txt";

        BufferedWriter bw2 = new BufferedWriter(new FileWriter(ruta2));

            for(Pokemon p:RepositorioPokemones.listaPokemon)
            {
                bw2.write(p.toString());
            }
            bw2.flush();

           InputStream in = new FileInputStream(fichero);
           OutputStream out = new FileOutputStream(ficheroinicial);

           byte[] buf = new byte[1024];
           int len;

           while((len = in.read(buf))>0){

               out.write(buf,0,len);
           }


    }


        public static boolean comprpobarExistencia(int codigo) {

            return listaPokemon.stream().anyMatch(p -> p.getCodigo() == codigo);
    }
    public static int devolverCodigo() {

        return listaPokemon.get(listaPokemon.size()-1).getCodigo();

    }
    public static void anadirPokemon(Pokemon pokemon) {

        listaPokemon.add(pokemon);
    }
    public static void modificarPokemon(Pokemon pokemon)
    {
        for(Pokemon p: listaPokemon)
        {
            if(p.getCodigo() == pokemon.getCodigo())
            {
                p.setNivel(pokemon.getNivel());
                break;
            }
        }
    }

    public static List<Tipos_Pokemon> conseguirTiposPokemon() {

        List<Tipos_Pokemon> listaTipos = new ArrayList<Tipos_Pokemon>();

        listaTipos.add(Tipos_Pokemon.BICHO);
        listaTipos.add(Tipos_Pokemon.ELECTRICO);
        listaTipos.add(Tipos_Pokemon.FUEGO);
        listaTipos.add(Tipos_Pokemon.AGUA);
        listaTipos.add(Tipos_Pokemon.PLANTA);
        listaTipos.add(Tipos_Pokemon.ACCERO);
        listaTipos.add(Tipos_Pokemon.DRAGON);
        listaTipos.add(Tipos_Pokemon.FANTASMA);
        listaTipos.add(Tipos_Pokemon.HADA);
        listaTipos.add(Tipos_Pokemon.HIELO);
        listaTipos.add(Tipos_Pokemon.LUCHA);
        listaTipos.add(Tipos_Pokemon.NORMAL);
        listaTipos.add(Tipos_Pokemon.PSIQUICO);
        listaTipos.add(Tipos_Pokemon.ROCA);
        listaTipos.add(Tipos_Pokemon.TIERRA);
        listaTipos.add(Tipos_Pokemon.VENENO);
        listaTipos.add(Tipos_Pokemon.VOLADOR);
        listaTipos.add(Tipos_Pokemon.NINGUNO);

        listaTipos.sort(Comparator.comparing((Enum::name)));



        return listaTipos;
    }

}
