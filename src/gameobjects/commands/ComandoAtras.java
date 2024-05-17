package gameobjects.commands;
import game.Juego;

public class ComandoAtras extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Faltan palabras");
        }
        juego.atras();
        return true;

    }
}
