/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDRES
 */
public class InterfazRX270 extends javax.swing.JInternalFrame {

   
    private Object[][] datostabla;    
    control_existencias ctr = new control_existencias();
    public InterfazRX270() {
        initComponents();
        mostrar_tablaasignados();
        
    }
              
    
       
    public void mostrar_tablahistorial(){
        control_equipo ctr;       
        ctr = new control_equipo();
        String[] columnas = {"Serie","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctr.consulta_equipohisto();
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
    }
    public void mostrar_tablaasignados(){
        control_equipo ctr;       
        ctr = new control_equipo();
        String[] columnas = {"Serie","Status","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctr.consulta_equipoasignados();
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
    }
    public void mostrar_tablaenbodega(){
        control_equipo ctr;       
        ctr = new control_equipo();
        String[] columnas = {"Serie","Status","Comentarios"};
        datostabla = ctr.consulta_equipobodega();
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
    }
    public void mostrar_tabladañado(){
        control_equipo ctr;       
        ctr = new control_equipo();
        String[] columnas = {"Serie","Status","Comentarios"};
        datostabla = ctr.consulta_equipodañado();
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buscarcliente = new javax.swing.JTextField();
        asignados = new javax.swing.JButton();
        enbodega = new javax.swing.JButton();
        dañados = new javax.swing.JButton();
        garantia = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro X270");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarclienteActionPerformed(evt);
            }
        });
        buscarcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarclienteKeyReleased(evt);
            }
        });

        asignados.setText("Asignados");
        asignados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignadosActionPerformed(evt);
            }
        });

        enbodega.setText("En bodega");
        enbodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enbodegaActionPerformed(evt);
            }
        });

        dañados.setText("Dañados");
        dañados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dañadosActionPerformed(evt);
            }
        });

        garantia.setText("Garantia");
        garantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                garantiaActionPerformed(evt);
            }
        });

        jButton3.setText("Historial");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(asignados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enbodega)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dañados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(garantia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(asignados)
                    .addComponent(enbodega)
                    .addComponent(dañados)
                    .addComponent(garantia)
                    .addComponent(jButton3))
                .addGap(4, 4, 4)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarclienteActionPerformed
    
    }//GEN-LAST:event_buscarclienteActionPerformed

    private void buscarclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarclienteKeyReleased
   
    }//GEN-LAST:event_buscarclienteKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void enbodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enbodegaActionPerformed
mostrar_tablaenbodega();        // TODO add your handling code here:
    }//GEN-LAST:event_enbodegaActionPerformed

    private void garantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_garantiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_garantiaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
mostrar_tablahistorial();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dañadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dañadosActionPerformed
mostrar_tabladañado();        // TODO add your handling code here:
    }//GEN-LAST:event_dañadosActionPerformed

    private void asignadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignadosActionPerformed
mostrar_tablaasignados();        // TODO add your handling code here:
    }//GEN-LAST:event_asignadosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignados;
    private javax.swing.JTextField buscarcliente;
    private javax.swing.JButton dañados;
    private javax.swing.JButton enbodega;
    private javax.swing.JButton garantia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
