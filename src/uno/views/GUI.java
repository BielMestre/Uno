package uno.views;

import uno.Carta;

import java.awt.*;
import java.util.ArrayList;

public class GUI extends Frame implements Visor {
    public static void main(String[] args) {
    //    public String nombre;


        GUI miv = new GUI();
        Panel panelNorth = new Panel();
        Panel panelCenter = new Panel();
        Panel panelSouth = new Panel();
        // North Panel
      //  panelNorth.add(new TextField(nombre));
        // Center Panel
        panelCenter.setLayout(new GridLayout(4, 1));
        panelCenter.add(new Button("uno.Carta 1"));
        panelCenter.add(new Button("uno.Carta 2"));

        miv.add(panelNorth, BorderLayout.NORTH);
        miv.add(panelCenter, BorderLayout.CENTER);
        miv.add(panelSouth, BorderLayout.SOUTH);
        miv.setSize(400, 400);
        miv.setVisible(true);
    }
    public void  poneNombre(String nombrePlayer){

    }


    @Override
    public void presentacion() {

    }

    @Override
    public String pideNombreJugador(int numPlayer) {
        return null;
    }

    @Override
    public void gameOver() {

    }

    @Override
    public void ganador(String nomPLayer) {

    }

    @Override
    public void limpiarPantalla() {

    }

    @Override
    public void muestraUltimaCarta(Carta ultimaCarta, Carta.Color micolor) {

    }

    @Override
    public void muestraNombrePlayer(String nomPlayer) {

    }

    @Override
    public void muestraCartasPlayer(ArrayList<Carta> playerCartas) {

    }

    @Override
    public void escojeCartaTirar() {

    }

    @Override
    public void muestraPanelSuperior(String nomPlayer, Carta ultimaCarta, Carta.Color micolor, int cartasBaraja, int numPlayers) {

    }

    @Override
    public Carta.Color pideColor(String nomPlayer) {
        return null;
    }
}

