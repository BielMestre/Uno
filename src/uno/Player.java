package uno;

import uno.views.Visor;

public interface Player {

    boolean sinCartas(); // jugador sin cartas
    Carta tiraCarta(Carta ultCarta, Carta.Color ultColor, Visor miVisor);
    boolean eliminarCarta(Carta carta);
    void cojerCarta(Carta carta);
    Carta.Color pedirColor(Visor miVisor);
    void muestraCartas(Visor miVisor);
    String dameNombre();
}
