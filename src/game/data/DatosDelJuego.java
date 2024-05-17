package game.data;

import gameobjects.Cuarto;
import gameobjects.ContenedorDeCosas;
import gameobjects.Cosa;
import globals.Direction;
import globals.Mass;

import java.lang.reflect.Array;
// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import gameobjects.Actor;

public class DatosDelJuego {
        public static Cuarto cuartoActual;
        public static Actor jugador;
        private static String mensajeDeBienvenida;
        public static Actor alien;
        private List<Cuarto> mapa = new ArrayList<Cuarto>();
        public boolean isAuoDestructActivated = false;

        public void initGame() {
                // ContenedorDeCosas cosasDeSalaDeHiper = new ContenedorDeCosas("null", null, 0,
                // false, false);

                ArrayList<Cosa> cosasSaladeHiper = new ArrayList<Cosa>();
                ArrayList<Cosa> cosasPasillo = new ArrayList<Cosa>();
                ArrayList<Cosa> cosasAlmacenA = new ArrayList<Cosa>();
                ArrayList<Cosa> cosasAlmacenB = new ArrayList<Cosa>();
                ArrayList<Cosa> cosasSalaMedica = new ArrayList<Cosa>();
                ArrayList<Cosa> cosasSalaDeIngenieriaAuxiliar = new ArrayList<Cosa>();
                ArrayList<Cosa> cosasSalaDeControlAlfa = new ArrayList<Cosa>();
                ArrayList<Cosa> cosasAlmacenDeIngenieria = new ArrayList<Cosa>();
                ArrayList<Cosa> cosasSalaDeEquipos = new ArrayList<Cosa>();

                // Cuartos Superiores
                Cuarto salaDeHipersueño = new Cuarto("Sala de Hipersueño");
                Cuarto pasillo = new Cuarto("Pasillo");
                Cuarto almacenA = new Cuarto("Almacen de recursos A");
                Cuarto comedor = new Cuarto("Comedor");
                Cuarto capsulasDeEscape = new Cuarto("Capsulas de escape");
                Cuarto pasilloB = new Cuarto("Pasillo B");
                Cuarto salaMedica = new Cuarto("Sala Medica");
                Cuarto almacenB = new Cuarto("Almacen de recursos B");
                Cuarto salaDeIngenieriaAuxiliar = new Cuarto("Sala de Ingenieria Auxiliar");
                Cuarto salaDeControlAlfa = new Cuarto("Sala de Control Alpha");
                Cuarto salaDeControlBeta = new Cuarto("Sala de Control Beta");
                Cuarto salaDeControlGamma = new Cuarto("Sala de Control Gamma");
                Cuarto salaDeMuther = new Cuarto("Sala de Muther");

                // Cuartos Inferiores
                Cuarto almacenDeIngenieria = new Cuarto("Almacen de Ingenieria");
                Cuarto almacenDeMecanica = new Cuarto("Almacen de Mecanica");
                Cuarto salaDeEquipos = new Cuarto("Sala de Equipos");
                Cuarto camaraDePropulsores = new Cuarto("Camara de Propulsores");
                Cuarto administracionDeIngeniería = new Cuarto("Administracion de Ingeniería");
                Cuarto generador = new Cuarto("Generador");
                Cuarto cubiertaDeMotores = new Cuarto("Cubierta de Motores");

                // cosas sala de hipersueño
                Cosa libro = new Cosa("libro", "un libro de ciencia ficción", Mass.SMALL, true, true);
                cosasSaladeHiper.add(libro);

                // cosas pasillo
                Cosa ropa = new Cosa("ropa", "ropa de tripulante ensangrentada", Mass.TINY, true, true);
                cosasPasillo.add(ropa);

                // cosas almacen A
                Cosa comida = new Cosa("comida", "comida enlatada", Mass.TINY, true, true);
                cosasAlmacenA.add(comida);

                // cosas sala de ingenieria auxiliar
                Cosa llave = new Cosa("llave", "una llave oxidada", Mass.TINY, true, true);
                Cosa cajaDeHerramientas = new Cosa("caja", "una caja de herramientas", Mass.MEDIUM, true, true);
                Cosa radar = new Cosa("radar", "un radar portátil que detecta movimientos de manera precisa",
                                Mass.MEDIUM, true, true);
                cosasSalaDeIngenieriaAuxiliar.add(llave);
                cosasSalaDeIngenieriaAuxiliar.add(cajaDeHerramientas);
                cosasSalaDeIngenieriaAuxiliar.add(radar);

                // cosas almacen de ingenieria
                Cosa llaveInglesa = new Cosa("llave", "una llave inglesa", Mass.SMALL, true, true);
                Cosa mascaraDeSoldar = new Cosa("mascara", "una mascara de soldar", Mass.SMALL, true, true);
                cosasAlmacenDeIngenieria.add(llaveInglesa);
                cosasAlmacenDeIngenieria.add(mascaraDeSoldar);

                // cosas sala medica
                Cosa botiquin = new Cosa("botiquin", "un botiquin de primeros auxilios", Mass.MEDIUM, true, true);
                Cosa medicina = new Cosa("medicina", "una medicina desconocida", Mass.TINY, true, true);
                Cosa jeringa = new Cosa("jeringa", "una jeringa", Mass.TINY, true, true);
                Cosa bisturi = new Cosa("bisturi", "un bisturi", Mass.TINY, true, true);
                Cosa facehugger = new Cosa("criatura", "un criatura muerto", Mass.MEDIUM, true, true);
                cosasSalaMedica.add(botiquin);
                cosasSalaMedica.add(medicina);
                cosasSalaMedica.add(jeringa);
                cosasSalaMedica.add(bisturi);
                cosasSalaMedica.add(facehugger);

                // cosas almacen B
                Cosa herramientas = new Cosa("herramientas", "herramientas de mecanica", Mass.MEDIUM, true, true);
                Cosa cajaDeHerramientasB = new Cosa("caja", "una caja de herramientas", Mass.MEDIUM, true, true);
                cosasAlmacenB.add(herramientas);
                cosasAlmacenB.add(cajaDeHerramientasB);

                // cosas sala de ingenieria auiliar
                Cosa notas = new Cosa("notas", "notas de ingeniería", Mass.SMALL, true, true);
                cosasSalaDeIngenieriaAuxiliar.add(notas);

                // cosas sala de equipos
                Cosa claveDeAutodestruccion = new Cosa("clave",
                                "una tarjeta de acceso con la clave de autodestrucción", Mass.TINY, true, true);
                Cosa comunicador = new Cosa("comunicador", "un comunicador de emergencia, chistosamente no funciona",
                                Mass.TINY, true, true);
                Cosa lanzallamas = new Cosa("lanzallamas", "un pesado y rudimentario lanzallamas, servirá de arma",
                                Mass.MEDIUM, true, true);
                cosasSalaDeEquipos.add(claveDeAutodestruccion);
                cosasSalaDeEquipos.add(comunicador);
                cosasSalaDeEquipos.add(lanzallamas);

                // cosas sala de control alfa
                Cosa taza = new Cosa("taza", "una taza de café", Mass.TINY, true, true);
                Cosa registroDeVoz = new Cosa("registro",
                                "un registro de voz. Registro de voz del tripulante 3471.\n"
                                                +
                                                "\n" +
                                                "Grabación: [Sonidos de respiración agitada]\n" +
                                                "Tripulante 3471:\n Este es el tripulante 3471, registrando una emergencia a bordo. Hemos encontrado alien. ¡Repito, hemos encontrado un alien! Es peligroso, extremadamente peligroso. Se llevó a Jenkins. Esa cosa salio desde el pecho de Robinson, fue horrible. ¡Dios mío, lo desgarró! ¡Huye si lo ves! No intentes enfrentarlo, ¡es letal! ¡Repito, es letal! [Sonidos de lucha y gritos ahogados]\n\n"
                                                +
                                                "Fin de la grabación.",
                                Mass.TINY, true, true);
                cosasSalaDeControlAlfa.add(taza);
                cosasSalaDeControlAlfa.add(registroDeVoz);

                // N, S, W, E, U, D
                salaDeHipersueño.init("La sala de hipersueño en la que despertarste",
                                "una ultramoderna habitación con capsulas de hipersueño que se desprienden de manera geométrica desde el centro de la sala hacia los extremos\nEn las paredes hay casilleros con los nombres de los integrantes de la tripulación",
                                Direction.NOEXIT, pasillo, Direction.NOEXIT, Direction.NOEXIT);

                salaDeHipersueño.setCosa(cosasSaladeHiper);

                pasillo.init("Una tenue y extensa pasarela",
                                "un tenue y claustrofóbico pasillo, sientes la tensión en el ambiente, con luces parpadeantes a los lados y salidas a los extremos",
                                salaDeHipersueño, almacenA, Direction.NOEXIT, Direction.NOEXIT);

                pasillo.setCosa(cosasPasillo);

                almacenA.init("Un almacén de recursos",
                                "un almacén de recursos de forma hexagonal con estantes de metal llenos de provisiones y herramientas, trajes de exploración y contenedores especiales",
                                comedor, capsulasDeEscape, pasilloB, pasillo, Direction.NOEXIT, almacenDeIngenieria);
                almacenA.setCosa(cosasAlmacenA);

                comedor.init("Un comedor",
                                "un comedor con una mesa central y sillas alrededor, una cocina industrial, gabinetes con comida, un microondas y un refrigerador",
                                salaDeIngenieriaAuxiliar, almacenA, Direction.NOEXIT, Direction.NOEXIT);

                salaDeIngenieriaAuxiliar.init("Sala de Ingeniería auxiliar",
                                "la sala de ingeniería auxiliar que se sumerge en un silencio sepulcral, con maquinaria inerte y paneles apagados. Tubos y conductos yacen estáticos en las paredes, mientras la soledad envuelve cada rincón, recordando un tiempo en el que esta sala era el centro de actividad, ahora abandonada y silenciosa en la vastedad del espacio. Hay tres entradas a las salas de control y una escalera que lleva a la sala de MUTHER",
                                salaDeControlAlfa, comedor, salaDeControlBeta, salaDeControlGamma, salaDeMuther,
                                almacenB);
                salaDeIngenieriaAuxiliar.setCosa(cosasSalaDeIngenieriaAuxiliar);
                salaDeControlAlfa.init("Sala de control alfa",
                                "la Sala de Control ALPHA, una sala que através de una gran ventana, el espacio se despliega majestuosamente, revelando la imponente presencia del planeta Acheron (LV-426). Su superficie hostil yace quieta bajo una capa de niebla, una vista cautivadora que contrasta con la quietud de la sala de control Alfa, donde el eco de la exploración pasada aún resuena en el aire",
                                Direction.NOEXIT, salaDeIngenieriaAuxiliar, Direction.NOEXIT, Direction.NOEXIT);
                salaDeControlAlfa.setCosa(cosasSalaDeControlAlfa);

                salaDeControlGamma.init("Sala de control Gamma",
                                "la sala de control GAMMA, la penumbra envuelve las consolas silenciosas y las pantallas inactivas. A través de la gran ventana, el espacio se extiende hasta el horizonte, revelando la majestuosidad de un planeta lejano, Acheron (LV-426), bañado en la luz de una estrella distante. La soledad de la sala contrasta con la vastedad del cosmos, creando un ambiente de melancolía y asombro ante la inmensidad del universo",
                                Direction.NOEXIT, Direction.NOEXIT, salaDeIngenieriaAuxiliar, Direction.NOEXIT);
                salaDeControlBeta.init("Sala de control Beta",
                                "la sala de control BETA, la oscuridad se cierne sobre las consolas inertes y las pantallas apagadas. A través de la amplia ventana, el espacio se abre ante tus ojos, revelando el misterio del planeta Acheron (LV-426) en la distancia. La soledad impregna el ambiente, recordando días de actividad ahora perdidos en el silencio del cosmos",
                                Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT,
                                salaDeIngenieriaAuxiliar);

                salaDeMuther.init("Sala de MUTHER 6000",
                                "la sala de MUTHER 6000, una atmósfera tensa y silenciosa prevalece. La vasta inteligencia artificial, encerrada en su núcleo de procesamiento, emana una presencia omnipotente. Luces parpadeantes iluminan los paneles de control, mientras la voz fría de MUTHER 6000 se desliza ocasionalmente por el espacio vacío, recordando su autoridad en la nave desierta",
                                Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT,
                                Direction.NOEXIT, salaDeIngenieriaAuxiliar);

                pasilloB.init("Un estrecho pasillo",
                                "un estrecho pasillo con una puerta al final, en el medio hay otra entrada que lleva a una sala con ventanas",
                                almacenB, almacenA, Direction.NOEXIT, salaMedica);

                salaMedica.init("Una sala con equipamiento de salud",
                                "una sala médica abandonada y sombría, En el suelo de la sala médica, una criatura de aspecto insectoide yace inerte, con apéndices retorcidos extendiéndose desde su cuerpo. Su presencia evoca una sensación de peligro latente en el aire. Equipamiento médico adorna las paredes, recordando días de curación ahora olvidados en el silencio tétrico.",
                                Direction.NOEXIT, Direction.NOEXIT, pasilloB, Direction.NOEXIT);
                almacenB.init("Un almacen de recursos",
                                "un almacén de recursos con estantes de metal llenos de provisiones y herramientas",
                                Direction.NOEXIT, pasilloB, Direction.NOEXIT, salaDeIngenieriaAuxiliar,
                                Direction.NOEXIT, almacenDeMecanica);

                capsulasDeEscape.init("Capsulas de escape",
                                "una sala iluminada por tenues luces rojas, se encuentran las dos cápsulas de escape del Cerberus, el Ícaro y el Estigia. Equipadas con sistemas de propulsión y suministros de emergencia, ofrecen un refugio en momentos críticos, listas para lanzarse hacia la seguridad en el vacío implacable del espacio.",
                                almacenA, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT);

                // HABITACIONES INFERIORES

                almacenDeIngenieria.init("Almacen de recursos",
                                "El almacén de recursos de ingeniería inferior es un espacio oscuro y claustrofóbico, lleno de estanterías metálicas abarrotadas de herramientas oxidadas y suministros escasos. La luz parpadeante apenas ilumina el desorden, creando sombras inquietantes entre los pasillos estrechos.",
                                Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, administracionDeIngeniería,
                                almacenA,
                                Direction.NOEXIT);

                almacenDeMecanica.init("Almacen de mecanica", "un almacen oscuro y polvoriento lleno de herramientas",
                                generador, cubiertaDeMotores, Direction.NOEXIT, Direction.NOEXIT, almacenB,
                                Direction.NOEXIT);

                generador.init("Generador",
                                "una sala con un generador de energía principal, con un zumbido constante y luces parpadeantes",
                                Direction.NOEXIT, administracionDeIngeniería, almacenDeMecanica, Direction.NOEXIT);

                administracionDeIngeniería.init("Administracion de Ingeniería",
                                "una sala de control con consolas y pantallas de control, con una ventana que da a la cubierta de motores",
                                generador, almacenDeIngenieria, Direction.NOEXIT, salaDeEquipos);

                salaDeEquipos.init("Sala de Equipos", "una sala con equipos de comunicación y monitores de control",
                                Direction.NOEXIT, Direction.NOEXIT, administracionDeIngeniería, Direction.NOEXIT);
                salaDeEquipos.setCosa(cosasSalaDeEquipos);

                cubiertaDeMotores.init("Cubierta de Motores",
                                "la cubierta de motores, una vasta extensión de maquinaria y tuberías, con motores gigantes que zumban y chisporrotean en la oscuridad. La sala se extiende en la distancia, con pasarelas y escaleras que se pierden en la penumbra, creando una sensación de vastedad y peligro en el aire.",
                                almacenDeMecanica, camaraDePropulsores, Direction.NOEXIT, Direction.NOEXIT);

                camaraDePropulsores.init("Camara de propulsores",
                                "una sombría y tenue sala con motores, ruidosa y caliente",
                                cubiertaDeMotores, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT);

                cuartoActual = salaDeHipersueño;

                jugador = new Actor("jugador", "un jugador", cuartoActual);
                alien = new Actor("alien", "un peligroso xenomorfo", cubiertaDeMotores);

                // habitaciones en las que el alien puede aparecer
                // Solo se puede mover entre las habitaciones inferiores
                // Para poder hacer el juego un poco más justo
                mapa.add(cubiertaDeMotores);
                mapa.add(generador);
                mapa.add(camaraDePropulsores);
                mapa.add(salaDeEquipos);
                mapa.add(almacenDeMecanica);
                mapa.add(almacenDeIngenieria);

                setMensajeDeBienvenida();

        }

