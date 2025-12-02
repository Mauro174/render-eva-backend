package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "actividades")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "tipo", length = 40, nullable = false)
    private String tipo;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "ocurrio_en", columnDefinition = "timestamptz")
    private OffsetDateTime ocurrioEn;

    public Actividad() { }

    public Actividad(Long id, Usuario usuario, String tipo, String descripcion, OffsetDateTime ocurrioEn) {
        this.id = id;
        this.usuario = usuario;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ocurrioEn = ocurrioEn;
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public OffsetDateTime getOcurrioEn() { return ocurrioEn; }
    public void setOcurrioEn(OffsetDateTime ocurrioEn) { this.ocurrioEn = ocurrioEn; }
}
