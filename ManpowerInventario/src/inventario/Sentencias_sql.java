
package inventario;

import com.sun.crypto.provider.RSACipher;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDRES
 */
public class Sentencias_sql {
    
    private conexion con;
    PreparedStatement ps;
    ResultSet res;

    public Sentencias_sql() {
        con = new conexion();
    }
    
    public boolean insertar(String datos[], String insert){
      boolean estado = false;
       try {
            ps = con.conectado().prepareStatement(insert);
            for(int i=0; i<=datos.length-1;i++){
                ps.setString(i+1, datos[i]);
            }
            ps.execute();
            ps.close();
            estado = true;
         }catch(SQLException e){
         System.out.println(e);
      }
       return estado;
   }
    
     public Object [][] GetTabla(String colName[], String tabla,String tabla2, String sql){
      int registros = 0;
      
      try{
         ps = con.conectado().prepareStatement("select count(*) as total from " + tabla+ "," + tabla2);
         res = ps.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
     


    Object[][] data = new String[registros][colName.length];
    String col[] = new String[colName.length];
    
      try{
         ps = con.conectado().prepareStatement(sql);
         res = ps.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=colName.length-1;j++){
                col[j] = res.getString(colName[j]);
                data[i][j] = col[j];
            }
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
       public Object [][] GetTabla1(String colName[], String tabla, String sql){
      int registros = 0;
      
      try{
         ps = con.conectado().prepareStatement("select count(*) as total from " + tabla);
         res = ps.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
     


    Object[][] data = new String[registros][colName.length];
    String col[] = new String[colName.length];
    
      try{
         ps = con.conectado().prepareStatement(sql);
         res = ps.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=colName.length-1;j++){
                col[j] = res.getString(colName[j]);
                data[i][j] = col[j];
            }
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
           public ResultSet ejecutarSQLSelect(String sql)
    {
       try {
          PreparedStatement sentencia = con.conectado().prepareStatement(sql);
          res = sentencia.executeQuery();
          return res;
       } catch (SQLException ex) {
          System.err.println("Error "+ex);
          return null;
       }
    }
     
     public boolean existencias(String campo, String from_where){
     int registros = 0;
     try{
         ps = con.conectado().prepareStatement("SELECT count("+campo+") as total  " + from_where);
         System.out.println("Campo:"+campo);
         res = ps.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
     
     if (registros >0)
     {return true;
     }
     else
     {
         return false;
     }
  }
    
     public String datos_string(String nombre_columna, String sentenciasql){
        
    String datos ="";
      try{
         ps = con.conectado().prepareStatement(sentenciasql);
         res = ps.executeQuery();
         while(res.next()){
            datos = res.getString(nombre_columna);
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
    }
     public String status(String serie) {
String status = null;
         try{
         ps = con.conectado().prepareStatement("SELECT status_idstatus from equipo where serie like '%"+serie+"';");
         res = ps.executeQuery();
         res.next();
         status = res.getString(1);
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
return status;
}
     public Object[] poblar_combox(String tabla, String nombrecol, String sql){
      int registros = 0;      
      try{
         ps = con.conectado().prepareStatement("SELECT count(*) as total FROM " + tabla);
         res = ps.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }

    Object[] datos = new Object[registros];
      try{
         ps = con.conectado().prepareStatement(sql);
         res = ps.executeQuery();
         int i = 0;
         while(res.next()){
            datos[i] = res.getObject(nombrecol);
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
 }
 
     
     
     }
    

