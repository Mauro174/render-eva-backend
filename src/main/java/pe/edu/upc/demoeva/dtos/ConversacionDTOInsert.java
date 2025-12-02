package pe.edu.upc.demoeva.dtos;

public class ConversacionDTOInsert {
    private Long id;
    private Long usuarioId;
    private String canal;
    private String iniciadaPor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public String getCanal() { return canal; }
    public void setCanal(String canal) { this.canal = canal; }
    public String getIniciadaPor() { return iniciadaPor; }
    public void setIniciadaPor(String iniciadaPor) { this.iniciadaPor = iniciadaPor; }
}
