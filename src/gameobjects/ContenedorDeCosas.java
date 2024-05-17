package gameobjects;

import java.util.ArrayList;

public class ContenedorDeCosas extends Cosa {
    private ArrayList<Cosa> cosas;

    public ContenedorDeCosas(String nombre, String descripcion, int masa, boolean takable, boolean movable) {
        super(nombre, descripcion, masa, takable, movable);
        this.cosas = new ArrayList<Cosa>();
    }

    public void agregarCosa(Cosa cosa) {
        this.cosas.add(cosa);
    }

    public boolean removerCosa(Cosa cosa) {
        return this.cosas.remove(cosa);
    }

    public ArrayList<Cosa> getCosas() {
        return this.cosas;
    }

    public int getTotalMass() {
        int totalMass = 0;
        for (Cosa cosa : this.cosas) {
            totalMass += cosa.getMass();
        }
        return totalMass;
    }
}
