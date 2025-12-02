package pe.edu.upc.demoeva.dtos;

public class CantidadRelacionesporMovilidadDTO {

    private String MovilidadUsuario;
    private int CantidadRelaciones;

    public String getMovilidadUsuario() {
        return MovilidadUsuario;
    }

    public void setMovilidadUsuario(String movilidadUsuario) {
        MovilidadUsuario = movilidadUsuario;
    }

    public int getCantidadRelaciones() {
        return CantidadRelaciones;
    }

    public void setCantidadRelaciones(int cantidadRelaciones) {
        CantidadRelaciones = cantidadRelaciones;
    }
}
