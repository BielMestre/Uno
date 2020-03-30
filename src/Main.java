
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        boolean jugar = true;
        System.out.println("BIENVENIDO AL UNO DE BIEL (que te sea leve..... :)" );
        System.out.println("******* INSERT COIN ******" );

        // ------- CREAMOS LOS JUGADORES -----------
        List<Player> Jugadores = creaJugadores();
        if  (!Jugadores.isEmpty()){
            // ------- LLAMAMOS A BUCLE DE JUEGO -------
            Juego miJuego = new Juego();
            miJuego.run(Jugadores);
        }
        // ------- FIN DEL JUEGO -------------------
        System.out.println("******* GAME OVER ******");
    }

    public static List<Player> creaJugadores() {
        ArrayList<Player> Jugadores;
        Jugadores = new ArrayList<Player>();
        while (true) {
            Scanner dc = new Scanner(System.in);
            System.out.println("Nombre del jugador (Intro Finalizar): ");
            String nombre = dc.nextLine();
            if (nombre.equals(""))
                break;
            else {
                Jugadores.add(new Humano(nombre));
            }
        }
     return Jugadores;
    }
}
