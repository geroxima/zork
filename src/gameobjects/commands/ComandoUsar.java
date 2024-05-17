package gameobjects.commands;

import game.Juego;

public class ComandoUsar extends ComandoAbstracto {

    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Faltan palabras");
        }
        String cosa = (String) getPalabras().get(1);
        juego.usar(cosa);
        return true;
    }

}
