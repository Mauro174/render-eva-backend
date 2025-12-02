package pe.edu.upc.demoeva.dtos;

public class ObtenerRelacionesporUsuarioDTO {

    private int idRelacion;

    private String tipoRelacion;

    private String parentescoRelacion;

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

    public UsuarioDTO getRelacionado() {
        return relacionado;
    }

    public void setRelacionado(UsuarioDTO relacionado) {
        this.relacionado = relacionado;
    }
}
