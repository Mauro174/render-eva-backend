package pe.edu.upc.demoeva.dtos;

public class MedicamentoDTOList {
    private Long id;
    private String nombre;
    private String dosis;
    private String via;
    private Boolean activo;
    private Long usuarioId;  // para saber a qué usuario pertenece

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDosis() { return dosis; }
    public void setDosis(String dosis) { this.dosis = dosis; }
    public String getVia() { return via; }
    public void setVia(String via) { this.via = via; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
