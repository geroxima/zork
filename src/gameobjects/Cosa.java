package gameobjects;

import globals.Mass;

/**
 * Esta clase representa un objeto en el juego.
 * Todos los objetos del juego esta basado en la clase Cosa.
 */
public class Cosa {
    private String nombre;
    private String descripcion;
    private boolean takable;
    private boolean movable;
    private ContenedorDeCosas contenedor;
    private int mass;

    public Cosa(String cosa, String descripcion) {
        this.nombre = cosa;
        this.descripcion = descripcion;
        this.mass = Mass.UNKNOWN;
        this.takable = true;
        this.movable = true;
    }

    public Cosa(String cosa, String descripcion, int masa, boolean takable, boolean movable) {
        this.nombre = cosa;
        this.descripcion = descripcion;
        this.mass = masa;
        this.takable = takable;
        this.movable = movable;
    }

    protected String article(String s) {
        char inicial;
        String articulo;

        articulo = "el"; // Default article is masculine singular

        // List of vowels in Spanish
        char[] vocales = { 'a', 'e', 'i', 'o', 'u' };

        // Convert the input string to lowercase and retrieve the first character
        inicial = (s.toLowerCase()).charAt(0);

        // Check if the initial character matches any of the vowels
        for (char c : vocales) {
            if (c == inicial) {
                // If the word starts with a vowel, use "la" instead of "el"
                articulo = "la";
                break; // No need to continue the loop once a vowel is found
            }
        }

        return articulo;
    }

    public int getMass() {
        return mass;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isTakable() {
        return takable;
    }

    public boolean isMovable() {
        return movable;
    }

    public ContenedorDeCosas getContenedor() {
        return contenedor;
    }

    public void setContenedorDeCosas(ContenedorDeCosas contenedor) {
        this.contenedor = contenedor;
    }

    public String describe() {
        return nombre + ", " + descripcion;
    }

    public void setNombre(String cosa) {
        this.nombre = cosa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private boolean isInside(ContenedorDeCosas aContainer) {
        ContenedorDeCosas th;
        Boolean isInContainer = false;
        th = this.getContenedor();
        while (th != null) {
            if (th == aContainer) {
                isInContainer = true;
            }
            th = th.getContenedor();
        }
        return isInContainer;
    }

    public boolean isIn(Cosa c) {
        return (c instanceof ContenedorDeCosas) && (this.isInside((ContenedorDeCosas) c));
    }

}