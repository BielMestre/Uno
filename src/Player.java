public interface Player {

    boolean isEmpty(); // jugador sin cartas
    Carta turnoAccion(Carta ultCarta, Carta.Color ultColor);
    boolean eliminarCarta(Carta carta);
    void cojerCarta(Carta carta);
    Carta.Color pedirColor();
    void muestraCartas();
    // faltan metodos ???
}
