package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_alerta")
public class TipoAlerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 50, nullable = false)
    private String codigo;

    @Column(name = "nombr", length = 100, nullable = false)
    private String nombr;

    @Column(name = "descri", columnDefinition = "text")
    private String descri;

    public TipoAlerta() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombr() { return nombr; }
    public void setNombr(String nombr) { this.nombr = nombr; }
    public String getDescri() { return descri; }
    public void setDescri(String descri) { this.descri = descri; }
}
