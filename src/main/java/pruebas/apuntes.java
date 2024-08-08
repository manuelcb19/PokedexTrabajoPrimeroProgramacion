package pruebas;

import java.io.*;

public class apuntes {
    public static final String RUTA = System.getProperty("user.dir") + File.separator + "ficheros" + File.separator;

    public static File creaFile(String directorio, String nombreFichero){
        return new File(directorio + nombreFichero + ".txt");
    }

    public static FileReader creaFileReader(String ruta, String nombre) throws FileNotFoundException {
        FileReader fr = null;

        fr = new FileReader(ruta + nombre + ".txt");
        return fr;
    }

    public static FileWriter creaFileWriter(File fichero, boolean escribirAlFinal){
        FileWriter fw = null;

        try{
            fw = new FileWriter(fichero, escribirAlFinal);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return fw;
    }

    public static BufferedReader creaBufferReader(FileReader fr){
        return new BufferedReader(fr);
    }

    public static BufferedWriter creaBufferWriter(FileWriter fw){
        return new BufferedWriter(fw);
    }

    public static String leeFichero(FileReader fr){
        StringBuilder sb = new StringBuilder();
        sb.append("\nContenido del fichero: \n");
        try {
            int valor = fr.read();

            while (valor != -1) {
                sb.append((char) valor);
                valor = fr.read();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return sb.toString();
    }

    public static String leeFichero(BufferedReader br){
        StringBuilder sb = new StringBuilder();
        sb.append("\nContenido del fichero: \n");
        try {
            String linea = br.readLine();

            while(linea != null){
                sb.append(linea);
                sb.append("\n");
                linea = br.readLine();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return sb.toString();
    }
}