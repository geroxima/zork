package gameobjects.commands;

import game.Juego;

public class ComandoInventario extends ComandoAbstracto {

    public boolean ejecutar(Juego juego) {
        juego.verInventario();
        return true;
    }
}