package uno;

import java.util.Objects;

public class Carta {
    public enum Color {BLUE, RED, YELLOW, GREEN}

    public enum Tipo {NORMAL, ROBA2, CAMBIOSENTIDO, SALTATURNO, ROBA4, CAMBIOCOLOR}

    private Integer valor;
    private Color color;
    private Tipo tipo;

    public Carta(Integer valor, Color color, Tipo tipo) {
        this.valor = valor;
        this.color = color;
        this.tipo = tipo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        // de 0 a 9 y null
        this.valor = valor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Objects.equals(valor, carta.valor) &&
                color == carta.color &&
                tipo == carta.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, color, tipo);
    }

    @Override
    public String toString() {
        String cadena = "";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001b[41;1m";    //"u001B[31m";
        String ANSI_GREEN = "\u001b[42;1m"; //"u001B[32m";
        String ANSI_YELLOW = "\u001b[43;1m";//""\u001B[33m";
        String ANSI_BLUE = "\u001b[44;1m";  //""\u001B[34m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_WHITE = "\u001B[37m";


        if (color != null) {
            switch (color) {
                case RED:
                    cadena = ANSI_RED;
                    break;
                case BLUE:
                    cadena = ANSI_BLUE;
                    break;
                case YELLOW:
                    cadena = ANSI_YELLOW;
                    break;
                case GREEN:
                    cadena = ANSI_GREEN;
                    break;
                default:
                    cadena = ANSI_RESET;
            }
        }
        switch (tipo) {
            case NORMAL:
                cadena = cadena + ANSI_BLACK + "  " + valor+"  " + ANSI_RESET;
                break;
            case ROBA2:
                cadena = cadena + ANSI_BLACK + "  +2 " + ANSI_RESET;
                break;
            case CAMBIOSENTIDO:
                cadena = cadena + ANSI_BLACK + " <-> " + ANSI_RESET;
                break;
            case SALTATURNO:
                cadena = cadena + ANSI_BLACK + "  X  " + ANSI_RESET;
                break;
            case ROBA4:
                cadena = cadena + ANSI_BLUE + " " +
                        ANSI_GREEN + "+" +
                        ANSI_RED + " " + ANSI_BLACK + "4" +
                        ANSI_YELLOW + " " +
                        ANSI_RESET;
               break;
            case CAMBIOCOLOR:
                cadena = cadena + ANSI_BLUE + " " +
                                  ANSI_GREEN + " " +
                                  ANSI_RED + " " +
                                  ANSI_YELLOW + " " +
                                  ANSI_RESET+" ";
                break;
        }

        return cadena;

    }

}