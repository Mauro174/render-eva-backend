package pe.edu.upc.demoeva.dtos;

public class RelacionesUsuariosDTO {
    private int idRelacion;

    private String tipoRelacion;

    private String parentescoRelacion;

    private UsuarioDTO usuario;

    private UsuarioDTO relacionado;

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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioDTO getRelacionado() {
        return relacionado;
    }

    public void setRelacionado(UsuarioDTO relacionado) {
        this.relacionado = relacionado;
    }
}
