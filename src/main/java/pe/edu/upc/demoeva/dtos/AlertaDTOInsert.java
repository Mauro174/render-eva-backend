package pe.edu.upc.demoeva.dtos;

public class AlertaDTOInsert {
    private Long usuarioId;
    private Long tipoId;
    private String nivel;
    private String mensaj;
    private Long emisorId;

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getTipoId() { return tipoId; }
    public void setTipoId(Long tipoId) { this.tipoId = tipoId; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getMensaj() { return mensaj; }
    public void setMensaj(String mensaj) { this.mensaj = mensaj; }

    public Long getEmisorId() { return emisorId; }
    public void setEmisorId(Long emisorId) { this.emisorId = emisorId; }
}
