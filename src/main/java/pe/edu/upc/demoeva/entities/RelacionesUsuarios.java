package pe.edu.upc.demoeva.entities;

import jakarta.persistence.*;

@Entity
@Table(name="relaciones_usuarios")
public class RelacionesUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRelacion;

    @Column(name = "tipoRelacion", nullable = false, length = 30)
    private String tipoRelacion;

    @Column(name = "parentescoRelacion", nullable = false, length = 30)
    private String parentescoRelacion;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="relacionado_id")
    private Usuario relacionado;

    public RelacionesUsuarios() {
    }

    public RelacionesUsuarios(int idRelacion, String tipoRelacion, String parentescoRelacion, pe.edu.upc.demoeva.entities.Usuario usuario, pe.edu.upc.demoeva.entities.Usuario relacionado) {
        this.idRelacion = idRelacion;
        this.tipoRelacion = tipoRelacion;
        this.parentescoRelacion = parentescoRelacion;
        this.usuario = usuario;
        this.relacionado = relacionado;
    }

    public int getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(int idRelacion) {
        this.idRelacion = idRelacion;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public String getParentescoRelacion() {
        return parentescoRelacion;
    }

    public void setParentescoRelacion(String parentescoRelacion) {
        this.parentescoRelacion = parentescoRelacion;
    }

    public pe.edu.upc.demoeva.entities.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(pe.edu.upc.demoeva.entities.Usuario usuario) {
        this.usuario = usuario;
    }

    public pe.edu.upc.demoeva.entities.Usuario getRelacionado() {
        return relacionado;
    }

    public void setRelacionado(pe.edu.upc.demoeva.entities.Usuario relacionado) {
        this.relacionado = relacionado;
    }
}
