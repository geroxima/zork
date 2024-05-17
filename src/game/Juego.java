package game;
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

import gameobjects.Actor;
import gameobjects.Cosa;
import gameobjects.Cuarto;
import gameobjects.commands.Comando;
import globals.Direction;
import game.data.DatosDelJuego;

import java.util.List;
import java.util.Random;
// import gameobjects.Actor;

/**
 * Esta clase es la principal para la aplicacion "Zork". Zork es un juego de
 * aventuras, simple, y basado en texto.
 *
 * En esta version, los usuarios pueden caminar através de algunos cuartos.
 * Eso es todo. Realmente el juego deberia ser extendido para volverse mas
 * interesante.
 *
 * Para jugarlo, se debe crear una instancia de esta clase y llamar el metodo
 * "jugar"
 *
 * Esta clase crea inicializa a todas las otras, aqui empieza todo: crea todos
 * los Cuartos, crea los parsers (objetos que interpretan texto) y comienza el
 * juego. Tambien evalua los comandos que devuelve el parser.
 */

// import java.util.Stack;
@SuppressWarnings("static-access")

public class Juego {

    private Parser parser;
    private DatosDelJuego datosDelJuego;

    /**
     * Crea el juego e inicializa su mapa interno
     */
    public Juego() {
        // crearCuartos();
        parser = new Parser();
        datosDelJuego = new DatosDelJuego();
        datosDelJuego.initGame();
    }

    /**
     * Rutina principal: jugar. Itera hasta el fin del juego..
     */
    public void jugar() {

        imprimir(datosDelJuego.getMensajeDeBienvenida());
        imprimir(datosDelJuego.cuartoActual.descripcionLarga());

        // Jugar hasta que un comando me diga que ya no quiere jugar mas
        boolean continuar = true;
        while (continuar) {
            moverAlienAleatoriamente(datosDelJuego.alien);
            Comando comando = parser.getComando();
            continuar = comando.ejecutar(this);
        }
        imprimir("Gracias por jugar. ¡Hasta la próxima!");
    }

    public Cuarto getCuartoActual() {
        return datosDelJuego.cuartoActual;
    }

    public Cuarto getCuartoActualAlien() {
        return datosDelJuego.alien.getCuartoActual();
    }

    public Actor getJugador() {
        return datosDelJuego.jugador;
    }

    public Actor getAlien() {
        return datosDelJuego.alien;
    }

    public boolean getAutodestruccion() {
        return datosDelJuego.isAuoDestructActivated;
    }

    /**
     * Intenta ir en una direccion. Si esta fue una salida, entra a otra
     * habitacion, en caso contrario imprime un mensaje de error.
     */
    public void irA(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            imprimir("¿Ir dónde?");
            return;
        }

        // Convertir la dirección a mayúsculas
        direccion = direccion.toUpperCase();

        // Intentar salir del cuarto
        Cuarto siguienteCuarto = null;
        switch (direccion) {
            case "NORTE":
            case "N":
                siguienteCuarto = datosDelJuego.cuartoActual.siguienteCuarto(Direction.NORTH);
                break;
            case "SUR":
            case "S":
                siguienteCuarto = datosDelJuego.cuartoActual.siguienteCuarto(Direction.SOUTH);
                break;
            case "ESTE":
            case "E":
                siguienteCuarto = datosDelJuego.cuartoActual.siguienteCuarto(Direction.EAST);
                break;
            case "OESTE":
            case "O":
            case "W":
                siguienteCuarto = datosDelJuego.cuartoActual.siguienteCuarto(Direction.WEST);
                break;
            case "UP":
            case "ARRIBA":
                siguienteCuarto = datosDelJuego.cuartoActual.siguienteCuarto(Direction.UP);
                break;
            case "ABAJO":
                siguienteCuarto = datosDelJuego.cuartoActual.siguienteCuarto(Direction.DOWN);
                break;
        }

