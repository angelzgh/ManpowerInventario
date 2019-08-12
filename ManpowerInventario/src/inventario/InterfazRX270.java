/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import static javax.swing.Action.NAME;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import inventario.Interfaz_principal;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author ANDRES
 */
public class InterfazRX270 extends javax.swing.JInternalFrame {

  PdfDAO dao = null;
    private Object[][] datostabla;    
      
    control_existencias ctr = new control_existencias();
    control_equipo ctre= new control_equipo();
    Interfaz_principal inp= new Interfaz_principal();
    String ruta_archivo = "";
    Sentencias_sql sen= new Sentencias_sql();
    
      
    public InterfazRX270() {
        initComponents();
        filtrohis.setVisible(false);
        acartar.setVisible(false);
    }

    public void agregarCarta(){
    acartar.setVisible(true);
    }
    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }
    
    public String mostrar(){
String p= null;
        if(this.title.equals("Registro L450")){
        p="PF0E";
        }else if(this.title.equals("Registro X270")){
        p="PC0SU";
        }
        return p;
}    
      public void mostrar_tablaasignados(){
        
          jTable1.setDefaultRenderer(Object.class, new imgTabla());
          ImageIcon icono = null;
        if (get_Image("/Imagen/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Imagen/32pdf.png"));
        }
        PdfVO vo = new PdfVO();
        String status=sen.cartar(mostrar());
        String[] columnas = {"Serie","Status","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctre.consulta_equipoasignados(mostrar());
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
                Object fila[] = new Object[14];
                if (status != "Pendiente") {
                    fila[13] = new JButton(icono);
                } else {
                    System.out.println("sin archivo");
                }
                jTable1.setModel(datos);
    }
       
    public void mostrar_tablahistorial(){
        
        String[] columnas = {"Serie","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctre.consulta_equipohisto(mostrar());
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        acartar.setVisible(false);
    }
  
    public void mostrar_tablaenbodega(){
        
        String[] columnas = {"Serie","Status","Comentarios"};
        datostabla = ctre.consulta_equipobodega(mostrar());
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        acartar.setVisible(false);
    }
    public void mostrar_tabladañado(){

        String[] columnas = {"Serie","Status","Comentarios"};
        datostabla = ctre.consulta_equipodañado(mostrar());
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);  
        acartar.setVisible(false);
    }
     public void mostrar_tablagarantia(){

        String[] columnas = {"Serie","Status","Comentarios"};
        datostabla = ctre.consulta_equipogarantia(mostrar());
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        acartar.setVisible(false);
    }
     public void seleccionar_pdf() {
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.narchivo.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();

        } else {
        }
    }
     public void guardar_pdf(String serie, File ruta) {
        PdfDAO pa = new PdfDAO();
        PdfVO po = new PdfVO();
        po.setSerie(serie);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        pa.Agregar_PdfVO(po);
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
        buscar = new javax.swing.JTextField();
        asignados = new javax.swing.JButton();
        enbodega = new javax.swing.JButton();
        dañados = new javax.swing.JButton();
        garantia = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        filtro = new javax.swing.JComboBox<>();
        filtrohis = new javax.swing.JComboBox<>();
        acartar = new javax.swing.JButton();
        guardararch = new javax.swing.JButton();
        narchivo = new javax.swing.JTextField();

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

        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
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

        jLabel1.setText("Buscar por:");

        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serie", "Usuario", "Soporte", "Historial" }));
        filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroActionPerformed(evt);
            }
        });

        filtrohis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serie", "Usuario", "Soporte" }));
        filtrohis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrohisActionPerformed(evt);
            }
        });

        acartar.setText("Agregar Carta Responsiva");
        acartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acartarActionPerformed(evt);
            }
        });

        guardararch.setText("Guardar");
        guardararch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardararchActionPerformed(evt);
            }
        });

        narchivo.setEditable(false);
        narchivo.setText("Nombre del archivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filtrohis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filtro, 0, 101, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(asignados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enbodega)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dañados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(garantia))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(acartar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(narchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(guardararch)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1214, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asignados)
                    .addComponent(enbodega)
                    .addComponent(dañados)
                    .addComponent(garantia)
                    .addComponent(jButton3)
                    .addComponent(jLabel1)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(filtrohis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(acartar)
                                .addComponent(narchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(guardararch))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
    
    }//GEN-LAST:event_buscarActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
   
    }//GEN-LAST:event_buscarKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int s=filtro.getSelectedIndex();
