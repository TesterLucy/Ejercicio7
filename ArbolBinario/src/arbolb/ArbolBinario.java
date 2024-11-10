package arbolb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }
    
    // M�todos de manipulaci�n del �rbol
    
    public static ArbolBinario crearNuevoArbol() {
        String mensaje = JOptionPane.showInputDialog(null,"�Qu� tipo de datos desea almacenar en el �rbol?\n1.N�meros\n2.Letras\nSeleccione una opci�n");
        int opcion = Integer.parseInt(mensaje);
        ArbolBinario arbol;
        if (opcion == 1) {
            String valor1 = JOptionPane.showInputDialog(null,"Ingrese el valor para el nodo ra�z: ");
            int valorRaiz = Integer.parseInt(valor1);
            String valor2 = JOptionPane.showInputDialog(null,"Ingrese el valor para el nodo izquierdo: ");
            int valorIzquierdo = Integer.parseInt(valor2);
            String valor3 = JOptionPane.showInputDialog(null,"Ingrese el valor para el nodo derecho: ");
            int valorDerecho = Integer.parseInt(valor3);
            Nodo raiz = new Nodo(valorRaiz);
            raiz.izquierdo = new Nodo(valorIzquierdo);
            raiz.derecho = new Nodo(valorDerecho);
            arbol = new ArbolBinario(raiz);
        } else if (opcion == 2) {
            String valor4 = JOptionPane.showInputDialog(null,"Ingrese el valor para el nodo ra�z: ");
            char valorRaiz = valor4.charAt(0);
            String valor5 = JOptionPane.showInputDialog(null,"Ingrese el valor para el nodo izquierdo: ");
            char valorIzquierdo = valor5.charAt(0);
            String valor6 = JOptionPane.showInputDialog(null,"Ingrese el valor para el nodo derecho: ");
            char valorDerecho = valor6.charAt(0);
            Nodo raiz = new Nodo(valorRaiz);
            raiz.izquierdo = new Nodo(valorIzquierdo);
            raiz.derecho = new Nodo(valorDerecho);
            arbol = new ArbolBinario(raiz);
        } else {
            JOptionPane.showMessageDialog(null,"Opci�n no v�lida.");
            return null;
        }
        
        JOptionPane.showMessageDialog(null,"�rbol creado con �xito.");
        return arbol;
    }
    
    public void anadirNodo() {
    if (raiz == null) {
        JOptionPane.showMessageDialog(null,"A�n no se ha creado ning�n �rbol.");
        return;
    }

    int valor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor del nodo al que desea agregar un nuevo nodo: "));
    List<Nodo> nodosCoincidentes = new ArrayList<>();
    buscarNodo(raiz, valor, nodosCoincidentes, 1); // Buscar nodos coincidentes

    if (nodosCoincidentes.isEmpty()) {
        JOptionPane.showMessageDialog(null,"No se encontr� ning�n nodo con el valor especificado en el �rbol.");
        return;
    }

    // Si hay nodos coincidentes, preguntar al usuario en qu� nivel desea trabajar
    if (nodosCoincidentes.size() > 1) {
        StringBuilder mensaje = new StringBuilder("Se encontraron nodos con el valor especificado en los siguientes niveles:\n");
        for (int i = 0; i < nodosCoincidentes.size(); i++) {
            mensaje.append("Nivel ").append(nodosCoincidentes.get(i).nivel).append("\n");
        }
        mensaje.append("En qu� nivel desea trabajar? Ingrese el n�mero correspondiente:");

        int nivelSeleccionado = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje.toString()));
        Nodo nodo = null;
        for (Nodo n : nodosCoincidentes) {
            if (n.nivel == nivelSeleccionado) {
                nodo = n;
                break;
            }
        }
        if (nodo == null) {
            JOptionPane.showMessageDialog(null,"Nivel no v�lido.");
            return;
        }
    }

    // Preguntar al usuario en qu� direcci�n desea agregar el nuevo nodo
    int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione la direcci�n para agregar el nuevo nodo:\n1. Izquierda\n2. Derecha"));
    if (opcion != 1 && opcion != 2) {
        JOptionPane.showMessageDialog(null,"Opci�n no v�lida.");
        return;
    }

    // Obtener el nodo seleccionado para agregar el nuevo nodo
    Nodo nodo = nodosCoincidentes.get(0);

    // Verificar si el nodo seleccionado ya tiene datos
    if (nodo.izquierdo != null || nodo.derecho != null) {
        int respuesta = JOptionPane.showConfirmDialog(null,"El nodo que ingresaste tiene como dato " + nodo.valor + ". Deseas modificarlo?", "Confirmaci�n", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            int nuevoValor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el nuevo valor para el nodo: "));
            nodo.valor = nuevoValor;
            JOptionPane.showMessageDialog(null,"Valor del nodo modificado con �xito.");
            return;
        }
    }

    // A�adir el nuevo nodo seg�n la direcci�n seleccionada por el usuario
    if (opcion == 1) {
        int nuevoValor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor para el nuevo nodo izquierdo: "));
        nodo.izquierdo = new Nodo(nuevoValor);
        JOptionPane.showMessageDialog(null,"Nodo izquierdo a�adido con �xito.");
    } else {
        int nuevoValor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor para el nuevo nodo derecho: "));
        nodo.derecho = new Nodo(nuevoValor);
        JOptionPane.showMessageDialog(null,"Nodo derecho a�adido con �xito.");
    }
}

    private void buscarNodo(Nodo nodo, int valor, List<Nodo> nodosCoincidentes, int nivel) {
    if (nodo == null) return;
    if (nodo.valor == valor) {
        nodo.nivel = nivel;
        nodosCoincidentes.add(nodo);
    }
    buscarNodo(nodo.izquierdo, valor, nodosCoincidentes, nivel + 1);
    buscarNodo(nodo.derecho, valor, nodosCoincidentes, nivel + 1);
}

    
    private Nodo buscarNodo(Nodo nodo, int valor) {
        if (nodo == null) return null;
        if (nodo.valor == valor) return nodo;
        
        Nodo nodoEncontrado = buscarNodo(nodo.izquierdo, valor);
        if (nodoEncontrado != null) return nodoEncontrado;
        
        return buscarNodo(nodo.derecho, valor);
    }
    
    // M�todos de recorrido del �rbol
    
    public void mostrarRecorridos() {
        StringBuilder mensaje = new StringBuilder();

        mensaje.append("Recorrido In Orden: ");
        mensaje.append(obtenerRecorridoInOrden(raiz));
        mensaje.append("\n");

        mensaje.append("Recorrido Pre Orden: ");
        mensaje.append(obtenerRecorridoPreOrden(raiz));
        mensaje.append("\n");

        mensaje.append("Recorrido Post Orden: ");
        mensaje.append(obtenerRecorridoPostOrden(raiz));

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private String obtenerRecorridoInOrden(Nodo nodo) {
        StringBuilder recorrido = new StringBuilder();
        recorridoInOrden(nodo, recorrido);
        return recorrido.toString();
    }

    private void recorridoInOrden(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            recorridoInOrden(nodo.izquierdo, recorrido);
            recorrido.append(nodo.valor).append(" ");
            recorridoInOrden(nodo.derecho, recorrido);
        }
    }

    private String obtenerRecorridoPreOrden(Nodo nodo) {
        StringBuilder recorrido = new StringBuilder();
        recorridoPreOrden(nodo, recorrido);
        return recorrido.toString();
    }

    private void recorridoPreOrden(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            recorrido.append(nodo.valor).append(" ");
            recorridoPreOrden(nodo.izquierdo, recorrido);
            recorridoPreOrden(nodo.derecho, recorrido);
        }
    }

    private String obtenerRecorridoPostOrden(Nodo nodo) {
        StringBuilder recorrido = new StringBuilder();
        recorridoPostOrden(nodo, recorrido);
        return recorrido.toString();
    }

    private void recorridoPostOrden(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            recorridoPostOrden(nodo.izquierdo, recorrido);
            recorridoPostOrden(nodo.derecho, recorrido);
            recorrido.append(nodo.valor).append(" ");
        }
    }
    
    // M�todos para calcular propiedades del �rbol
    
    public int calcularGrado() {
        return calcularGrado(raiz);
    }
    
    private int calcularGrado(Nodo nodo) {
        if (nodo == null) return 0;
        int grado = 0;
        if (nodo.izquierdo != null) grado++;
        if (nodo.derecho != null) grado++;
        return Math.max(grado, Math.max(calcularGrado(nodo.izquierdo), calcularGrado(nodo.derecho)));
    }
    
    public int calcularNivel(int valor) {
        return calcularNivel(raiz, valor, 1);
    }
    
    private int calcularNivel(Nodo nodo, int valor, int nivel) {
        if (nodo == null) return 0;
        if (nodo.valor == valor) return nivel;
        int nivelIzquierdo = calcularNivel(nodo.izquierdo, valor, nivel + 1);
        if (nivelIzquierdo != 0) return nivelIzquierdo;
        return calcularNivel(nodo.derecho, valor, nivel + 1);
    }
    
    public int calcularAltura(Nodo nodo) {
        if (nodo == null) return 0;
        int alturaIzquierdo = calcularAltura(nodo.izquierdo);
        int alturaDerecho = calcularAltura(nodo.derecho);
        return Math.max(alturaIzquierdo, alturaDerecho) + 1;
    }
    
    public void imprimirArbol() {
    if (raiz == null) return;

    Queue<Nodo> queue = new LinkedList<>();
    List<String> valores = new ArrayList<>();

    queue.add(raiz);

    // Realizar un recorrido en amplitud
    while (!queue.isEmpty()) {
        Nodo nodo = queue.poll();
        valores.add(String.valueOf(nodo.valor)); // Agregar el valor del nodo a la lista

        if (nodo.izquierdo != null) queue.add(nodo.izquierdo);
        if (nodo.derecho != null) queue.add(nodo.derecho);
    }

    // Concatenar todos los valores en una sola cadena
    StringBuilder mensaje = new StringBuilder("Recorrido en amplitud del �rbol:\n");
    for (String valor : valores) {
        mensaje.append(valor).append(" ");
    }

    // Mostrar la cadena de texto en un cuadro de texto emergente
    JOptionPane.showMessageDialog(null, mensaje.toString());
}
    
    public void dibujarArbol() {
    // Calcular la altura total del �rbol
    int alturaArbol = calcularAltura(raiz) * 100; // Multiplicar por un factor para ajustar el espacio entre niveles

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // Ajustar el tama�o del frame para que quepa el �rbol completo
    frame.setSize(600, Math.min(alturaArbol, 400));

    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            dibujarNodo(g, raiz, 300, 50, 200, getHeight()); // Pasar la altura del panel
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, alturaArbol); // Ajustar la altura del panel
        }
    };

    JScrollPane scrollPane = new JScrollPane(panel);
    frame.add(scrollPane);
    frame.setVisible(true);
}

    private void dibujarNodo(Graphics g, Nodo nodo, int x, int y, int espacio, int alturaPanel) {
    if (nodo == null) return;

    g.setColor(Color.black);
    g.fillOval(x, y, 20, 20);
    g.setColor(Color.white);
    g.drawString(String.valueOf(nodo.valor), x + 5, y + 13);

    if (nodo.izquierdo != null) {
        g.setColor(Color.black);
        int nuevaAltura = y + 100; // Ajustar la nueva altura para la l�nea
        g.drawLine(x + 10, y + 20, x - espacio + 10, nuevaAltura); // Dibujar la l�nea con la nueva altura
        dibujarNodo(g, nodo.izquierdo, x - espacio, nuevaAltura, espacio / 2, alturaPanel);
    }

    if (nodo.derecho != null) {
        g.setColor(Color.black);
        int nuevaAltura = y + 100; // Ajustar la nueva altura para la l�nea
        g.drawLine(x + 10, y + 20, x + espacio + 10, nuevaAltura); // Dibujar la l�nea con la nueva altura
        dibujarNodo(g, nodo.derecho, x + espacio, nuevaAltura, espacio / 2, alturaPanel);
    }
}


}
