package gameobjects.commands;
import game.Juego;

public class ComandoVer extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        juego.ver();
        return true;
  }
}
