import java.util.ArrayList;

public class Baraja {
    private ArrayList<Carta> barajaList;

    public Baraja() {

        this.barajaList = new ArrayList<>();
        rellenaBaraja();

    }

    public Carta dameCarta(){
        int max = barajaList.size() - 1;
        int min = 0;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        return barajaList.remove(rand);
    }

    private void rellenaBaraja(){
        Carta.Color miscolores[] = Carta.Color.values();
        Integer mvalor = null;
        Carta.Color mcolor = null;
        Carta.Tipo mtipo = null;

        //************  CARTAS NUMERICAS ***************
        for (int i = 0; i < miscolores.length ; i++) {
            Carta nuevacarta;
            for (int j = 0; j <= 9; j++) {
                // solo crear una vez la carta 0
                nuevacarta = new Carta(mvalor, mcolor, mtipo);
                nuevacarta.setValor(j);
                nuevacarta.setTipo(Carta.Tipo.NORMAL);
                nuevacarta.setColor(miscolores[i]);
                if (j == 0) {
                    barajaList.add(nuevacarta);
                } else {
                    barajaList.add(nuevacarta);
                    barajaList.add(nuevacarta);
                }
            }
            // **** ROBA 2
            nuevacarta = new Carta(null, miscolores[i], Carta.Tipo.ROBA2);
            barajaList.add(nuevacarta);
            barajaList.add(nuevacarta);

            // **** CAMBIO SENTIDO
            nuevacarta = new Carta(null, miscolores[i], Carta.Tipo.CAMBIOSENTIDO);
            barajaList.add(nuevacarta);
            barajaList.add(nuevacarta);
            // **** SALTA TURNO
            nuevacarta = new Carta(null, miscolores[i], Carta.Tipo.SALTATURNO);
            barajaList.add(nuevacarta);
            barajaList.add(nuevacarta);
        }
        Carta nuevacarta;
        // **** ROBA 4
        nuevacarta = new Carta(null, null, Carta.Tipo.ROBA4);
        barajaList.add(nuevacarta);
        barajaList.add(nuevacarta);
        barajaList.add(nuevacarta);
        barajaList.add(nuevacarta);
        // **** CAMBIO DE COLOR
        nuevacarta = new Carta(null, null, Carta.Tipo.CAMBIOCOLOR);
        barajaList.add(nuevacarta);
        barajaList.add(nuevacarta);
        barajaList.add(nuevacarta);
        barajaList.add(nuevacarta);
    }

    @Override
    public String toString() {
        if (barajaList.isEmpty()) {
            return "Baraja vacia";
        } else {
            return "Baraja Completa \n" +
                      barajaList.toString() ;
        }
    }
}