String equipo=buscar.getText();
String status=ctr.statusbdg(equipo);
        switch(s){
            case 0:
                if(ctr.existe_equipoX270("'%"+equipo+"'")){
                    if(status.equals("1")){
        String[] columnas = {"Serie","Status","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctr.buscadors(equipo);
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        buscar.setText("");
                    }else if(status.equals("3")||status.equals("2")||status.equals("4")){
             String[] columnas = {"Serie","Status","Comentarios"};
        datostabla = ctr.buscadorsbdg(buscar.getText());
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        buscar.setText("");
                    }
         }
        else{
        JOptionPane.showMessageDialog(null,"El equipo no se encuentra registrado o el número de serie es incorrecto","Mensaje",JOptionPane.QUESTION_MESSAGE);  
        }
                break;
            case 1:    
                if (ctr.existe_usuario("'"+equipo+"%'")) {
        String[] columnas = {"Serie","Status","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctr.buscadoru(equipo);
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        buscar.setText("");}
        else{
        JOptionPane.showMessageDialog(null,"El usuario no se encuentra registrado o el nombre de usuario es incorrecto","Mensaje",JOptionPane.QUESTION_MESSAGE);  
        }
                break;
            case 2:
                
        if (ctr.existe_soporte("'"+equipo+"'")) {
        String[] columnas = {"Serie","Status","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctr.buscadorso(equipo);
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        buscar.setText("");
        }
        else{
        JOptionPane.showMessageDialog(null,"El usuario "+equipo + " no es parte del equipo de infraestructura","Mensaje",JOptionPane.QUESTION_MESSAGE);  
        }
        break;
            case 3:
            int h=filtrohis.getSelectedIndex();
            switch(h){
                case 0:
                  if (ctr.existe_equipoX270("'%"+equipo+"'")) {  
            String[] columnas = {"Serie","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctr.buscadorhistos(buscar.getText());
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        buscar.setText("");
                  }
            else{
        JOptionPane.showMessageDialog(null,"El equipo no se encuentra registrado o el número de serie es incorrecto","Mensaje",JOptionPane.QUESTION_MESSAGE);  
        } break;
        
                case 1:
                    if (ctr.existe_usuario("'"+equipo+"%'")) {
            String[] columnas = {"Serie","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctr.buscadorhistou(buscar.getText());
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        buscar.setText("");
                    }else{
        JOptionPane.showMessageDialog(null,"El usuario no se encuentra registrado o el nombre de usuario es incorrecto","Mensaje",JOptionPane.QUESTION_MESSAGE);  
        }break;
                case 2:
                    if (ctr.existe_soporte("'"+equipo+"'")) {
        String[] columnas = {"Serie","Nombre","Noempleado","Correo","UDN","CC","Jefe","Fecha","Hostname","Bitlocker","Registrado por","Comentarios","Carta Responsiva"};
        datostabla = ctr.buscadorhistoso(buscar.getText());
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        buscar.setText("");
                    }
        else{
        JOptionPane.showMessageDialog(null,"El usuario "+equipo + " no es parte del equipo de infraestructura","Mensaje",JOptionPane.QUESTION_MESSAGE);  
        }break;
        }
        break;
        }
        System.out.println("ghgh:"+s);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void enbodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enbodegaActionPerformed
mostrar_tablaenbodega();        // TODO add your handling code here:
    }//GEN-LAST:event_enbodegaActionPerformed

    private void garantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_garantiaActionPerformed
mostrar_tablagarantia();        // TODO add your handling code here:
    }//GEN-LAST:event_garantiaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
mostrar_tablahistorial();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dañadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dañadosActionPerformed
mostrar_tabladañado();        // TODO add your handling code here:
    }//GEN-LAST:event_dañadosActionPerformed

    private void asignadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignadosActionPerformed
mostrar_tablaasignados();
agregarCarta();
// TODO add your handling code here:
    }//GEN-LAST:event_asignadosActionPerformed

    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed
String itemSeleecionado;
        itemSeleecionado= (String)filtro.getSelectedItem();
        if ("Historial".equals(itemSeleecionado)) {
        filtrohis.setVisible(true);} 
        else{
        filtrohis.setVisible(false); 
        }// TODO add your handling code here:
    }//GEN-LAST:event_filtroActionPerformed

    private void filtrohisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrohisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrohisActionPerformed

    private void acartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acartarActionPerformed
seleccionar_pdf();    // TODO add your handling code here:
    }//GEN-LAST:event_acartarActionPerformed

    private void guardararchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardararchActionPerformed
 String nombre = narchivo.getText();
String serie="PC0SUCC2";
        File ruta = new File(ruta_archivo);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            guardar_pdf(serie, ruta);
            ruta_archivo = "";
            narchivo.setEnabled(false);
            narchivo.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Rellenar todo los campos");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_guardararchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acartar;
    private javax.swing.JButton asignados;
    private javax.swing.JTextField buscar;
    private javax.swing.JButton dañados;
    private javax.swing.JButton enbodega;
    private javax.swing.JComboBox<String> filtro;
    private javax.swing.JComboBox<String> filtrohis;
    private javax.swing.JButton garantia;
    private javax.swing.JButton guardararch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField narchivo;
    // End of variables declaration//GEN-END:variables
}
