package arbolb;

public class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;
    int nivel;

    public Nodo() {
    }

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.nivel = 0;
    }

    public Nodo(char valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}
