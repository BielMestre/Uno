package uno;

import uno.views.GUI;
import uno.views.Terminal;
import uno.views.Visor;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        boolean jugar = true;
    //    Visor miVisor = new Terminal();
        Visor miVisor = new GUI();
        miVisor.presentacion();

        // ------- CREAMOS LOS JUGADORES -----------
        List<Player> Jugadores = creaJugadores(miVisor);
        if  (!Jugadores.isEmpty()){
            // ------- LLAMAMOS A BUCLE DE JUEGO -------
            Juego miJuego = new Juego();
            miJuego.run(Jugadores, miVisor);
        }
        // ------- FIN DEL JUEGO -------------------
        miVisor.gameOver();
    }

    public static List<Player> creaJugadores(Visor miVisor) {
        ArrayList<Player> Jugadores;
        Jugadores = new ArrayList<Player>();
        int i= 1;
        String nombre;
        while (true) {
            nombre = miVisor.pideNombreJugador(i);
            if (nombre.equals("") || nombre.isEmpty())
                break;
            else {
                Jugadores.add(new Humano(nombre));
            }
            i++;
        }
     return Jugadores;
    }
}
