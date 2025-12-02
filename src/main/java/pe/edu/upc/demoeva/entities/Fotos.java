package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Fotos")
public class Fotos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

    @Column(name = "url", columnDefinition = "text", nullable = false)
    private String url;

    @Column(name = "titulo", length = 140)
    private String titulo;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;
    @Column(name = "fecha_creacion")
    private LocalDate fecha_Creacion;

    public Fotos() {
    }

    public Fotos(Long id, Usuario idUsuario, String url, String titulo, String descripcion, LocalDate fecha_Creacion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.url = url;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_Creacion = fecha_Creacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public LocalDate getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(LocalDate fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }
}
