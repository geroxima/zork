package gameobjects;
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

import java.util.*;

import gameobjects.commands.*;

/**
 * Esta clase puede construir cualquier comando entendido en el juego.
 *
 * Basicamente establece una relacion entre lo que ingresa el usuario
 * en el teclado y el objeto que ejecuta el comando.
 *
 * La implementacion que utilizamos aqui es muy simple, basicamente
 * utiliza un Map para hacerlo altamente mantenible.
 *
 */

public class FabricaDeComandos {

    /**
     * Constructor - inicializa los comandos.
     */
    @SuppressWarnings("unchecked")
    public FabricaDeComandos() {
        // Para agregar un comando nuevo
        // tienes que:
        //
        // 1. Crear una nueva clase de comando
        // 2. Crear una nueva constante en esta clase que indica
        // el nombre del comando que va a usar el usuario
        // 3. No olvidarte de incluirlo en el mapa comandosConocidos
        //
        this.comandosConocidos.put(IR, new ComandoIr());
        this.comandosConocidos.put(AYUDA, new ComandoAyuda());
        this.comandosConocidos.put(SALIR, new ComandoSalir());
        this.comandosConocidos.put(ATRAS, new ComandoAtras());
        this.comandosConocidos.put(VER, new ComandoVer());
        this.comandosConocidos.put(TOMAR, new ComandoTomar());
        this.comandosConocidos.put(DEJAR, new ComandoDejar());
        this.comandosConocidos.put(INVENTARIO, new ComandoInventario());
        this.comandosConocidos.put(DESCRIBIR, new ComandoDescribir());
        this.comandosConocidos.put(HABLAR, new ComandoHablar());
        this.comandosConocidos.put(USAR, new ComandoUsar());
    }

    /**
     * Crea un comando en base a dos palabras. La primera palabra es para
     * indicar que comando usar, la segunda como dato adicional.
     *
     * Por ejemplo si las palabras son "ir" y "norte", va a buscar un comando
     * para "ir" y le va a dar el dato adicional que es "norte".
     *
     * @param palabraComando   la palabra que representa el comando
     * @param palabraAdicional dato adicional que necesita tu comando
     * @return el comando creado
     */
    public Comando crearComando(String palabraComando, String palabraAdicional) {
        return crearComando(palabraComando, new String[] { palabraAdicional });
    }

    public Comando crearComando(String palabraComando, String palabraAdicional1, String palabraAdicional2) {
        return crearComando(palabraComando, new String[] { palabraAdicional1, palabraAdicional2 });
    }

    public Comando crearComando(String palabraComando, String palabraAdicional1, String palabraAdicional2,
            String palabraAdicional3) {
        return crearComando(palabraComando, new String[] { palabraAdicional1, palabraAdicional2, palabraAdicional3 });
    }

    private Comando crearComando(String palabraComando, String[] palabrasAdicionales) {
        Comando comando = (Comando) this.comandosConocidos.get(palabraComando);

        if (null == comando) {
            comando = new ComandoDesconocido();
        } else {
            // no queremos modificar nuestra versión original
            // hacemos una copia para que no afecte en el futuro
            comando = comando.copiar();
        }

        // le decimos qué palabras utilizamos para este comando
        List<String> palabras = new ArrayList<>();
        palabras.add(palabraComando);
        palabras.addAll(Arrays.asList(palabrasAdicionales));
        comando.setPalabras(palabras);
        return comando;
    }

    /**
     * Crea un comando de tipo ComandoDesconocido
     *
     * @return un comando de tipo ComandoDesconocido
     */
    public Comando crearComandoDesconocido() {
        return new ComandoDesconocido();
    }

    /**
     * Devuelve una colleccion que contiene los nombres de los
     * comandos conocidos.
     *
     * @return un objeto de tipo List que con la lista
     *         de nombres de comandos conocidos
     */
    public Collection comandosConocidos() {
        return this.comandosConocidos.keySet();
    }

    // no te olvides de incluir esto en la lista de
    // comandos conocidos
    private static final String IR = "ir";
    private static final String SALIR = "salir";
    private static final String AYUDA = "ayuda";
    private static final String ATRAS = "atras";
    private static final String VER = "ver";
    private static final String TOMAR = "tomar";
    private static final String DEJAR = "dejar";
    private static final String INVENTARIO = "inventario";
    private static final String DESCRIBIR = "describir";
    private static final String HABLAR = "hablar";
    private static final String USAR = "usar";

    // aqui pondremos los comandos que conocemos
    private final Map comandosConocidos = new HashMap();
}
