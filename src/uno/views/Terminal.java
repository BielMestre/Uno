package uno.views;

import uno.Carta;

import java.util.ArrayList;
import java.util.Scanner;

public class Terminal implements Visor {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_GREEN =  "\u001B[32m";

    String ANSI_BRED = "\u001b[41;1m";    //"u001B[31m";
    String ANSI_BGREEN = "\u001b[42;1m"; //"u001B[32m";
    String ANSI_BYELLOW = "\u001b[43;1m";//""\u001B[33m";
    String ANSI_BBLUE = "\u001b[44;1m";  //""\u001B[34m";
    String ANSI_BLACK = "\u001B[30m";

    @Override
    public void presentacion() {

        limpiarPantalla();
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                                                          █");
        System.out.println("█     "+ ANSI_RED+"█  █  █   █  █▀▀█"+ANSI_RESET+"               I N S E R T          █");
        System.out.println("█     "+ ANSI_RED+"█  █  ██  █  █  █"+ANSI_RESET+"                                    █");
        System.out.println("█     "+ ANSI_RED+"█  █  █ █ █  █  █"+ANSI_RESET+"                 C O I N            █");
        System.out.println("█     "+ ANSI_RED+"█▄▄█  █  ██  █▄▄█"+ANSI_RESET+"                                    █");
        System.out.println("█                                     "+ANSI_BLUE+"Biel Mestre"+ANSI_RESET+"          █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println(" ");
    }

    @Override
    public String pideNombreJugador(int numPlayer) {
        Scanner dc = new Scanner(System.in);
        System.out.println("Nombre del jugador "+ numPlayer+" (Intro Finalizar): ");
        String nombre = dc.nextLine();
        return nombre;
    }

    @Override
    public void gameOver() {
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                                                          █");
        System.out.println("█                    G A M E   O V E R                     █");
        System.out.println("█                                                          █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
    }

    @Override
    public void ganador(String nombre) {
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                                                          █");
        System.out.println("█           "+ ANSI_BLUE + nombre + ANSI_RESET +"               █");
        System.out.println("█                                                          █");
        System.out.println("█                      " + ANSI_RED +"Y O U      W I N" + ANSI_RESET + "                    █");
        System.out.println("█                                                          █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");

    }

    @Override
    public void limpiarPantalla() {
        try{
            new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
        } catch (Exception e){

        }
    }

    @Override
    public void muestraUltimaCarta(Carta ultCarta, Carta.Color micolor) {
        limpiarPantalla();
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                                                                      █");
        if (ultCarta.getTipo() == Carta.Tipo.CAMBIOCOLOR || ultCarta.getTipo() == Carta.Tipo.ROBA4){
            System.out.println("█           ÚLTIMA CARTA: " + ultCarta.toString()+" COLOR: "+ muestraColor(micolor)+"       █");}
        else{
            System.out.println("█                           ÚLTIMA CARTA: " + rellenaStr(ultCarta.toString()," ",45)+"█");
        }
        System.out.println("█                                                                      █");

    }
    public String muestraColor(Carta.Color micolor) {
        String cadena = "";

        if (micolor.equals(Carta.Color.BLUE)){ cadena = ANSI_BBLUE + ANSI_BLACK +     "    AZUL    " + ANSI_RESET;};
        if (micolor.equals(Carta.Color.RED)){ cadena = ANSI_BRED + ANSI_BLACK +       "    ROJO    " + ANSI_RESET;};
        if (micolor.equals(Carta.Color.GREEN)){ cadena = ANSI_BGREEN + ANSI_BLACK +   "    VERDE   " + ANSI_RESET;};
        if (micolor.equals(Carta.Color.YELLOW)){ cadena = ANSI_BYELLOW + ANSI_BLACK + "  AMARILLO  " + ANSI_RESET;};
        return cadena;
    }

    @Override
    public void muestraNombrePlayer(String nomPlayer) {
        System.out.println("█                         JUGADOR : "+ANSI_BLUE +rellenaStr(nomPlayer," ",35)+ANSI_RESET+"█");
        System.out.println("█■■■■■■■■■■■■■■■■■■■■■■■■■■■■  Sus cartas són ■■■■■■■■■■■■■■■■■■■■■■■■■█");
        System.out.println("█"+rellenaStr(" "," ",70)+"█");
    }

    @Override
    public void muestraPanelSuperior(String nomPlayer, Carta ultCarta, Carta.Color micolor, int cartasBaraja, int numPlayers) {
        limpiarPantalla();
        System.out.println();
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                               █     ÚLTIMA    █                      █");
        System.out.println("█  "+ ANSI_RED+"█ █ █ █ █▀▀█"+ANSI_RESET+"  "+ANSI_YELLOW+"███"+ANSI_GREEN +"███"+ANSI_BLUE+"███"+ANSI_RED+ "███"+ANSI_RESET+"   █  CARTA/COLOR  █       JUGADOR        █");
        System.out.println("█  "+ ANSI_RED+"█ █ ███ █  █"+ANSI_RESET+"  "+ANSI_YELLOW+"███"+ANSI_GREEN +"███"+ANSI_BLUE+"███"+ANSI_RED +"███"+ANSI_RESET+"   █               █                      █");
        System.out.println("█  "+ ANSI_RED+"█▄█ █ █ █▄▄█"+ANSI_RESET+"  "+ANSI_YELLOW+"███"+ANSI_GREEN +"███"+ANSI_BLUE+"███"+ANSI_RED +"███"+ANSI_RESET+"   █     " +ultCarta.toString()+"     █  "+ANSI_BLUE +rellenaStr(nomPlayer," ",20)+ANSI_RESET+"█");
          System.out.print("█                               █  ");
        if (ultCarta.getTipo() == Carta.Tipo.CAMBIOCOLOR || ultCarta.getTipo() == Carta.Tipo.ROBA4){
            System.out.println( muestraColor(micolor)+" █                      █");}
        else{
            System.out.println("             █                      █");}

        System.out.println("█        ® Biel Mestre          █               █ Players "+rellenaStr(String.valueOf(numPlayers)," ",2)+" Cartas "+rellenaStr(String.valueOf(cartasBaraja)," ",2)+" █");
        System.out.println("█■■■■■■■■■■■■■■■■■■■■■■■■■■  Sus cartas són ■■■■■■■■■■■■■■■■■■■■■■■■■■■█");
        System.out.println("█"+rellenaStr(" "," ",70)+"█");

    }

    @Override
    public void muestraCartasPlayer(ArrayList<Carta> playerCartas) {
        String texto = "";
        texto = playerCartas.toString();
        System.out.println("█  "+ rellenaStr(texto," ",150)+" █");
        texto = "█     ";
        for (int i = 0; i < playerCartas.size(); i++) {
           // System.out.print("  " + i + "  ");
            texto = texto + rellenaStr(String.valueOf(i)," ",5)+"  "; //"  " + i + "  ";
        }

        System.out.println(rellenaStr(texto," ",71)+"█");

    }
    public String rellenaStr(String palabra, String letra, int numLet){
        for (int i = palabra.length(); i < numLet; i++) {
            palabra = palabra + letra;
        }
     return palabra;
    }

    @Override
    public void escojeCartaTirar() {
        System.out.println("█  Selecciona la carta indicando su posición o Pulsa R para robar una  █");
        System.out.println("█                                                                      █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");

    }

    @Override
    public Carta.Color pideColor(String nomPlayer) {
        int numcol;
        Carta.Color micolor = null;
        Scanner dc = new Scanner(System.in);
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                                                                      █");
        System.out.println("█ "+ANSI_BYELLOW+ANSI_BLACK+"  0  "+ANSI_RESET+"  "+
                           ANSI_BGREEN +ANSI_BLACK+"  1  "+ANSI_RESET+"  "+
                           ANSI_BRED   +ANSI_BLACK+"  2  "+ANSI_RESET+"  "+
                           ANSI_BBLUE  +ANSI_BLACK+"  3  "+ANSI_RESET+ "  █");
        while (true) {
            System.out.println( "  Escoje color (0-3):  ");
            numcol = dc.nextInt();
            if (numcol >= 0 || numcol <= 3) {
                break;
            }
        }
        switch (numcol) {
            case 0:
                micolor = Carta.Color.YELLOW;
                break;
            case 1:
                micolor = Carta.Color.GREEN;
                break;
            case 2:
                micolor = Carta.Color.RED;
                break;
            case 3:
                micolor = Carta.Color.BLUE;
                break;
        }
        return micolor;
    }
}
