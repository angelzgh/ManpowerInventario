package inventario;

import java.util.Date;

public class PdfVO {

    /*Todo los atributos*/
    String serie;
    String status;
    String nombre;
    String noempleado;
    String correo;
    String udn;
    String cc;
    String jefe;
    Date fecha;
    String hostname;
    String soporte;
    String comentarios;
    byte[] archivopdf;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNoempleado() {
        return noempleado;
    }

    public void setNoempleado(String noempleado) {
        this.noempleado = noempleado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUdn() {
        return udn;
    }

    public void setUdn(String udn) {
        this.udn = udn;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public PdfVO() {
    }

    /*Todo los codigos get*/

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
  



    public byte[] getArchivopdf() {
        return archivopdf;
    }


    /*Todo los codigos set*/




    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }

}
