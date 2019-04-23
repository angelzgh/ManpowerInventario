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
       result = sen.datos_string("descripcion", "select s.descripcion from status s, equipo e where e.serie="+nueva+" and e.status_idstatus=s.idstatus;");
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
       result = sen.datos_string("descripcion", "select u.descripcion from udn u, asignacion a where a.Equipo_serie="+nueva+" and a.udn_idudn=u.idudn;");
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
     
     public Object[][] datos_articulo(String id_articulo)
     {
        String[] columnas={"descripcion","precio_venta","stock"};
        Object[][] resultado = sen.GetTabla(columnas, "articulo", "select descripcion, precio_venta, stock from articulo where id_articulo='"+id_articulo+"';");
        return resultado;
      }
     
     public Object[][] datos_cliente(String id_cliente)
     {
        String[] columnas={"Documento","Descripcion","Nombres","Apellidos","Direccion","Nombre_ciudad","Telefono"};
        Object[][] resultado = sen.GetTabla(columnas, "cliente", "select * from cliente, ciudad, tipo_de_documento where id_tipo_documento=cod_tipo_documento and Codigo_ciudad=cod_ciudad and documento='"+id_cliente+"';");
        return resultado;
      }
      public Object[][] datos_detallefactura(String numero_factura)
     {
        String[] columnas={"cod_factura","cod_articulo","descripcion","cantidad","total"};
        Object[][] resultado = sen.GetTabla(columnas, "detalle_factura where cod_factura='"+numero_factura+"';", "select * from detalle_factura,articulo where id_articulo = cod_articulo and cod_factura='"+numero_factura+"';");
        return resultado;
      }
      
      public Object[][] consulta_factura(String id)
       {
        String[] columnas={"Nnm_factura","Nombres","Apellidos","Nombre_empleado","Fecha_facturacion","Descripcion_formapago","total_factura","IVA"};
        Object[][] resultado = sen.GetTabla(columnas, "cliente", "select * from cliente, factura, forma_de_pago where documento=cod_cliente and cod_formapago=id_formapago and documento='"+id+"';");
        return resultado;
       }
      
       public boolean devolucion(String cod_detallefactura, String cod_detallearticulo, String Motivo, String fecha_devolucion, String cantidad)
       {
        String[] columnas={cod_detallefactura,cod_detallearticulo,Motivo,fecha_devolucion,cantidad};
        return sen.insertar(columnas, "insert into devolucion(cod_detallefactura,cod_detallearticulo,Motivo,fecha_devolucion,cantidad) values(?,?,?,?,?)");
        
       }
       public boolean asignacion(String id,String serie, String nombre, String noempleado, String correo, String jefe,int udn,int cc,String fechaasig,String hostname,String bitlocker,int soporte, String serieanterior, String fechabaja,int status)
    {               
        
            String[] columnas={id,serie,nombre,noempleado,correo,jefe,Integer.toString(udn),Integer.toString(cc),fechaasig,hostname,bitlocker,Integer.toString(soporte),serieanterior,fechabaja,Integer.toString(status)};
            return sen.insertar(columnas, "insert into asignacion(idAsignacion,Equipo_Serie,Nombre,Noempleado,Correo,Jefe,UDN_idUDN,CC_idCC,fechaasig,Hostname,Bitlocker,Soporte_idSoporte,EquipoAnterior,Fechaterm,status_idStatus) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                  
        
    }
       public boolean acualizarEquipo(int status,String Carta,String serie){
           String[] columnas={Integer.toString(status),Carta};
        return sen.insertar(columnas, "update equipo set status_idstatus=?,cartar=? where serie='"+serie+"';");
       
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
