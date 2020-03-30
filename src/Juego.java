import java.util.LinkedList;
import java.util.List;

public class Juego {
    private Carta ultCarta;
    private Carta selCarta;
    private Carta.Color ultColor;
    private List<Player> Jugadores;
    private Baraja miBaraja;
    private LinkedList<Carta> Rechazadas;
    int turnoPlayer = 0;
    String sentido = "delante";
    public boolean jugar = true;

    //ultCarta = new Carta();

    // contructor de la clase juego
    public Juego() {
        miBaraja = new Baraja();
        this.miBaraja = miBaraja;
        Rechazadas = new LinkedList();
        this.Rechazadas = Rechazadas;

    }

    public void run(List<Player> Jugadores) {
        this.Jugadores = Jugadores;
        //    System.out.println(miBaraja.toString());
        Player playerActual;

        reparteCartas();
        Rechazadas.push(miBaraja.dameCarta());

        playerActual = Jugadores.get(turnoPlayer);
        while (jugar) {
            ultCarta = Rechazadas.getFirst();
            muestraUltimacarta();
            if (ultCarta.getTipo() != Carta.Tipo.CAMBIOCOLOR && ultCarta.getTipo() != Carta.Tipo.ROBA4){
                ultColor = ultCarta.getColor();
            }

            selCarta = playerActual.turnoAccion(ultCarta, ultColor);
            if (selCarta == null ) {
                playerActual.cojerCarta(miBaraja.dameCarta());
                // CONTEMPLAR FINAL DE BARAJA ---> METER LAS RECHAZADAS EXCEPTO LA ULTIMA
                turnoPlayer = turnoSiguiente(sentido,turnoPlayer);
                playerActual = Jugadores.get(turnoPlayer);
                //  break;
            } else {
                System.out.println("TIRADO CARTA: " + selCarta.toString());
                if (validarCarta(selCarta, ultCarta, ultColor) == true) {
                    Rechazadas.push(selCarta);  //System.out.println("CARTAS RECHAZADAS " + Rechazadas.toString());
                    playerActual.eliminarCarta(selCarta);

                    if (playerActual.isEmpty()){
                        break;};

                    //******* CAMBIO DIRECCIÓN ***********
                    if (selCarta.getTipo() == Carta.Tipo.CAMBIOSENTIDO) {
                        if (sentido.equals("delante")) {
                            sentido = "atras";
                        } else {
                            sentido = "delante";
                        }
                    }
                    turnoPlayer = turnoSiguiente(sentido,turnoPlayer); //**** AVANZAMOS TURNO

                   //******* SALTA TURNO ****************
                   if (selCarta.getTipo() == Carta.Tipo.SALTATURNO) {
                       turnoPlayer = turnoSiguiente(sentido,turnoPlayer); // ya habiamos pasado 1 + 1 saltamos
                   }
                   //******* ROBA DOS (SIG. JUGADOR) ****
                   if (selCarta.getTipo() == Carta.Tipo.ROBA2) {
                       playerActual = Jugadores.get(turnoPlayer);
                       playerActual.muestraCartas();
                       playerActual.cojerCarta(miBaraja.dameCarta());
                       playerActual.cojerCarta(miBaraja.dameCarta());
                   }
                   //******* CAMBIO DE COLOR ************
                   if (selCarta.getTipo() == Carta.Tipo.CAMBIOCOLOR) {
                        ultColor = playerActual.pedirColor();
                   }
                   //******* ROBA 4 - CAMBIO COLOR ******
                   if (selCarta.getTipo() == Carta.Tipo.ROBA4) {
                       ultColor = playerActual.pedirColor();
                       playerActual = Jugadores.get(turnoPlayer);
                       playerActual.muestraCartas();
                       playerActual.cojerCarta(miBaraja.dameCarta());
                       playerActual.cojerCarta(miBaraja.dameCarta());
                       playerActual.cojerCarta(miBaraja.dameCarta());
                       playerActual.cojerCarta(miBaraja.dameCarta());
                   }
                    playerActual = Jugadores.get(turnoPlayer);

                }
            }
        }
    }

    public void reparteCartas() {
        Player playerActual;
        for (int i = 0; i < Jugadores.size(); i++) {
            playerActual = Jugadores.get(i);
            for (int j = 0; j < 7; j++) {
                playerActual.cojerCarta(miBaraja.dameCarta());
            }
        }
    }

    public int turnoSiguiente(String sentido,int actual){
        if (sentido.equals("delante")){
            actual++;
            if (actual >= Jugadores.size() ) { actual = 0;}
        }
        if (sentido.equals("atras")){
            actual--;
            if (actual < 0 ) { actual = Jugadores.size() - 1;}
        }
        return actual;
    }

    public void muestraUltimacarta() {
        if (ultCarta.getTipo() == Carta.Tipo.CAMBIOCOLOR || ultCarta.getTipo() == Carta.Tipo.ROBA4){
            System.out.println("ULTIMA CARTA: " + ultCarta.toString()+" COLOR: "+ muestraColor());}
         else{
                System.out.println("ULTIMA CARTA: " + ultCarta.toString());
            }
        }

    public Boolean validarCarta(Carta selCarta, Carta ultCarta, Carta.Color ultColor) {
        if (selCarta.getTipo() == Carta.Tipo.ROBA4){
              return true;}
        if (selCarta.getTipo() == Carta.Tipo.CAMBIOCOLOR){
            return true;}
        if (selCarta.getColor() == ultColor) {
            return true;
        } else {
            if (selCarta.getValor() == ultCarta.getValor()) {
                return true;
            } else {
                return false;
            }
        }
    }
    public String muestraColor() {
        String cadena = "";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001b[41;1m";    //"u001B[31m";
        String ANSI_GREEN = "\u001b[42;1m"; //"u001B[32m";
        String ANSI_YELLOW = "\u001b[43;1m";//""\u001B[33m";
        String ANSI_BLUE = "\u001b[44;1m";  //""\u001B[34m";
        String ANSI_BLACK = "\u001B[30m";

        if (ultColor.equals(Carta.Color.BLUE)){ cadena = ANSI_BLUE + ANSI_BLACK + "AZUL" + ANSI_RESET;};
        if (ultColor.equals(Carta.Color.RED)){ cadena = ANSI_RED + ANSI_BLACK + "ROJO" + ANSI_RESET;};
        if (ultColor.equals(Carta.Color.GREEN)){ cadena = ANSI_GREEN + ANSI_BLACK + "VERDE" + ANSI_RESET;};
        if (ultColor.equals(Carta.Color.YELLOW)){ cadena = ANSI_YELLOW + ANSI_BLACK + "AMARILLO" + ANSI_RESET;};
        return cadena;

        }


}
