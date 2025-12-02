package pe.edu.upc.demoeva.servicesinterfaces;

import pe.edu.upc.demoeva.entities.HorariosMedicacion;

import java.util.List;

public interface HorarioMedicacionService {
    public void insertar(HorariosMedicacion hm);
    public List<HorariosMedicacion> listar();
    public void update(HorariosMedicacion f);
    public void delete(Long id);
}
