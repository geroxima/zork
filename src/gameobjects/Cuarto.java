package gameobjects;

import java.util.*;

import game.data.DatosDelJuego;
import globals.Direction;
import globals.Mass;

public class Cuarto extends ContenedorDeCosas {

    private Cuarto n, s, w, e, up, down;
    private String descripcion;
    private String descripcionLarga; // Nuevo campo para la descripción larga
    private Cuarto salaAnterior;
    private ArrayList<Cosa> cosas;

    public Cuarto(String nombre) {
        super(nombre, "descripcion", Mass.UNKNOWN, false, false);
        this.n = null;
        this.s = null;
        this.w = null;
        this.e = null;
        this.up = null;
        this.down = null;
        this.cosas = new ArrayList<Cosa>();
    }

    public void init(String descripcion, String descripcionLarga, Cuarto n, Cuarto s, Cuarto w, Cuarto e, Cuarto up,
            Cuarto down) {
        this.descripcion = descripcion;
        this.descripcionLarga = descripcionLarga;
        this.n = n;
        this.s = s;
        this.w = w;
        this.e = e;
        this.up = up;
        this.down = down;
    }

    public void init(String description, String descripcionLarga, Cuarto n, Cuarto s, Cuarto w, Cuarto e) {
        this.descripcion = description;
        this.descripcionLarga = descripcionLarga;
        this.n = n;
        this.s = s;
        this.w = w;
        this.e = e;
        this.up = Direction.NOEXIT;
        this.down = Direction.NOEXIT;
    }

    public String descripcionCorta() {
        return descripcion;
    }

    public String descripcionLarga() {
        return "Estas en " + descripcionLarga + "\n\n" + textoSalidas() + "\n\n" + textoCosas();
    }

    private String textoSalidas() {
        StringBuilder resultado = new StringBuilder("Salidas:");
        if (n != null)
            resultado.append(" Norte");
        if (s != null)
            resultado.append(" Sur");
        if (e != null)
            resultado.append(" Este");
        if (w != null)
            resultado.append(" Oeste");
        if (up != null)
            resultado.append(" Arriba");
        if (down != null)
            resultado.append(" Abajo");
        return resultado.toString();
    }

    private String textoCosas() {
        if (DatosDelJuego.cuartoActual.getCosas().isEmpty()) {
            return "El cuarto está vacío.";
        }

        StringBuilder resultado = new StringBuilder();
        for (Cosa cosa : DatosDelJuego.cuartoActual.getCosas()) {
            resultado.append(Character.toUpperCase(cosa.getNombre().charAt(0)) + cosa.getNombre().substring(1) + ", "
                    + cosa.getMass() + "\n");
        }
        return resultado.toString();
    }

    public Cuarto siguienteCuarto(Direction direccion) {
        switch (direccion) {
            case NORTH:
                return n;
            case SOUTH:
                return s;
            case EAST:
                return e;
            case WEST:
                return w;
            case UP:
                return up;
            case DOWN:
                return down;
            default:
                return null;
        }
    }

    public void agregarCosa(Cosa cosa) {
        cosas.add(cosa);
    }

    public boolean removerCosa(Cosa cosa) {
        return cosas.remove(cosa);
    }

    public ArrayList<Cosa> getCosas() {
        return cosas;
    }

    public void setCosa(ArrayList<Cosa> cosas) {
        this.cosas = cosas;
    }

    // Accesores
    public Cuarto getN() {
        return n;
    }

    public void setN(Cuarto n) {
        this.n = n;
    }

    public Cuarto getS() {
        return s;
    }

    public void setS(Cuarto s) {
        this.s = s;
    }

    public Cuarto getW() {
        return w;
    }

    public void setW(Cuarto w) {
        this.w = w;
    }

    public Cuarto getE() {
        return e;
    }

    public void setE(Cuarto e) {
        this.e = e;
    }

    public Cuarto getUp() {
        return up;
    }

    public void setUp(Cuarto up) {
        this.up = up;
    }

    public Cuarto getDown() {
        return down;
    }

    public void setDown(Cuarto down) {
        this.down = down;
    }

    // Método para establecer la sala anterior
    public void setSalaAnterior(Cuarto salaAnterior) {
        this.salaAnterior = salaAnterior;
    }

    // Método para obtener la sala anterior
    public Cuarto getSalaAnterior() {
        return salaAnterior;
    }
}