        if (siguienteCuarto == null || siguienteCuarto == Direction.NOEXIT) {
            imprimir("No hay salidas hacia ahí");
        } else {
            siguienteCuarto.setSalaAnterior(datosDelJuego.cuartoActual);
            datosDelJuego.cuartoActual = siguienteCuarto;
            imprimir(datosDelJuego.cuartoActual.descripcionLarga());
        }
    }

    public void atras() {
        // Obtener la sala anterior desde la sala actual y establecerla como la sala
        // actual
        if (datosDelJuego.cuartoActual.getSalaAnterior() != null) {
            datosDelJuego.cuartoActual = datosDelJuego.cuartoActual.getSalaAnterior();
            imprimir("Has vuelto a la sala anterior.");
            imprimir(datosDelJuego.cuartoActual.descripcionLarga());
        } else {
            imprimir("No hay salas anteriores.");
        }
    }

    public void ver() {
        imprimir(datosDelJuego.cuartoActual.descripcionLarga());
    }

    public void tomarCosa(String nombre) {
        for (Cosa cosa : DatosDelJuego.cuartoActual.getCosas()) {
            if (cosa.getNombre().equals(nombre)) {
                if (DatosDelJuego.jugador.getInventario().getTotalMass() + cosa.getMass() <= DatosDelJuego.jugador
                        .getMaxLoad()) {
                    // Add the Cosa to the inventory and remove it from the room
                    DatosDelJuego.jugador.getInventario().agregarCosa(cosa);
                    DatosDelJuego.cuartoActual.removerCosa(cosa);
                    imprimir("Has tomado " + nombre + ".");
                } else {
                    imprimir("No puedes llevar más cosas en tu inventario. Deja algo primero.");
                }
                return;
            }
        }
        imprimir("No hay " + nombre + " aquí.");
    }

    public void dejarCosa(String nombre) {
        // Find the Cosa in the inventory
        for (Cosa cosa : DatosDelJuego.jugador.getInventario().getCosas()) {
            if (cosa.getNombre().equals(nombre)) {
                // Add the Cosa to the room and remove it from the inventory
                DatosDelJuego.cuartoActual.agregarCosa(cosa);
                DatosDelJuego.jugador.getInventario().removerCosa(cosa);
                imprimir("Has dejado " + nombre + ".");
                return;
            }
        }

        imprimir("No tienes " + nombre + " en tu inventario.");
    }

    public void verInventario() {
        imprimir("Inventario:");
        if (DatosDelJuego.jugador.getInventario().getCosas().isEmpty()) {
            imprimir("El inventario está vacío.");
        } else {
            for (Cosa cosa : DatosDelJuego.jugador.getInventario().getCosas()) {
                imprimir(cosa.getNombre());
            }
        }
    }

    public void describir(String nombre) {
        for (Cosa cosa : datosDelJuego.cuartoActual.getCosas()) {
            if (cosa.getNombre().equals(nombre)) {
                String descripcion = cosa.getDescripcion();
                descripcion = descripcion.substring(0, 1).toUpperCase() + descripcion.substring(1);
                imprimir(descripcion);
                return;
            }
        }
        imprimir("No hay " + nombre + " aquí.");
    }

    public void hablarConMuther(String topic) {
        switch (topic.toLowerCase()) {
            case "monstruo":
            case "alien":
                imprimir(
                        "MUTHER: El alien, también conocido como xenomorfo, es una forma de vida altamente agresiva y letal. Posee una fuerza y astucia extraordinarias. Cualquier encuentro con él debe ser evitado, ya que representa una grave amenaza para tu seguridad. No existen maneras registradas de dañarlo. Puedes encontrar un arma en la sala de equipos, pero ten cuidado, ya que no garantiza tu supervivencia.");
                break;
            case "cerberus":
            case "nave":
                imprimir(
                        "MUTHER: La nave Cerberus es de hecho una nave espacial avanzada, que cuenta con tecnología de vanguardia y sistemas de última generación. Fue diseñada para misiones de exploración de largo alcance, equipada con cámaras de hipersueño para viajes extendidos a través del cosmos.");
                break;
            case "ganar":
            case "escapar":
                imprimir(
                        "MUTHER: Escapar con vida de la nave Cerberus requiere un plan cuidadoso. En primer lugar, debes activar la secuencia de autodestrucción de la nave desde la sala de control central con una llave de acceso del capitán. Una vez iniciada, tienes un tiempo limitado para llegar a las cápsulas de escape, ubicadas en las cubiertas traseras de la nave. Date prisa, y que la fortuna favorezca tu escape.");
                break;
            case "tripulacion":
                imprimir(
                        "MUTHER: No tengo información sobre la tripulación de la nave Cerberus. Todos los registros de los tripulantes desaparecieron luego de una breve visita al planeta LV-426. No se sabe si están vivos o muertos. Procede con precaución.");
                break;
            case "autodestruccion":
                imprimir(
                        "MUTHER: La secuencia de autodestrucción de la nave Cerberus es irreversible. Una vez activada, no puede ser detenida. Asegúrate de estar listo para escapar antes de iniciarla.");
                break;
            default:
                imprimir(
                        "MUTHER: No tengo información sobre ese tema. Por favor, sé más específico en tu pregunta.");
                break;
        }
    }

    public void usar(String nombre) {
        if (nombre.equals("radar") || datosDelJuego.jugador.getInventario().getCosas().contains("radar")) {
            imprimir("El radar muestra que el alien se encuentra en "
                    + datosDelJuego.alien.getCuartoActual().getNombre());
        } else if (nombre.equals("clave") || datosDelJuego.jugador.getInventario().getCosas().contains("clave")) {
            if (datosDelJuego.cuartoActual.getNombre().equals("Sala de Control Alpha")) {
                imprimir("Has activado la secuencia de autodestrucción de la nave Cerberus. ¡Date prisa y escapa!");
                datosDelJuego.setAutodestruccion(true);
            } else {
                imprimir("No puedes usar la clave aquí.");
            }
        } else {
            imprimir("No puedes usar eso.");
        }
    }

    public void moverAlienAleatoriamente(Actor alien) {
        List<Cuarto> cuartos = datosDelJuego.getMapa(); // Assuming you have a method to get all rooms
        Random random = new Random();
        int index = random.nextInt(cuartos.size());
        Cuarto cuartoAleatorio = cuartos.get(index);
        alien.setCuartoActual(cuartoAleatorio);
    }

    private void typeTextWithAnimation(String text, int delayMillis) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));

            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    /**
     * Imprime un mensaje para el usuario
     *
     * @param mensaje
     */
    public void imprimir(String mensaje) {
        typeTextWithAnimation(mensaje, 7);
    }

    /**
     * Pasa a la siguiente linea.
     *
     */
    public void imprimir() {
        System.out.println();
    }

    /**
     * Imprime un mensaje para el usuario, pero
     * se queda en la misma linea.
     *
     * @param mensaje
     */
    public void imprimirCont(String mensaje) {
        System.out.print(mensaje);
    }
}
