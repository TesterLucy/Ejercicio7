package arbolb;

import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
    ArbolBinario arbol = null;
    Arbolito arbolito = new Arbolito(arbol);
    JFrame frame = new JFrame("Árbol Binario");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(arbolito);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}
}
