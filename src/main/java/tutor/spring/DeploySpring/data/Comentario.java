package tutor.spring.DeploySpring.data;

import java.sql.Date;
import java.time.LocalDate;

public class Comentario {

    private String nombre;
    private Date fecha;
    private String texto;

    public Comentario() {
        this.nombre = "";
        this.fecha = Date.valueOf(LocalDate.now());
        this.texto = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Comentario{" + "nombre=" + nombre + ", fecha=" + fecha + ", texto=" + texto + '}';
    }
}
