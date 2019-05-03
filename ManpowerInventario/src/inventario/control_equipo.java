/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

/**
 *
 * @author agutierrezh
 */
public class control_equipo {
    
    
    Sentencias_sql sensql;
   
    public control_equipo() {
        
        sensql = new Sentencias_sql();
    }

    
    /**
     *
     * @param Date
     */
    
    public boolean ingresar_equipo(String id, String descripcion, int precioventa, int preciocosto, int stock, String tipoart, String codprov, String fechaingreso)
    {               
        
            String datos[] = {id,descripcion,Integer.toString(precioventa),Integer.toString(preciocosto),Integer.toString(stock),tipoart,codprov,fechaingreso};           
            return sensql.insertar(datos, "insert into articulo(id_articulo, descripcion, precio_venta,precio_costo, stock, cod_tipo_articulo, cod_proveedor, fecha_ingreso) values(?,?,?,?,?,?,?,?)");
                                  
        
    }
    
    public Object[][] consulta_equipo(){
        String[] columnas={"Serie","Status_idstatus","Nombre","Noempleado","Correo","udn_idudn","cc_idcc","Jefe","Fechaasig","Hostname","Bitlocker","soporte_idsoporte","Comentarios","Cartar"};
        Object[][] datos = sensql.GetTabla(columnas, "Equipo","Asignacion", "select e.serie,e.status_idstatus,a.nombre,a.noempleado,a.correo,a.udn_idudn,a.cc_idcc,a.jefe,a.fechaasig,a.hostname,a.hostname,a.soporte_idsoporte,a.bitlocker,e.comentarios,e.cartar from equipo e, asignacion a where a.equipo_serie=e.serie and e.serie like '"+"PC0SU"+"%' order by a.fechaasig;");
        return datos;
    }
    
}