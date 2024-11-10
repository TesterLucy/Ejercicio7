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
    
    // Métodos de manipulación del árbol
    
    public static ArbolBinario crearNuevoArbol() {
        String mensaje = JOptionPane.showInputDialog(null,"¿Qué tipo de datos desea almacenar en el árbol?\n1.Números\n2.Letras\nSeleccione una opción");
        int opcion = Integer.parseInt(mensaje);
        ArbolBinario arbol;
        if (opcion == 1) {
            String valor1 = JOptionPane.showInputDialog(null,"Ingrese el valor para el nodo raíz: ");
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
            String valor4 = JOptionPane.showInputDialog(null,"Ingrese el valor para el nodo raíz: ");
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
            JOptionPane.showMessageDialog(null,"Opción no válida.");
            return null;
        }
        
        JOptionPane.showMessageDialog(null,"Árbol creado con éxito.");
        return arbol;
    }
    
    public void anadirNodo() {
    if (raiz == null) {
        JOptionPane.showMessageDialog(null,"Aún no se ha creado ningún árbol.");
        return;
    }

    int valor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor del nodo al que desea agregar un nuevo nodo: "));
    List<Nodo> nodosCoincidentes = new ArrayList<>();
    buscarNodo(raiz, valor, nodosCoincidentes, 1); // Buscar nodos coincidentes

    if (nodosCoincidentes.isEmpty()) {
        JOptionPane.showMessageDialog(null,"No se encontró ningún nodo con el valor especificado en el árbol.");
        return;
    }

    // Si hay nodos coincidentes, preguntar al usuario en qué nivel desea trabajar
    if (nodosCoincidentes.size() > 1) {
        StringBuilder mensaje = new StringBuilder("Se encontraron nodos con el valor especificado en los siguientes niveles:\n");
        for (int i = 0; i < nodosCoincidentes.size(); i++) {
            mensaje.append("Nivel ").append(nodosCoincidentes.get(i).nivel).append("\n");
        }
        mensaje.append("En qué nivel desea trabajar? Ingrese el número correspondiente:");

        int nivelSeleccionado = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje.toString()));
        Nodo nodo = null;
        for (Nodo n : nodosCoincidentes) {
            if (n.nivel == nivelSeleccionado) {
                nodo = n;
                break;
            }
        }
        if (nodo == null) {
            JOptionPane.showMessageDialog(null,"Nivel no válido.");
            return;
        }
    }

    // Preguntar al usuario en qué dirección desea agregar el nuevo nodo
    int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione la dirección para agregar el nuevo nodo:\n1. Izquierda\n2. Derecha"));
    if (opcion != 1 && opcion != 2) {
        JOptionPane.showMessageDialog(null,"Opción no válida.");
        return;
    }

    // Obtener el nodo seleccionado para agregar el nuevo nodo
    Nodo nodo = nodosCoincidentes.get(0);

    // Verificar si el nodo seleccionado ya tiene datos
    if (nodo.izquierdo != null || nodo.derecho != null) {
        int respuesta = JOptionPane.showConfirmDialog(null,"El nodo que ingresaste tiene como dato " + nodo.valor + ". Deseas modificarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            int nuevoValor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el nuevo valor para el nodo: "));
            nodo.valor = nuevoValor;
            JOptionPane.showMessageDialog(null,"Valor del nodo modificado con éxito.");
            return;
        }
    }

    // Añadir el nuevo nodo según la dirección seleccionada por el usuario
    if (opcion == 1) {
        int nuevoValor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor para el nuevo nodo izquierdo: "));
        nodo.izquierdo = new Nodo(nuevoValor);
        JOptionPane.showMessageDialog(null,"Nodo izquierdo añadido con éxito.");
    } else {
        int nuevoValor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor para el nuevo nodo derecho: "));
        nodo.derecho = new Nodo(nuevoValor);
        JOptionPane.showMessageDialog(null,"Nodo derecho añadido con éxito.");
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
    
    // Métodos de recorrido del árbol
    
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
    
    // Métodos para calcular propiedades del árbol
    
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
    StringBuilder mensaje = new StringBuilder("Recorrido en amplitud del árbol:\n");
    for (String valor : valores) {
        mensaje.append(valor).append(" ");
    }

    // Mostrar la cadena de texto en un cuadro de texto emergente
    JOptionPane.showMessageDialog(null, mensaje.toString());
}
    
    public void dibujarArbol() {
    // Calcular la altura total del árbol
    int alturaArbol = calcularAltura(raiz) * 100; // Multiplicar por un factor para ajustar el espacio entre niveles

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // Ajustar el tamaño del frame para que quepa el árbol completo
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
        int nuevaAltura = y + 100; // Ajustar la nueva altura para la línea
        g.drawLine(x + 10, y + 20, x - espacio + 10, nuevaAltura); // Dibujar la línea con la nueva altura
        dibujarNodo(g, nodo.izquierdo, x - espacio, nuevaAltura, espacio / 2, alturaPanel);
    }

    if (nodo.derecho != null) {
        g.setColor(Color.black);
        int nuevaAltura = y + 100; // Ajustar la nueva altura para la línea
        g.drawLine(x + 10, y + 20, x + espacio + 10, nuevaAltura); // Dibujar la línea con la nueva altura
        dibujarNodo(g, nodo.derecho, x + espacio, nuevaAltura, espacio / 2, alturaPanel);
    }
}


}
