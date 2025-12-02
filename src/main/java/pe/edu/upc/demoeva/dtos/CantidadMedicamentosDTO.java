package pe.edu.upc.demoeva.dtos;

public class CantidadMedicamentosDTO {

    private String nombreUsuario;
    private int MedicamentosActivos;
    private int MedicamentosInactivos;
    private int CantidadMedicamentos;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getMedicamentosActivos() {
        return MedicamentosActivos;
    }

    public void setMedicamentosActivos(int medicamentosActivos) {
        MedicamentosActivos = medicamentosActivos;
    }

    public int getMedicamentosInactivos() {
        return MedicamentosInactivos;
    }

    public void setMedicamentosInactivos(int medicamentosInactivos) {
        MedicamentosInactivos = medicamentosInactivos;
    }

    public int getCantidadMedicamentos() {
        return CantidadMedicamentos;
    }

    public void setCantidadMedicamentos(int cantidadMedicamentos) {
        CantidadMedicamentos = cantidadMedicamentos;
    }
}