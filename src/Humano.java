
import java.util.ArrayList;
import java.util.Scanner;

public class Humano implements Player {

    // crear lista de cartas del jugador
    private ArrayList<Carta> playerCartas ;
    private String nombre;

    public Humano(String nombre){
    this.playerCartas = new ArrayList();
    this.nombre = nombre;
    }


    public boolean isEmpty() {
        return playerCartas.size() == 0;
    }

    @Override
    public Carta turnoAccion(Carta ultCarta, Carta.Color ultColor) {
        Scanner dc = new Scanner(System.in);
//        System.out.println("********** Jugador : "+this.nombre+" ***************");
        muestraCartas();

        //    System.out.println("Color en Juego : ");        // Falta mostrar color activo
        //    System.out.println("Carta en juego : ");        // Falta mostrar carta activo
        // Muestra cartas pero falta posicion dentro de arraylist
        while (true) {

            System.out.println("Selecciona la carta indicando su posición o Pulsa R para robar una: ");
            String posCarta = dc.nextLine();
            if (posCarta.equals("r")  || posCarta.equals("R")  || posCarta.equals("")) {
                return null;
            } else {
                // contemplar exception si convierto texto a integer
                int iPoscarta = Integer.parseInt(posCarta);
                if (iPoscarta <= this.playerCartas.size()) {
                    return this.playerCartas.get(iPoscarta);
                }
            }
        }
    }

    @Override
    public Carta.Color pedirColor() {
        int numcol;
        Carta.Color micolor = null;
        Scanner dc = new Scanner(System.in);
        System.out.println("0 = Amarillo, 1 = Verde, 2 = Rojo, 3 = Azul");
        while (true) {
            System.out.println("Jugador : " + this.nombre + " escoje color (0-3): ");
            numcol = dc.nextInt();
            if (numcol >= 0 || numcol <= 3){
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
                micolor =  Carta.Color.BLUE;
                break;
        }
        return micolor;
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
    public void muestraCartas() {
        System.out.println("********* Jugador : "+this.nombre+" ***********");
        System.out.println("Sus cartas son : ");
        System.out.println(this.playerCartas.toString());
        for (int i = 0; i < this.playerCartas.size() ; i++) {
            System.out.print("  " + i + "  " );
        }
        System.out.println("  ");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
