package uno.views;

import uno.Baraja;
import uno.Carta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI extends JComponent implements Visor {
    private Panel panelNorth;
    private Panel panelCenter;
    private Panel panelSouth;


    // *************** contructor de la clase GUI ****************************
    public  GUI() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setTitle("UNO V 1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanelSuperior component = new MyPanelSuperior();
        frame.add(component);

        frame.setVisible(true);
      //  panelNorth = new Panel();
      //  this.panelNorth = panelNorth;
      //  panelCenter = new Panel();
      //  this.panelCenter = panelCenter;
      //  panelSouth = new Panel();   // GridLayout panelCartas new GridLayaout(2,0); setLayaout(panelCartas); add(new Button("carta"));
      //  this.panelSouth = panelSouth;

    }

    public class MyPanelSuperior extends JComponent{
        protected Font font = new java.awt.Font("Sans-Serif", Font.BOLD, 42);
        public void paintComponent(Graphics g){
           Graphics2D g2 = (Graphics2D) g;
           g2.setColor(Color.red);
           g2.setFont(font);
           g2.drawString("UNO", 5,50);

           g2.setColor(Color.red);
           Rectangle c1 = new Rectangle(25,70,25,25);
           g2.fill(c1);
           g2.setColor(Color.GREEN);
           Rectangle c2 = new Rectangle(50,70,25,25);
           g2.fill(c2);
           g2.setColor(Color.BLUE);
           Rectangle c3 = new Rectangle(25,95,25,25);
            g2.fill(c3);
            g2.setColor(Color.YELLOW);
            Rectangle c4 = new Rectangle(50, 95, 25,25);
            g2.fill(c4);

        }
    }

   // ****************** MÉTODOS  DE GUI  *************************************
    public void  poneNombre(String nombrePlayer){

    }

    @Override
    public void presentacion() {
        // North Panel
        //  panelNorth.add(new TextField(nombre));
        // Center Panel
      //  this.add(Label new)
  //      Label l1 = new Label("UNO");
      //  panelNorth.add(l1);
      //  panelCenter.setLayout(new GridLayout(4, 1));
    //    panelCenter.add(new Button("uno.Carta 1"));
    //    panelCenter.add(new Button("uno.Carta 2"));


      //  this.add(panelNorth, BorderLayout.NORTH);
      //  this.add(panelCenter, BorderLayout.CENTER);
      //  this.add(panelSouth, BorderLayout.SOUTH);
      //  this.setSize(800, 600);
       // this.setVisible(true);

    }

    @Override
    public String pideNombreJugador(int numPlayer) {
        String nombre;
        JPanel panelNombres = new JPanel();
        panelNombres.add(new JLabel("Nombre del jugador "+ numPlayer+" (Intro Finalizar): "));
        TextField tf = new TextField();
        panelNombres.add(tf);

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

