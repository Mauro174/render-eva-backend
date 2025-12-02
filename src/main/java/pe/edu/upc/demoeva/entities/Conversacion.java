package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "conversaciones")
public class Conversacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK: usuario_id
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "canal", length = 40)
    private String canal;

    @Column(name = "iniciada_por", length = 10)
    private String iniciadaPor;

    @Column(name = "creada_en")
    private LocalDateTime creadaEn = LocalDateTime.now();

    public Conversacion() {}
    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public String getCanal() { return canal; }
    public void setCanal(String canal) { this.canal = canal; }
    public String getIniciadaPor() { return iniciadaPor; }
    public void setIniciadaPor(String iniciadaPor) { this.iniciadaPor = iniciadaPor; }
    public LocalDateTime getCreadaEn() { return creadaEn; }
    public void setCreadaEn(LocalDateTime creadaEn) { this.creadaEn = creadaEn; }
}
