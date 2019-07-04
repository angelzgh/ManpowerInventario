/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ANDRES
 */
public class Interfaz_principal extends javax.swing.JFrame {
control_existencias ctrl = new control_existencias();
    
    /**
     * Creates new form Interfaz_principal
     */
    public Interfaz_principal() {
        initComponents();
    }
    public void equipoasig (){
    String serie;
      InterfazX270 x270 = new InterfazX270(ctrl);
        do{
             serie= JOptionPane.showInputDialog(this,"Número de Serie: ",JOptionPane.OK_OPTION);
        System.out.println("Cadena:"+"'"+serie+"'");
        
       if(ctrl.existe_equipoL450("'"+serie+"'"))
       {
        jDesktopPane1.add(x270);
        x270.show();
        x270.setTitle("L450");
        x270.serie.setText(serie.toUpperCase());
       } else if(ctrl.existe_equipoX270("'"+serie+"'")){
        jDesktopPane1.add(x270);
        x270.show();
        x270.serie.setText(serie.toUpperCase());
       }
       else
       {
              
          JOptionPane.showMessageDialog(null,"El equipo no se encuentra registrado o el número de serie es incorrecto","Mensaje",JOptionPane.QUESTION_MESSAGE);  
       }
if(serie.equals(JOptionPane.CANCEL_OPTION)){}        
        }while(!ctrl.existe_equipo("'"+serie+"'"));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Asignacion = new javax.swing.JMenu();
        Asig = new javax.swing.JMenuItem();
        EnSal = new javax.swing.JMenu();
        Esregistrar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        El450 = new javax.swing.JMenuItem();
        Ex270 = new javax.swing.JMenuItem();
        El470 = new javax.swing.JMenuItem();
        E13 = new javax.swing.JMenuItem();
        Etinny = new javax.swing.JMenuItem();
        Ecpu = new javax.swing.JMenuItem();
        Emonitor = new javax.swing.JMenuItem();
        Earrendamiento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Lineas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        garantias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1350, 650));
        setMinimumSize(new java.awt.Dimension(1350, 650));
        setPreferredSize(new java.awt.Dimension(1350, 650));

        jDesktopPane1.setBackground(java.awt.Color.lightGray);
        jDesktopPane1.setMaximumSize(new java.awt.Dimension(1350, 650));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(1350, 650));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setLabelFor(jDesktopPane1);
        jLabel2.setMaximumSize(new java.awt.Dimension(1350, 650));
        jLabel2.setMinimumSize(new java.awt.Dimension(1350, 650));
        jLabel2.setPreferredSize(new java.awt.Dimension(1350, 650));
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1350, 650);

        Asignacion.setText("Asignación");
        Asignacion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Asignacion.setMaximumSize(new java.awt.Dimension(130, 32767));
        Asignacion.setPreferredSize(new java.awt.Dimension(180, 50));

        Asig.setText("Nueva");
        Asig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsigActionPerformed(evt);
            }
        });
        Asignacion.add(Asig);

        jMenuBar1.add(Asignacion);

        EnSal.setText("Entrada");
        EnSal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        EnSal.setMaximumSize(new java.awt.Dimension(130, 32767));
        EnSal.setPreferredSize(new java.awt.Dimension(0, 0));

        Esregistrar.setText("Registrar");
        Esregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EsregistrarActionPerformed(evt);
            }
        });
        EnSal.add(Esregistrar);

        jMenuBar1.add(EnSal);

        jMenu1.setBorder(new javax.swing.border.MatteBorder(null));
        jMenu1.setText("Equipos");
        jMenu1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(100, 50));

        El450.setText("L450");
        El450.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                El450ActionPerformed(evt);
            }
        });
        jMenu1.add(El450);

        Ex270.setText("X270");
        Ex270.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ex270ActionPerformed(evt);
            }
        });
        jMenu1.add(Ex270);

        El470.setText("Comprados");
        El470.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                El470ActionPerformed(evt);
            }
        });
        jMenu1.add(El470);

        E13.setText("13");
        E13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E13ActionPerformed(evt);
            }
        });
        jMenu1.add(E13);

        Etinny.setText("Tinny");
        Etinny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtinnyActionPerformed(evt);
            }
        });
        jMenu1.add(Etinny);

        Ecpu.setText("CPU");
        Ecpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcpuActionPerformed(evt);
            }
        });
        jMenu1.add(Ecpu);

        Emonitor.setText("Monitor");
        Emonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmonitorActionPerformed(evt);
            }
        });
        jMenu1.add(Emonitor);

        Earrendamiento.setText("Arrendamiento");
        Earrendamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EarrendamientoActionPerformed(evt);
            }
        });
        jMenu1.add(Earrendamiento);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(new javax.swing.border.MatteBorder(null));
        jMenu2.setText("Lineas telefonicas");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        Lineas.setText("Lineas");
        Lineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineasActionPerformed(evt);
            }
        });
        jMenu2.add(Lineas);

        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(new javax.swing.border.MatteBorder(null));
        jMenu3.setText("Garantias");
        jMenu3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        garantias.setText("Equipos");
        garantias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                garantiasActionPerformed(evt);
            }
        });
        jMenu3.add(garantias);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EsregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EsregistrarActionPerformed
