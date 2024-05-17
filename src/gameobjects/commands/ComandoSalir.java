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

/**
 * Este comando termina el juego.
 */
public class ComandoSalir extends ComandoAbstracto {

    /**
     * Hace que el juego termine (a menos que el usuario ingreso mal el
     * comando)
     */
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() > 2) {
            juego.imprimir("Salir de que?");
        } else {
            // indicar que queremos salir
            return false;
        }
        return true;
    }

}
