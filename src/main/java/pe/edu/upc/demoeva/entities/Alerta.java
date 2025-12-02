package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuario dueño de la alerta
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Tipo de alerta
    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false)
    private TipoAlerta tipo;

    @Column(name = "nivel", length = 10)
    private String nivel;

    @Column(name = "mensaj", columnDefinition = "text", nullable = false)
    private String mensaj;

    // Usuario emisor (opcional)
    @ManyToOne
    @JoinColumn(name = "emisor_id")
    private Usuario emisor;

    @Column(name = "creada_", nullable = false)
    private LocalDateTime creada = LocalDateTime.now();

    public Alerta() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public TipoAlerta getTipo() { return tipo; }
    public void setTipo(TipoAlerta tipo) { this.tipo = tipo; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getMensaj() { return mensaj; }
    public void setMensaj(String mensaj) { this.mensaj = mensaj; }

    public Usuario getEmisor() { return emisor; }
    public void setEmisor(Usuario emisor) { this.emisor = emisor; }

    public LocalDateTime getCreada() { return creada; }
    public void setCreada(LocalDateTime creada) { this.creada = creada; }
}
