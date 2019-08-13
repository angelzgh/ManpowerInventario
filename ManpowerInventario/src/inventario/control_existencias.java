/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class control_existencias 
{
    
     private Sentencias_sql sen;
     public String Documento;   
     
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
      
        return sen.existencias(cod," from Equipo where serie like '"+"PC0SU"+"%' and serie like "+cod+" ;");
      
    }
   public boolean existe_equipo( String cod)
     {
         
        this.Documento = cod;
      
        return sen.existencias(cod," from Equipo where serie="+cod+";");
      
    }
   public boolean existe_usuario( String cod)
     {
         
        this.Documento = cod;
      
        return sen.existencias(cod," from Asignacion where correo like "+cod+" ;");
      
    }
    public boolean existe_soporte( String cod)
     {
         
        this.Documento = cod;
      
        return sen.existencias(cod," from Asignacion where soporte_idsoporte="+cod+";");
      
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
    public String ingresa_tipo(String nueva)
     { 
       String result;
       result = sen.datos_string("tipo", "select tipo from equipo where serie="+nueva+";");
       return result;
     }
    public String ingresa_marca(String nueva)
     { 
       String result;
       result = sen.datos_string("marca", "select marca from equipo where serie="+nueva+";");
       return result;
     }
    public String ingresa_modelo(String nueva)
     { 
       String result;
       result = sen.datos_string("modelo", "select modelo from equipo where serie="+nueva+";");
       return result;
     }
     
     
     public Object[] combox(String tabla, String campo)
     {
        return sen.poblar_combox(tabla, campo, "select "+campo+" from "+tabla+";");
     }
     public Object[] comboxu(String tabla, String campo)
     {
        return sen.poblar_combox(tabla, campo, "select distinct "+campo+" from "+tabla+" where 1=1;");
     }
     public Object[] comboxE(String tabla, String campo,String serie)
     {
        return sen.poblar_combox(tabla, campo, "select "+campo+" from "+tabla+" where serie="+serie+";");
     }
            
     public String statusbdg(String serie){
         String status = null;
         String tabla;
         if(existe_equipoX270("'%"+serie+"'")){
             tabla=sen.status(serie);
             if (tabla.equals("Asignado")){
             status="1";
             }else if(tabla.equals("En bodega")){
             status="2";
             }else if(tabla.equals("Dañado")){
             status="3";
             }else if(tabla.equals("Garantia")){
             status="4";
             }
         }else{}
                     return status;
                     }
     
     
     
             public Object[][] buscadors(String busca)
     {
        String[] columnas={"Serie","Status_idstatus","Nombre","Noempleado","Correo","udn_idudn","cc_idcc","Jefe","Fechaasig","Hostname","Bitlocker","soporte_idsoporte","Comentarios","Cartar"};
        Object[][] resultado = sen.GetTabla(columnas, "equipo","asignacion", "select e.serie,e.status_idstatus,a.nombre,a.noempleado,a.correo,a.udn_idudn,a.cc_idcc,a.jefe,a.fechaasig,a.hostname,a.hostname,a.soporte_idsoporte,a.bitlocker,e.comentarios,e.cartar from equipo e, asignacion a where e.serie=a.equipo_serie and a.equipo_serie like '"+"PC0SU"+"%' and a.fechaterm='0' and a.equipo_serie like '%"+busca+"' order by a.fechaasig;");
        return resultado;
      }
             public Object[][] buscadoru(String busca)
     {
        String[] columnas={"Serie","Status_idstatus","Nombre","Noempleado","Correo","udn_idudn","cc_idcc","Jefe","Fechaasig","Hostname","Bitlocker","soporte_idsoporte","Comentarios","Cartar"};
        
        Object[][] resultado = sen.GetTabla(columnas, "equipo","asignacion", "select e.serie,e.status_idstatus,a.nombre,a.noempleado,a.correo,a.udn_idudn,a.cc_idcc,a.jefe,a.fechaasig,a.hostname,a.hostname,a.soporte_idsoporte,a.bitlocker,e.comentarios,e.cartar from equipo e, asignacion a where e.serie=a.equipo_serie and a.equipo_serie like '"+"PC0SU"+"%' and a.fechaterm='0' and a.correo like '"+busca+"%' order by a.fechaasig;");
        return resultado;
      }
             public Object[][] buscadorso(String busca)
     {
        String[] columnas={"Serie","Status_idstatus","Nombre","Noempleado","Correo","udn_idudn","cc_idcc","Jefe","Fechaasig","Hostname","Bitlocker","soporte_idsoporte","Comentarios","Cartar"};
        Object[][] resultado = sen.GetTabla(columnas, "equipo","asignacion", "select e.serie,e.status_idstatus,a.nombre,a.noempleado,a.correo,a.udn_idudn,a.cc_idcc,a.jefe,a.fechaasig,a.hostname,a.hostname,a.soporte_idsoporte,a.bitlocker,e.comentarios,e.cartar from equipo e, asignacion a where e.serie=a.equipo_serie and a.equipo_serie like '"+"PC0SU"+"%' and a.fechaterm='0' and a.soporte_idsoporte='"+busca+"' order by a.fechaasig;");
        return resultado;
      } 
             
             public Object[][] buscadorsbdg(String busca)
     {
        String[] columnas={"Serie","Status_idstatus","Comentarios"};
        Object[][] resultado = sen.GetTabla1(columnas,"equipo", "select e.serie,e.status_idstatus,e.comentarios from equipo e where e.serie like '"+"PC0SU"+"%' and e.serie like '%"+busca+"';");
        return resultado;
      }
             public Object[][] buscadorubdg(String busca)
     {
        String[] columnas={"Serie","Status_idstatus","Comentarios"};
        Object[][] resultado = sen.GetTabla(columnas,"asignacion", "equipo", "select e.serie,e.status_idstatus,e.comentarios from equipo e, asignacion a where e.serie=a.equipo_serie and a.equipo_serie like '"+"PC0SU"+"%' and a.fechaterm='0' and a.equipo_serie='"+busca+"' order by a.fechaasig;");
        return resultado;
      }
             public Object[][] buscadorsobdg(String busca)
     {
        String[] columnas={"Serie","Status_idstatus","Comentarios"};
        Object[][] resultado = sen.GetTabla(columnas,"asignacion", "equipo", "select e.serie,e.status_idstatus,e.comentarios from equipo e, asignacion a where e.serie=a.equipo_serie and a.equipo_serie like '"+"PC0SU"+"%' and a.fechaterm='0' and a.equipo_serie='"+busca+"' order by a.fechaasig;");
        return resultado;
      } 
  public Object[][] buscadorhistos(String busca)
     {
        String[] columnas={"Serie","Nombre","Noempleado","Correo","udn_idudn","cc_idcc","Jefe","Fechaasig","Hostname","Bitlocker","soporte_idsoporte","Comentarios","Cartar"};
        Object[][] resultado = sen.GetTabla(columnas, "equipo","asignacion", "select e.serie,a.nombre,a.noempleado,a.correo,a.udn_idudn,a.cc_idcc,a.jefe,a.fechaasig,a.hostname,a.hostname,a.soporte_idsoporte,a.bitlocker,e.comentarios,e.cartar from equipo e, asignacion a where e.serie=a.equipo_serie and a.equipo_serie like '"+"PC0SU"+"%' and a.equipo_serie like '%"+busca+"' order by a.fechaasig;");
        return resultado;
      } 
  public Object[][] buscadorhistou(String busca)
     {
        String[] columnas={"Serie","Nombre","Noempleado","Correo","udn_idudn","cc_idcc","Jefe","Fechaasig","Hostname","Bitlocker","soporte_idsoporte","Comentarios","Cartar"};
        Object[][] resultado = sen.GetTabla(columnas, "equipo","asignacion", "select e.serie,a.nombre,a.noempleado,a.correo,a.udn_idudn,a.cc_idcc,a.jefe,a.fechaasig,a.hostname,a.hostname,a.soporte_idsoporte,a.bitlocker,e.comentarios,e.cartar from equipo e, asignacion a where e.serie=a.equipo_serie and a.equipo_serie like '"+"PC0SU"+"%' and a.fechaterm!='0' and a.correo like '"+busca+"%' order by a.fechaasig;");
        return resultado;
      }        
public Object[][] buscadorhistoso(String busca)
     {
        String[] columnas={"Serie","Nombre","Noempleado","Correo","udn_idudn","cc_idcc","Jefe","Fechaasig","Hostname","Bitlocker","soporte_idsoporte","Comentarios","Cartar"};
        Object[][] resultado = sen.GetTabla(columnas, "equipo","asignacion", "select e.serie,a.nombre,a.noempleado,a.correo,a.udn_idudn,a.cc_idcc,a.jefe,a.fechaasig,a.hostname,a.hostname,a.soporte_idsoporte,a.bitlocker,e.comentarios,e.cartar from equipo e, asignacion a where e.serie=a.equipo_serie and a.equipo_serie like '"+"PC0SU"+"%' and a.fechaterm!='0' and a.soporte_idsoporte='"+busca+"' order by a.fechaasig;");
        return resultado;
      }

      
     
       public boolean asignacion(String id,String serie, String nombre, String noempleado, String correo, String jefe,String udn,String cc,String fechaasig,String hostname,String bitlocker,String soporte, String serieanterior, String fechabaja,String status)
    {               
        boolean insertar = false;
            String[] columnas={id,serie,nombre,noempleado,correo,jefe,udn,cc,fechaasig,hostname,bitlocker,soporte,serieanterior,fechabaja,status};
            insertar=sen.insertar(columnas, "insert into asignacion(idAsignacion,Equipo_Serie,Nombre,Noempleado,Correo,Jefe,UDN_idUDN,CC_idCC,fechaasig,Hostname,Bitlocker,Soporte_idSoporte,EquipoAnterior,Fechaterm,status_idStatus) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            System.out.println("Numero de id:"+id);
            return insertar;                 
    }
    
         public boolean entrada(String id,String remitente, String destinatario, String fecha, String serie, String motivo)
    {               
        
            String[] columnas={id,remitente,destinatario,fecha,serie,motivo};
            return sen.insertar(columnas, "insert into entrada values(?,?,?,?,?,?)");
    }
         public boolean entradag(String id,String fechaE, String fechaS, String comentarios, String serie, String remitente,String destinatario,String idsalida)
    {               
        
            String[] columnas={id,fechaE,fechaS,comentarios,serie,remitente,destinatario,idsalida};
            return sen.insertar(columnas, "insert into garantia(idgarantia,FechaE,FechaS,Comentarios,Equipo_Serie,Remitente,Destinatario,idsalida) values(?,?,?,?,?,?,?,?)");
    }
         public boolean salidaac(String id,String fechas, String accesorio, String destinatario, String soporte)
    {               
        
            String[] columnas={id,fechas,accesorio,destinatario,soporte};
            return sen.insertar(columnas, "insert into salidas values(?,?,?,?,?)");
    }
          public boolean salidaae(String id,String correo, String destinatario, String remitente, String fechas,String serie)
    {               
        
            String[] columnas={id,correo,destinatario,remitente,fechas,serie};
            return sen.insertar(columnas, "insert into salidaae values(?,?,?,?,?,?)");
    }
         public boolean actualizarsg(String fechas,String comentario,String remitente,String destinatario,String idsalida,String serie){
           String[] columnas={fechas,comentario,remitente,destinatario,idsalida};
        return sen.insertar(columnas, "update garantia set fechas=?,comentarios=?,remitente=?,destinatario=?,idsalida=? where equipo_serie='"+serie+"';");
       }
     
      
         public boolean bdg(String id,String serie, String nombre, String noempleado, String correo, String jefe,String udn,String cc,String fechaasig,String hostname,String bitlocker,String soporte, String serieanterior, String fechabaja,String status)
    {               
        
            String[] columnas={id,serie,nombre,noempleado,correo,jefe,udn,cc,fechaasig,hostname,bitlocker,soporte,serieanterior,fechabaja,status};
            return sen.insertar(columnas, "insert into bdg(idbdg,Equipo_Serie,Nombre,Noempleado,Correo,Jefe,UDN_idUDN,CC_idCC,fechaasig,Hostname,Bitlocker,Soporte_idSoporte,EquipoAnterior,Fechaterm,status_idStatus) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    }
        public boolean acualizarEquipoS(String status_idstatus,String comentario,String serie){
           String[] columnas={status_idstatus,comentario};
        return sen.insertar(columnas, "update equipo set status_idstatus=?,comentarios=? where serie='"+serie+"';");
       
       }  
       public boolean acualizarEquipo(String status_idstatus,String Cartar,String comentario,String serie){
           String[] columnas={status_idstatus,Cartar,comentario};
        return sen.insertar(columnas, "update equipo set status_idstatus=? ,cartar=?,comentarios=? where serie='"+serie+"';");
       
       }
       public boolean acualizarEntradas(String status_idstatus,String comentarios,String serie){
           String[] columnas={status_idstatus,comentarios};
        return sen.insertar(columnas, "update equipo set status_idstatus=?, comentarios=? where serie='"+serie+"';");
       }
       public boolean acualizarEntradafG(String fecha,String nombre,String serie){
           String[] columnas={fecha};
        return sen.insertar(columnas, "update asignacion set fechaterm=?  where equipo_serie='"+serie+"' and nombre='"+nombre+"';");
       }
       public boolean acualizarEntradaf(String fecha,String serie){
           String[] columnas={fecha};
        return sen.insertar(columnas, "update asignacion set fechaterm=?  where equipo_serie='"+serie+"';");
       }
        
    

    
        
       
    }
