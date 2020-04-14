package uno;

import uno.views.Visor;

import java.util.ArrayList;
import java.util.Scanner;

public class Humano implements Player {

    // crear lista de cartas del jugador
    private ArrayList<Carta> playerCartas;
    private String nombre;

    public Humano(String nombre) {
        this.playerCartas = new ArrayList();
        this.nombre = nombre;
    }


    public boolean sinCartas() {
        return playerCartas.size() == 0;
    }

    @Override
    public Carta tiraCarta(Carta ultCarta, Carta.Color ultColor, Visor miVisor) {
        Scanner dc = new Scanner(System.in);
        //muestraCartas(miVisor);
        while (true) {
            muestraCartas(miVisor);
            miVisor.escojeCartaTirar();
            String posCarta = dc.nextLine();
            if (posCarta.equals("r") || posCarta.equals("R") || posCarta.equals("")) {
                return null;
            } else {
                try{
                    int iPoscarta = Integer.parseInt(posCarta);
                    if (iPoscarta <= this.playerCartas.size()) {
                        return this.playerCartas.get(iPoscarta);
                   } }
                    catch (Exception e){
                 // no hago nada repetirá blucle
                }
                }
            }
        }


    @Override
    public Carta.Color pedirColor(Visor miVisor) {
       return miVisor.pideColor(this.nombre);
    }

    @Override
    public boolean eliminarCarta(Carta carta) {
        return playerCartas.remove(carta);
    }

    @Override
    public void cojerCarta(Carta carta) {

        this.playerCartas.add(carta);

    }

    @Override
    public void muestraCartas(Visor miVisor) {
   //     miVisor.muestraNombrePlayer(this.nombre);
        miVisor.muestraCartasPlayer(this.playerCartas);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String dameNombre() {
        return nombre;
    }
}
