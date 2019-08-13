package inventario;

import inventario.conexion;
import inventario.PdfVO;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PdfDAO {
 conexion conec = new conexion();

 public ArrayList<PdfVO> Listar_PdfVO(String tipoe) {
        ArrayList<PdfVO> list = new ArrayList<PdfVO>();
        String sql = "select e.serie,e.status_idstatus,a.nombre,a.noempleado,a.correo,a.udn_idudn,a.cc_idcc,a.jefe,a.fechaasig,a.hostname,a.soporte_idsoporte,a.bitlocker,e.comentarios,e.cartar from equipo e, asignacion a where e.serie=a.equipo_serie and a.equipo_serie like '"+tipoe+"%' and a.fechaterm='0' order by a.fechaasig;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.conectado().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO vo = new PdfVO();
                vo.setSerie(rs.getString(1));
                vo.setStatus(rs.getString(2));
                vo.setNombre(rs.getString(3));
                vo.setNoempleado(rs.getString(4));
                vo.setCorreo(rs.getString(5));
                vo.setUdn(rs.getString(6));
                vo.setCc(rs.getString(7));
                vo.setJefe(rs.getString(8));
                vo.setFecha(rs.getDate(9));
                vo.setHostname(rs.getString(10));
                vo.setBitlocker(rs.getString(11));
                vo.setSoporte(rs.getString(12));
                vo.setComentarios(rs.getString(13));
                vo.setArchivopdf(rs.getBytes(14));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return list;
    }

    /*Metodo agregar*/
    public void Agregar_PdfVO(PdfVO vo) {
        String sql = "update equipo set cartar=? where serie='"+vo.getSerie()+"';";
       PreparedStatement ps = null;
        try {
            ps = conec.conectado().prepareStatement(sql);
            ps.setBytes(1, vo.getArchivopdf());
            System.out.println("getArchivopdf"+vo.getArchivopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }


    /*Metodo Modificar*/
    /**
    public void Modificar_PdfVO(PdfVO vo) {
        String sql = "UPDATE pdf SET nombrepdf = ?, archivopdf = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.conectado().prepareStatement(sql);
            ps.setBytes(1, vo.getArchivopdf());
            ps.setInt(3, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar_PdfVO2(PdfVO vo) {
        String sql = "UPDATE pdf SET nombrepdf = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.conectado().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setInt(2, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    /*Metodo Eliminar*/
    public void Eliminar_PdfVO(PdfVO vo) {
        String sql = "DELETE FROM pdf WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.conectado().prepareStatement(sql);
            ps.setString(1, vo.getSerie());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    //Permite mostrar PDF contenido en la base de datos
    public void ejecutar_archivoPDF(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = conec.conectado().prepareStatement("SELECT archivopdf FROM pdf WHERE codigopdf = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();
            conec.desconectar();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }

}
