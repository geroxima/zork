package gameobjects;

import globals.Mass;

public class Actor extends ContenedorDeCosas {
    private Cuarto cuartoActual;
    private static final int MAX_LOAD = 50;
    private int currentLoad = 0;

    // logica para ell inventario del jugador
    private ContenedorDeCosas inventario = new ContenedorDeCosas("inventario", "inventario", Mass.UNKNOWN, false,
            false);

    public Actor(String nombre, String descripcion, Cuarto cuartoActual) {
        super(nombre, descripcion, Mass.UNKNOWN, false, false);
        this.cuartoActual = cuartoActual;
    }

    public ContenedorDeCosas getInventario() {
        return this.inventario;
    }

    public Cuarto getCuartoActual() {
        return this.cuartoActual;
    }

    public void setCuartoActual(Cuarto cuarto) {
        this.cuartoActual = cuarto;
    }

    public int getTotalMass() {
        return currentLoad;
    }

    public int getMaxLoad() {
        return MAX_LOAD;
    }

}