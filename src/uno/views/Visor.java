package uno.views;

import uno.Carta;

import java.util.ArrayList;

public interface Visor {
    void presentacion();
    String pideNombreJugador(int numPlayer);
    void gameOver();
    void ganador(String nomPLayer);
    void limpiarPantalla();
    // dos métodos siguientes se pueden eliminar
    void muestraUltimaCarta(Carta ultimaCarta, Carta.Color micolor);
    void muestraNombrePlayer(String nomPlayer);
    // fin funciones inútiles
    void muestraCartasPlayer(ArrayList<Carta> playerCartas);
    void escojeCartaTirar();
    void muestraPanelSuperior(String nomPlayer, Carta ultimaCarta, Carta.Color micolor, int cartasBaraja, int numPlayers);
    Carta.Color pideColor(String nomPlayer);

}
