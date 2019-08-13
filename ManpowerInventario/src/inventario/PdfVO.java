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
    String bitlocker;
    String soporte;
    String comentarios;
    byte[] archivopdf;

    public PdfVO() {
    }

    /*Todo los codigos get*/

    public String getSerie() {
        return serie;
    }

    public String getStatus() {
        return status;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNoempleado() {
        return noempleado;
    }

    public String getCorreo() {
        return correo;
    }

    public String getUdn() {
        return udn;
    }

    public String getCc() {
        return cc;
    }

    public String getJefe() {
        return jefe;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHostname() {
        return hostname;
    }

    public String getBitlocker() {
        return bitlocker;
    }

    public String getSoporte() {
        return soporte;
    }

    public String getComentarios() {
        return comentarios;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNoempleado(String noempleado) {
        this.noempleado = noempleado;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setUdn(String udn) {
        this.udn = udn;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setBitlocker(String bitlocker) {
        this.bitlocker = bitlocker;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }


}
