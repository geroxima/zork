package gameobjects.commands;

import game.Juego;

public class ComandoHablar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Faltan palabras");
        }
        String nombre = (String) getPalabras().get(1);

        if (nombre == null || nombre.isEmpty()) {
            juego.imprimir("No se proporcionó un tema para hablar.");
            return true;
        }
        if (juego.getCuartoActual().getNombre().equals("Sala de Muther")) {
            juego.hablarConMuther(nombre);
            return true;
        } else {
            juego.imprimir("No hay nadie con quien hablar aquí.");
            return true;
        }
    }
}