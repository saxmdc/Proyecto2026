package persistence;

import java.time.LocalDateTime;

public class Reporte {
    private int idReporte;
    private String titulo;
    private String descripcion;
    private String categoria; // Fraude, Soporte, Inconsistencia, Sugerencia
    private String estado;    // Abierto, En revision, Cerrado
    private int prioridad;    // 1 (alta) a 5 (baja)
    private LocalDateTime fechaCreacion;
    private int idUsuarioReporta;

    public Reporte() {
    }

    public Reporte(int idReporte, String titulo, String descripcion, String categoria,
                   String estado, int prioridad, LocalDateTime fechaCreacion, int idUsuarioReporta) {
        this.idReporte = idReporte;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioReporta = idUsuarioReporta;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdUsuarioReporta() {
        return idUsuarioReporta;
    }

    public void setIdUsuarioReporta(int idUsuarioReporta) {
        this.idUsuarioReporta = idUsuarioReporta;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "idReporte=" + idReporte +
                ", titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", estado='" + estado + '\'' +
                ", prioridad=" + prioridad +
                ", fechaCreacion=" + fechaCreacion +
                ", idUsuarioReporta=" + idUsuarioReporta +
                '}';
    }
}
