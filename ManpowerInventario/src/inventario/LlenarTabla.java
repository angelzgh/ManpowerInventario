package inventario;


import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author JEN
 */
public class LlenarTabla {
    private conexion con;
    PreparedStatement ps;
    ResultSet res;
Sentencias_sql sen;
    public LlenarTabla() {
        con = new conexion();
        sen = new Sentencias_sql();
        
    }
    
    public void llenar_tabla(int numCol,int columBoolean,DefaultTableModel modelo, JTable tabla,String estado){
        try{
            String query="select idudn from udn where estado='"+estado+"' ;";
            res = sen.ejecutarSQLSelect(query);
            //cantidad de columnas=2 contando la columna checkbox
            Object[] filas = new Object[numCol];
            while(res.next()){
//                filas[0]=rs.getString(1);
                for(int i=1;i<=numCol;i++)
                {/*Lavariable columBoolean indica
                 * el número de columna que tendrá los checkbox
                 * es decir la booleana
                 */
                    //si i es igual a la columna checkbox
                    if(i==columBoolean){
                        //por defecto saldrán sin seleccionar, es decir como FALSE
                        filas[columBoolean-1]=Boolean.FALSE;
                    }else{
                        //si no rellenará la tabla con los datos normalmente
                        filas[i-1]=res.getObject(i-1);
                    }
                }
                //añade las filas
                modelo.addRow(filas);
            }tabla.updateUI();//actualiza
            res.close();
        }catch(SQLException | HeadlessException e)
        {System.err.println(e);}
    }
}
