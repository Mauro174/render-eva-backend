package pe.edu.upc.demoeva.dtos;

public class CantidadUsuariossinFamiliaresDTO {
    private String CondicionMedica;
    private int CantidadUsuarios;

    public String getCondicionMedica() {
        return CondicionMedica;
    }

    public void setCondicionMedica(String condicionMedica) {
        CondicionMedica = condicionMedica;
    }

    public int getCantidadUsuarios() {
        return CantidadUsuarios;
    }

    public void setCantidadUsuarios(int cantidadUsuarios) {
        CantidadUsuarios = cantidadUsuarios;
    }
}
