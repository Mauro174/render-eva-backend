package pe.edu.upc.demoeva.dtos;

import java.time.OffsetDateTime;

public class ActividadDTOList {
    private Long id;
    private Long usuarioId;
    private String tipo;
    private String descripcion;
    private OffsetDateTime ocurrioEn;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public OffsetDateTime getOcurrioEn() { return ocurrioEn; }
    public void setOcurrioEn(OffsetDateTime ocurrioEn) { this.ocurrioEn = ocurrioEn; }
}