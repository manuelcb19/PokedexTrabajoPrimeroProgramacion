package modelo;

import enumerado.Tipos_Pokemon;

public class Pokemon {

    private Pokemon pokemon;

    private int codigo;

    private String nombre;

    private Tipos_Pokemon tipoPokemon;

    private int nivel;

    private int fuerza;

    private int defensa;

    private int vidaBase;

    public Pokemon(int codigo, String nombre, Tipos_Pokemon tipoPokemon, int nivel, int fuerza, int defensa, int vidaBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoPokemon = tipoPokemon;
        this.nivel = nivel;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.vidaBase = vidaBase;
    }

    public int getCodigo() {
        return codigo;
    }

    public int calcularFuerza()
    {
        return (this.fuerza * this.nivel);

    }

    public int calcularDefensa()
    {
        return getDefensa()*getNivel();

    }


    public int calcularVidaBase()
    {
        return getVidaBase()*getNivel();

    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipos_Pokemon getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(Tipos_Pokemon tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public void setVidaBase(int vidaBase) {
        this.vidaBase = vidaBase;
    }

    public String devolverTipo()
    {
        return getTipoPokemon().toString();
    }

    @Override
    public String toString() {

        StringBuffer sp = new StringBuffer();

       sp.append(codigo +
                "," + nombre +
                "," + tipoPokemon +
                "," + nivel +
                "," + fuerza +
                "," + defensa +
                "," + vidaBase+"\n");

       return sp.toString();
    }

    public void setPokemon (Pokemon pokemon)
    {
        this.pokemon = pokemon;
    }


}