InterfazEntrada ent = new InterfazEntrada(ctrl);
        jDesktopPane1.add(ent);
        ent.show();         // TODO add your handling code here:
    }//GEN-LAST:event_EsregistrarActionPerformed

    private void El450ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_El450ActionPerformed
     
  // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_El450ActionPerformed

    private void AsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsigActionPerformed
   equipoasig ();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_AsigActionPerformed

    private void Ex270ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ex270ActionPerformed
   InterfazRX270 rx270 = new InterfazRX270();
        jDesktopPane1.add(rx270);
        rx270.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_Ex270ActionPerformed

    private void El470ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_El470ActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_El470ActionPerformed

    private void E13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E13ActionPerformed
 InterfazR13 r13 = new InterfazR13();
        jDesktopPane1.add(r13);
        r13.show();        // TODO add your handling code here:
    }//GEN-LAST:event_E13ActionPerformed

    private void EtinnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtinnyActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_EtinnyActionPerformed

    private void EcpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcpuActionPerformed
 InterfazRCPU rCPU = new InterfazRCPU();
        jDesktopPane1.add(rCPU);
        rCPU.show();        // TODO add your handling code here:
    }//GEN-LAST:event_EcpuActionPerformed

    private void EmonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmonitorActionPerformed
InterfazRMonitor rMonitor = new InterfazRMonitor();
        jDesktopPane1.add(rMonitor);
        rMonitor.show();         // TODO add your handling code here:
    }//GEN-LAST:event_EmonitorActionPerformed

    private void EarrendamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EarrendamientoActionPerformed
InterfazRArrendamiento rArrendamiento = new InterfazRArrendamiento();
        jDesktopPane1.add(rArrendamiento);
        rArrendamiento.show();         // TODO add your handling code here:
    }//GEN-LAST:event_EarrendamientoActionPerformed

    private void LineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineasActionPerformed
 InterfazRLineas rlineas = new InterfazRLineas();
        jDesktopPane1.add(rlineas);
        rlineas.show();        // TODO add your handling code here:
    }//GEN-LAST:event_LineasActionPerformed

    private void garantiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_garantiasActionPerformed
InterfazGarantia gar = new InterfazGarantia(ctrl);
        jDesktopPane1.add(gar);
        gar.show();       // TODO add your handling code here:
    }//GEN-LAST:event_garantiasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Asig;
    private javax.swing.JMenu Asignacion;
    private javax.swing.JMenuItem E13;
    private javax.swing.JMenuItem Earrendamiento;
    private javax.swing.JMenuItem Ecpu;
    private javax.swing.JMenuItem El450;
    private javax.swing.JMenuItem El470;
    private javax.swing.JMenuItem Emonitor;
    private javax.swing.JMenu EnSal;
    private javax.swing.JMenuItem Esregistrar;
    private javax.swing.JMenuItem Etinny;
    private javax.swing.JMenuItem Ex270;
    private javax.swing.JMenuItem Lineas;
    private javax.swing.JMenuItem garantias;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
