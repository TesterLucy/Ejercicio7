/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package arbolb;

import javax.swing.JOptionPane;

/**
 *
 * @author Kisan
 */
public class Arbolito extends javax.swing.JPanel {

    private ArbolBinario arbol;
    
    public Arbolito(ArbolBinario arbolBinario) {
    initComponents();
    this.arbol = arbolBinario;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        CrearArbol = new javax.swing.JButton();
        ModificarNodo = new javax.swing.JButton();
        RecorrerArbol = new javax.swing.JButton();
        GradodelArbol = new javax.swing.JButton();
        CalcularNiveldeNodo = new javax.swing.JButton();
        CalcularAltura = new javax.swing.JButton();
        ImprimirArbol = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        CrearArbol.setText("Crear Arbol");
        CrearArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearArbolActionPerformed(evt);
            }
        });

        ModificarNodo.setText("Modificar Nodo");
        ModificarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarNodoActionPerformed(evt);
            }
        });

        RecorrerArbol.setText("Recorrer arbol");
        RecorrerArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecorrerArbolActionPerformed(evt);
            }
        });

        GradodelArbol.setText("Calcular Grado del arbol");
        GradodelArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradodelArbolActionPerformed(evt);
            }
        });

        CalcularNiveldeNodo.setText("Calcular Nivel de un nodo");
        CalcularNiveldeNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularNiveldeNodoActionPerformed(evt);
            }
        });

        CalcularAltura.setText("Calcular Altura");
        CalcularAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularAlturaActionPerformed(evt);
            }
        });

        ImprimirArbol.setText("Imprimir Arbol");
        ImprimirArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirArbolActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jButton3.setText("Dibujar Arbol");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(Salir)
                    .addComponent(ImprimirArbol)
                    .addComponent(CalcularAltura)
                    .addComponent(CalcularNiveldeNodo)
                    .addComponent(GradodelArbol)
                    .addComponent(RecorrerArbol)
                    .addComponent(ModificarNodo)
                    .addComponent(CrearArbol))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(CrearArbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModificarNodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecorrerArbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GradodelArbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalcularNiveldeNodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalcularAltura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImprimirArbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(7, 7, 7)
                .addComponent(Salir)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CrearArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearArbolActionPerformed
        this.arbol=arbol.crearNuevoArbol();
    }//GEN-LAST:event_CrearArbolActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void ModificarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarNodoActionPerformed
        arbol.anadirNodo();
    }//GEN-LAST:event_ModificarNodoActionPerformed

    private void RecorrerArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecorrerArbolActionPerformed
        arbol.mostrarRecorridos();
    }//GEN-LAST:event_RecorrerArbolActionPerformed

    private void GradodelArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradodelArbolActionPerformed
        JOptionPane.showMessageDialog(null,"Grado del arbol: "+arbol.calcularGrado());
    }//GEN-LAST:event_GradodelArbolActionPerformed

    private void CalcularNiveldeNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularNiveldeNodoActionPerformed
        int buscar = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el nodo que desea buscar: "));
        JOptionPane.showMessageDialog(null,"Grado del nodo "+buscar+" en el arbol: "+arbol.calcularNivel(buscar));
    }//GEN-LAST:event_CalcularNiveldeNodoActionPerformed

    private void CalcularAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularAlturaActionPerformed
        JOptionPane.showMessageDialog(null,"Altura del arbol: "+arbol.calcularAltura(arbol.raiz));
    }//GEN-LAST:event_CalcularAlturaActionPerformed

    private void ImprimirArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirArbolActionPerformed
        arbol.imprimirArbol();
    }//GEN-LAST:event_ImprimirArbolActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        arbol.dibujarArbol();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalcularAltura;
    private javax.swing.JButton CalcularNiveldeNodo;
    private javax.swing.JButton CrearArbol;
    private javax.swing.JButton GradodelArbol;
    private javax.swing.JButton ImprimirArbol;
    private javax.swing.JButton ModificarNodo;
    private javax.swing.JButton RecorrerArbol;
    private javax.swing.JButton Salir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
