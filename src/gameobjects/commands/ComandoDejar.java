package gameobjects.commands;

import game.Juego;

public class ComandoDejar extends ComandoAbstracto {

    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Faltan palabras");
        }
        String nombreCosa = getPalabras().get(1);
        juego.dejarCosa(nombreCosa);
        return true;
    }
}