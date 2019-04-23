/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.text.SimpleDateFormat;
import java.util.Date;


public class control_existencias 
{
    
     private Sentencias_sql sen;
     public String Documento;
     private  String numero_factura="";

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public String getId_cliente() {
        return Documento;
    }

    public void setId_cliente(String id_cliente) {
        this.Documento = Documento;
    }
     private String No_documento;

    public String getId_proveedor() {
        return No_documento;
    }

    public void setId_proveedor(String id_proveedor) {
        this.No_documento = No_documento;
    }

    public String getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(String id_articulo) {
        this.id_articulo = id_articulo;
    }
     private String id_articulo;
     
     public control_existencias()
     {
         sen = new Sentencias_sql();
     }
     
     public boolean existe_equipoL450( String cod)
     {
         
        this.Documento = cod;
      
        return sen.existencias(cod," from Equipo where serie like '"+"PF0E"+"%' and serie="+cod+";");
      
    }
     public boolean existe_equipoX270( String cod)
     {
         
        this.Documento = cod;
      
        return sen.existencias(cod," from Equipo where serie like '"+"PC0SU"+"%' and serie="+cod+";");
      
    }
   public boolean existe_equipo( String cod)
     {
         
        this.Documento = cod;
      
        return sen.existencias(cod," from Equipo where serie="+cod+";");
      
    }
     
     public String ingresa_serie()
     { 
       String result;
       result = sen.datos_string("serie", "select serie from equipo where serie="+this.Documento+";");
       return result;
    }
     
    public String ingresa_status(String nueva)
     { 
         
       String result;
       result = sen.datos_string("status_idstatus", "select status_idstatus from equipo where serie="+nueva+";");
       return result;
    }
    public String ingresa_cc(String nueva)
     { 
         
       String result;
       result = sen.datos_string("cc_idCC", "select cc_idcc from asignacion  where equipo_serie="+nueva+";");
       return result;
    }public String ingresa_udn(String nueva)
     { 
         
       String result;
       result = sen.datos_string("udn_idUDN", "select udn_idudn from asignacion where Equipo_serie="+nueva+";");
       return result;
    }
    public String ingresa_soporte(String nueva)
     { 
         
       String result;
       result = sen.datos_string("nombre", "select s.nombre from soporte s, asignacion a where a.equipo_serie="+nueva+" and a.soporte_idsoporte=s.idsoporte;");
       return result;
    }
    public String ingresa_nombre(String nueva)
     { 
       String result;
       result = sen.datos_string("nombre", "select nombre from asignacion where equipo_serie="+nueva+";");
       return result;
    }
     public String ingresa_noempleado(String nueva)
     { 
       String result;
       result = sen.datos_string("noempleado", "select noempleado from asignacion where equipo_serie="+nueva+";");
       return result;
    }public String ingresa_correo(String nueva)
     { 
       String result;
       result = sen.datos_string("correo", "select correo from asignacion where equipo_serie="+nueva+";");
       return result;
    }public String ingresa_jfd(String nueva)
     { 
       String result;
       result = sen.datos_string("jefe", "select jefe from asignacion where equipo_serie="+nueva+";");
       return result;
    }public String ingresa_fecha(String nueva)
     { 
       String result;
       result = sen.datos_string("fechaasig", "select fechaasig from asignacion where equipo_serie="+nueva+";");
       return result;
    }public String ingresa_host(String nueva)
     { 
       String result;
       result = sen.datos_string("hostname", "select hostname from asignacion where equipo_serie="+nueva+";");
       return result;
    }public String ingresa_bit(String nueva)
     { 
       String result;
       result = sen.datos_string("bitlocker", "select bitlocker from asignacion where equipo_serie="+nueva+";");
       return result;
     }
          public boolean update_factura(String factura, String total, String iva)
      {
          String campos[] = {total, iva,factura};           
          return sen.insertar(campos, "update factura set total_factura=?, IVA=? where Nnm_factura=?;");
      
      }
      
      public boolean update_stock(String stock, String id_articulo)
      {
          String campos[] = {stock,id_articulo};           
          return sen.insertar(campos, "update articulo set stock=stock+? where id_articulo=?;");
      
      }
     
     
     public Object[] combox(String tabla, String campo)
     {
        return sen.poblar_combox(tabla, campo, "select "+campo+" from "+tabla+";");
     }
     
     
     public Object[][] datos_cliente(String id_cliente)
     {
        String[] columnas={"Documento","Descripcion","Nombres","Apellidos","Direccion","Nombre_ciudad","Telefono"};
        Object[][] resultado = sen.GetTabla(columnas, "cliente", "select * from cliente, ciudad, tipo_de_documento where id_tipo_documento=cod_tipo_documento and Codigo_ciudad=cod_ciudad and documento='"+id_cliente+"';");
        return resultado;
      }

      
     
       public boolean asignacion(String id,String serie, String nombre, String noempleado, String correo, String jefe,String udn,String cc,String fechaasig,String hostname,String bitlocker,String soporte, String serieanterior, String fechabaja,String status)
    {               
        
            String[] columnas={id,serie,nombre,noempleado,correo,jefe,udn,cc,fechaasig,hostname,bitlocker,soporte,serieanterior,fechabaja,status};
            return sen.insertar(columnas, "insert into asignacion(idAsignacion,Equipo_Serie,Nombre,Noempleado,Correo,Jefe,UDN_idUDN,CC_idCC,fechaasig,Hostname,Bitlocker,Soporte_idSoporte,EquipoAnterior,Fechaterm,status_idStatus) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                  
        
    }
       public boolean acualizarEquipo(String status_idstatus,String Cartar,String serie){
           String[] columnas={status_idstatus,Cartar};
        return sen.insertar(columnas, "update equipo set status_idstatus=? ,cartar=? where serie='"+serie+"';");
       
       }
        public boolean registrar_producto(String Nnm_factura,String id_articulo,String cantidad, String total)
        {
        String[] datos = {Nnm_factura,id_articulo, cantidad,total};
        
        String[] datosP = {cantidad, id_articulo};
        if(sen.insertar(datosP, "update articulo set stock=stock-? where id_articulo=?;"))
        {
            return sen.insertar(datos, "insert into detalle_factura(cod_factura,cod_articulo,cantidad,total) values(?,?,?,?);");
        }
        else
        {
            return false;
        }
    }

    

    
        
       
    }
