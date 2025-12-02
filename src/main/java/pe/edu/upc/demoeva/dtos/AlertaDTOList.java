package pe.edu.upc.demoeva.dtos;

import java.time.LocalDateTime;

public class AlertaDTOList {
    private Long id;
    private String nivel;
    private String mensaj;
    private LocalDateTime creada;
    private Long usuarioId;
    private Long tipoId;
    private Long emisorId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getMensaj() { return mensaj; }
    public void setMensaj(String mensaj) { this.mensaj = mensaj; }

    public LocalDateTime getCreada() { return creada; }
    public void setCreada(LocalDateTime creada) { this.creada = creada; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getTipoId() { return tipoId; }
    public void setTipoId(Long tipoId) { this.tipoId = tipoId; }

    public Long getEmisorId() { return emisorId; }
    public void setEmisorId(Long emisorId) { this.emisorId = emisorId; }
}
