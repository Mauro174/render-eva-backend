package pe.edu.upc.demoeva.dtos;

public class TratamientoCompletoDTO {
    private int idusario;
    private String nombreusuario;
    private int cantidadmedicamentos;

    public int getIdusario() {
        return idusario;
    }

    public void setIdusario(int idusario) {
        this.idusario = idusario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public int getCantidadmedicamentos() {
        return cantidadmedicamentos;
    }

    public void setCantidadmedicamentos(int cantidadmedicamentos) {
        this.cantidadmedicamentos = cantidadmedicamentos;
    }
}
