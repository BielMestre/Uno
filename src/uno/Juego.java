package uno;

import uno.views.Visor;

import java.util.LinkedList;
import java.util.List;

public class Juego {
    private Carta ultCarta;
    private Carta cartaTirada;
    private Carta.Color ultColor;
    private List<Player> Jugadores;
    private Baraja miBaraja;
    private LinkedList<Carta> Rechazadas;
    int turnoPlayer = 0;
    String sentido = "delante";
    public boolean jugar = true;
    private Visor miVisor;

    // *************** contructor de la clase juego ****************************
    public Juego() {
        miBaraja = new Baraja();
        this.miBaraja = miBaraja;
        Rechazadas = new LinkedList();
        this.Rechazadas = Rechazadas;
}

  // *********************** MÉTODO PRINCIPAL JUEGO ****************************
    public void run(List<Player> Jugadores, Visor miVisor) {
        this.Jugadores = Jugadores;
        this.miVisor = miVisor;
        Player playerActual;

        reparteCartas();
        while (true) {
            Rechazadas.push(miBaraja.dameCarta());
            ultCarta = Rechazadas.getFirst();
            if (ultCarta.getTipo() != Carta.Tipo.CAMBIOCOLOR && ultCarta.getTipo() != Carta.Tipo.ROBA4 && ultCarta.getTipo() != Carta.Tipo.ROBA2) {
                break;
            }
        }
        // validar que no sea una carta especial
        playerActual = Jugadores.get(turnoPlayer);

        while (jugar) {
            ultCarta = Rechazadas.getFirst();

            if (ultCarta.getTipo() != Carta.Tipo.CAMBIOCOLOR && ultCarta.getTipo() != Carta.Tipo.ROBA4){
                ultColor = ultCarta.getColor();
                miVisor.muestraPanelSuperior(playerActual.dameNombre(),ultCarta, ultColor,miBaraja.numeroCartas(),Jugadores.size());}
            else{
                // si es inicio del juego  y primera carta es cambio color ultcolor = null
                miVisor.muestraPanelSuperior(playerActual.dameNombre(),ultCarta, ultColor,miBaraja.numeroCartas(),Jugadores.size());
            }

            cartaTirada = playerActual.tiraCarta(ultCarta, ultColor, miVisor);
            if (cartaTirada == null ) {
                if (miBaraja.numeroCartas() == 1){
                   miBaraja.recargaBaraja(Rechazadas);
                }
                playerActual.cojerCarta(miBaraja.dameCarta());
                turnoPlayer = turnoSiguiente(sentido,turnoPlayer);
                playerActual = Jugadores.get(turnoPlayer);
            } else {
                if (validarCarta(cartaTirada, ultCarta, ultColor) == true) {
                    Rechazadas.push(cartaTirada);  //System.out.println("CARTAS RECHAZADAS " + Rechazadas.toString());
                    playerActual.eliminarCarta(cartaTirada);

                    //****** SIN CARTAS JUGADOR HA GANADO **
                    if (playerActual.sinCartas()){
                        miVisor.ganador(playerActual.dameNombre());
                        break;};

                    //******* CAMBIO DIRECCIÓN ***********
                    if (cartaTirada.getTipo() == Carta.Tipo.CAMBIOSENTIDO) {
                        if (sentido.equals("delante")) {
                            sentido = "atras";
                        } else {
                            sentido = "delante";
                        }
                    }
                    turnoPlayer = turnoSiguiente(sentido,turnoPlayer); //**** AVANZAMOS TURNO

                   //******* SALTA TURNO ****************
                   if (cartaTirada.getTipo() == Carta.Tipo.SALTATURNO) {
                       turnoPlayer = turnoSiguiente(sentido,turnoPlayer); // ya habiamos pasado 1 + 1 saltamos
                   }
                   //******* ROBA DOS (SIG. JUGADOR) ****
                   if (cartaTirada.getTipo() == Carta.Tipo.ROBA2) {
                       playerActual = Jugadores.get(turnoPlayer);
                       playerActual.muestraCartas(miVisor);
                       playerActual.cojerCarta(miBaraja.dameCarta());
                       playerActual.cojerCarta(miBaraja.dameCarta());
                   }
                   //******* CAMBIO DE COLOR ************
                   if (cartaTirada.getTipo() == Carta.Tipo.CAMBIOCOLOR) {
                        ultColor = playerActual.pedirColor(miVisor);
                   }
                   //******* ROBA 4 - CAMBIO COLOR ******
                   if (cartaTirada.getTipo() == Carta.Tipo.ROBA4) {
                       ultColor = playerActual.pedirColor(miVisor);
                       playerActual = Jugadores.get(turnoPlayer);
                       playerActual.muestraCartas(miVisor);
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

// ****************** MÉTODOS AUXILIARES DE JUEGO *************************************
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
        miVisor.muestraUltimaCarta(ultCarta, ultColor);
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

}
