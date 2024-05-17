package gameobjects.commands;
/*
 * Universidad Nacional de Itapua.
 * Proyecto Zork.
 *
 * Autor Original: Michael Kolling, Universidad de Monash
 * Version: 1.1
 * Date: March 2000
 * Copyright (c) Michael Kolling
 *
 * Nombre del Alumno: Adán Alvarez
 *
 */

import game.Juego;
import gameobjects.Cosa;

/**
 * Esta clase es un comando que cambia el cuarto actual del protagonista
 * del juego.
 *
 */
public class ComandoIr extends ComandoAbstracto {

    /**
     * Intenta ir en la direccion indicada.
     *
     */
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Faltan palabras");
        }
        String direccion = (String) getPalabras().get(1);
        juego.irA(direccion);
        if (juego.getCuartoActual().equals(juego.getCuartoActualAlien())) {
            boolean tieneLanzallamas = false;
            for (Cosa cosa : juego.getJugador().getInventario().getCosas()) {
                if (cosa.getNombre().equals("lanzallamas")) {
                    tieneLanzallamas = true;
                    break;
                }
            }
            if (tieneLanzallamas) {
                juego.imprimir(
                        "El monstruoso ser ha aparecido en la sala en la que estas \nHas usado el lanzallamas para espantarlo, no sabes por cuanto tiempo. El juego continúa.");
                juego.moverAlienAleatoriamente(juego.getAlien()); // Assuming you have a method to move the alien
            } else {
                juego.imprimir("El alien te ha atrapado, has perdido el juego.");
                return false;
            }
        } else if (juego.getCuartoActual().getNombre().equals("Capsulas de escape")) {
            if (juego.getAutodestruccion()) {
                juego.imprimir(
                        "\n\nHas escapado a tiempo, felicidades, has ganado el juego. \n\nLa nave inicio su secuencia de autodestrucción, de manera implacable logras ingresar al Icaro, la capsula de escape disponible. Sales disparado y grabas un mensaje \"Esperemos que este haya sido el fin.\"");
                return false;
            } else {
                juego.imprimir("No puedes escapar, la autodestrucción no ha sido activada.");
                return true;
            }
        }
        return true;
    }

}