        public List<Cuarto> getMapa() {
                return mapa;
        }

        public boolean setAutodestruccion(boolean status) {
                isAuoDestructActivated = status;
                return isAuoDestructActivated;
        }

        private void setMensajeDeBienvenida() {
                mensajeDeBienvenida = " ____  _____ ____  ____  _____ ____  _     ____ \n" +
                                "/   _\\/  __//  __\\/  _ \\/  __//  __\\/ \\ /\\/ ___\\\n" +
                                "|  /  |  \\  |  \\/|| | //|  \\  |  \\/|| | |||    \\\n" +
                                "|  \\__|  /_ |    /| |_\\\\|  /_ |    /| \\_/|\\___ |\n" +
                                "\\____/\\____\\\\_/\\_\\\\____/\\____\\\\_/\\_\\\\____/\\____/\n" +
                                "                                                \n\n" +
                                "Te encuentras a bordo de la nave espacial Cerberus,\n" +
                                "una nave de carga en una misión de exploración\n" +
                                "en los confines del espacio.\n" +
                                "Como miembro de la tripulación, tu tarea es investigar\n" +
                                "un misterioso incidente que ha dejado la nave a la deriva\n" +
                                "en el espacio profundo.\n" +
                                "Al despertar de la criogenización en hipersueño, te das cuenta\n" +
                                "de que algo ha salido terriblemente mal a bordo.\n" +
                                "La tripulación ha desaparecido, y la nave esatrtá en un estado de caos.\n" +
                                "Pronto descubres que no estás solo.\n" +
                                "Una letal criatura alienígena se ha infiltrado en la nave.\n" +
                                "Tu misión es ir a la sala de control y activar el sistema de autodestrucción\n" +
                                "Debes hablar con la inteligencia artificial de la nave, MUTHER 6000\n";
        }

        public String getMensajeDeBienvenida() {
                return mensajeDeBienvenida;
        }

}